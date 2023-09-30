package com.canpurcek.jetpackcomposepractices.retrofit.utils

import com.canpurcek.jetpackcomposepractices.retrofit.client.RetrofitClient
import com.canpurcek.jetpackcomposepractices.retrofit.dao.PersonDaoInterface


class APIUtils {
    companion object{
        val BASE_URL = "https://emrecanpurcek.com.tr/"

        fun getPersonDaoInterface():PersonDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(PersonDaoInterface::class.java)
        }
    }
}