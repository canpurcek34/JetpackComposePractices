package com.canpurcek.jetpackcomposepractices.retrofit.JSON

import com.canpurcek.jetpackcomposepractices.retrofit.JSON.PersonJSON
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonResponse(
    @SerializedName("person")
    @Expose
    var person: List<PersonJSON>,
    @SerializedName("success")
    @Expose
    var success: Int
)
