package com.example.materialepladsen.API

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("/")
    suspend fun getJson_requestOrderNew(
        @Query("user") user: String,
        @Query("password") password: String,
        @Query("request") request: String,
        @Query("type") type: String,
        @Query("customerid") customerid: String,
        @Query("licenseplate") licenseplate: String
    ): Response<JsonObject>

    companion object {
        operator fun invoke(): RetrofitAPI {
            return Retrofit.Builder()
                .baseUrl("http://152.115.71.190:41000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitAPI::class.java)
        }
    }
}

suspend fun main() {
    val api = RetrofitAPI()
    val jsonResponse = api.getJson_requestOrderNew("DTUMP3","MPor2hRrSE","EC02E425-B6BD-4D82-A9A2-F58507385B41", "requestOrderNew","12542","CC11345")
    println(jsonResponse.body())
}