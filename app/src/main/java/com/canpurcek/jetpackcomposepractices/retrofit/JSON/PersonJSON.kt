package com.canpurcek.jetpackcomposepractices.retrofit.JSON

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonJSON(
    @SerializedName("person_id")
    @Expose
    var person_id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("number")
    @Expose
    var number: String

)
