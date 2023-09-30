package com.canpurcek.jetpackcomposepractices.retrofit.dao

import com.canpurcek.jetpackcomposepractices.retrofit.JSON.CRUDResponse
import com.canpurcek.jetpackcomposepractices.retrofit.JSON.PersonResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface PersonDaoInterface {
        @GET("retrofit/all_person.php")
        fun allPerson(): Call<PersonResponse>

        @POST("retrofit/all_person_query.php")
        @FormUrlEncoded
        fun personQuery(@Field("name") name: String): Call<PersonResponse>

        @POST("retrofit/delete_person.php")
        @FormUrlEncoded
        fun deletePerson(@Field("person_id") person_id: Int): Call<CRUDResponse>

        @POST("retrofit/insert_person.php")
        @FormUrlEncoded
        fun instertPerson(
        @Field("name") name: String,
        @Field("number") number: String
        ): Call<CRUDResponse>

        @POST("retrofit/update_person.php")
        @FormUrlEncoded
        fun updatePerson(
        @Field("person_id") person_id: Int,
        @Field("name") name: String,
        @Field("number") number: String
        ): Call<CRUDResponse>


}