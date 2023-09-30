package com.canpurcek.jetpackcomposepractices

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.canpurcek.jetpackcomposepractices.retrofit.JSON.PersonResponse
import com.canpurcek.jetpackcomposepractices.retrofit.utils.APIUtils
import com.canpurcek.jetpackcomposepractices.room.database.DataBase
import com.canpurcek.jetpackcomposepractices.ui.theme.JetpackComposePracticesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracticesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    RoomPractices()
                    RetrofitPractices()

                }
            }
        }
    }
}

@Composable
fun RoomPractices(){
    val context = LocalContext.current
    val dB = DataBase.databaseAccess(context)!!

    LaunchedEffect(key1 = true){
        allPerson(dB)
    }
}

fun allPerson(dB: DataBase){
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val list = dB.personDao().allPerson()

        for (k in list){
            Log.e("KEY","VALUE")
            Log.e("Person ID", k.personId.toString())
            Log.e("Person Name", k.name.toString())
            Log.e("Person Number", k.number.toString())

        }
    }
}

@Composable
fun RetrofitPractices(){

    LaunchedEffect(key1 = true){
        allPerson()
    }
}

fun allPerson(){
    val personDaoInterface = APIUtils.getPersonDaoInterface()

    personDaoInterface.allPerson().enqueue(object : Callback<PersonResponse> {
        override fun onResponse(call: Call<PersonResponse>, response: Response<PersonResponse>){
            val list = response.body()!!.person

            for(k in list){
                Log.e("*****RETROFIT*****","*****RETROFIT*****")
                Log.e("Person ID",k.person_id.toString())
                Log.e("Person Name",k.name)
                Log.e("Persone Number",k.number)
            }

        }

        override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}

