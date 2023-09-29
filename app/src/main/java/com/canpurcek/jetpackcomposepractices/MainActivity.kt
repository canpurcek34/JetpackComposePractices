package com.canpurcek.jetpackcomposepractices

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.canpurcek.jetpackcomposepractices.database.DataBase
import com.canpurcek.jetpackcomposepractices.ui.theme.JetpackComposePracticesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

                    JetpackCompose()

                }
            }
        }
    }
}

@Composable
fun JetpackCompose(){
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

