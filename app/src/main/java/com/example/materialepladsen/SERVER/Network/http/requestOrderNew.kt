package com.example.materialepladsen.SERVER.Network.http

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

//val client = HttpClient()
//val url = "HTTP://152.115.71.190:41000"
//val parameters = listOf("user" to "DTUMP3", "password" to "MPor2hRrSE", "request" to "EC02E425-B6BD-4D82-A9A2-F58507385B41", "type" to "requestOrderNew", "customerid" to "12542", "licenseplate" to "CC11345")
//
//suspend fun newOrder(): HttpStatement {
//    val response = client.get<HttpStatement>(url) {
//
//        parameters.forEach { (key, value) ->
//            parameter(key, value)
//        }
//
//    }
//    return response
//}
//HTTP://152.115.71.190:41000/?user=DTUMP3&password=MPor2hRrSE&request=EC02E425-B6BD-4D82-A9A2-F58507385B41&type=requestOrderNew&customerid=12542&licenseplate=CC11345

val request1 = "EC02E425-B6BD-4D82-A9A2-F58507385B41"
val type1 = "requestOrderNew"
//val customerid = "12542"
//val licenseplate = "CC11345"

suspend fun requestOrderNew(customerid: String, licenseplate:String): HttpStatement {

    val parameters = listOf("user" to user, "password" to password, "request" to request1, "type" to type1, "customerid" to customerid, "licenseplate" to licenseplate)

    val response = client.get<HttpStatement>(url) {
        parameters.forEach { (key, value) ->
            parameter(key, value)
        }
    }
    return response
}


