package com.example.materialepladsen.SERVER.Network.http

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

//152.115.71.190:41000/?user=DTUMP3&password=MPor2hRrSE&request=DCA382A0-F943-4A76-AE8E-CF894E2B2A7B
// &type=requestOrderPayment
// &customerid=12542
// &licenseplate=CC11345
// &ordernumber=2000003
val request2 = "DCA382A0-F943-4A76-AE8E-CF894E2B2A7B"
val type2 = "requestOrderPayment"
//val customerid = "12542"
//val licenseplate = "CC11345"

suspend fun requestOrderPayment(customerid: String, licenseplate:String,ordernumber:String): HttpStatement {

    val parameters = listOf("user" to user, "password" to password, "request" to request2, "type" to type2, "customerid" to customerid, "licenseplate" to licenseplate,"ordernumber" to ordernumber)

    val response = client.get<HttpStatement>(url) {
        parameters.forEach { (key, value) ->
            parameter(key, value)
        }
    }
    return response
}