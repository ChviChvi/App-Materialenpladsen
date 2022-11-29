package com.example.materialepladsen.API

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import java.io.IOException

data class API(
    val username: String = "DTUMP3",
    val password: String = "MPor2hRrSE",
    val newOrderRequest: String = "&request=EC02E425-B6BD-4D82-A9A2-F58507385B41&type=requestOrderNew&customerid=§&licenseplate=§", // dont use § - just for testing
    val weighIn: String = "&request=412084F3-98C2-48BA-A322-5CFDCD4E5410&type=requestOrderWeighing&customerid=$&licenseplate=$&ordernumber=$",
    val url: String = "http://152.115.71.190:41000/?user=$username&password=$password",
    val client: OkHttpClient = OkHttpClient()
)

/* Data class matching the following json example

    "Created": "2022-11-23T13:58:12.5846881+01:00",
    "Closed": "0001-01-01T00:00:00",
    "Site": null,
    "SiteId": -1,
    "TypeId": 1,
    "Licenseplate": "215721",
    "WeightUnit": "Kg.",
    "WeightIn": -1,
    "WeightOut": -1,
    "WeightProduct": -1,
    "OrderNumber": -1,
    "CustomerId": 215632,
    "Description": "warning, no vehicle with that licensplate found",
    "ErrCode": 202,
    "QueueStateId": -1

 */
@Serializable
data class NewOrderModel(
    val Created: String,
    val Closed: String,
    val Site: String?,
    val SiteId: Int,
    val TypeId: Int,
    val Licenseplate: String,
    val WeightUnit: String,
    val WeightIn: Int,
    val WeightOut: Int,
    val WeightProduct: Int,
    val OrderNumber: Int,
    val CustomerId: Int,
    val Description: String,
    val ErrCode: Int,
    val QueueStateId: Int
)

fun run(url: String, callback: Callback) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).enqueue(callback)
}

fun newOrder(customerId: String, licensePlate: String): NewOrderModel? {
    var newOrder: NewOrderModel? = null
    run(API().url + API().newOrderRequest.replace("§", customerId).replace("§", licensePlate),
        object : Callback {
        override fun onFailure(call: Call, e: IOException) {

        }
        override fun onResponse(call: Call, response: Response) {
            newOrder = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
        }
    })
    return newOrder
}

fun weighIn(customerId: String, licensePlate: String, ordreNumber: String): NewOrderModel? {
    var newOrder: NewOrderModel? = null
    run(API().url + API().weighIn.replace("§", customerId).replace("§", licensePlate).replace("§", ordreNumber),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                newOrder = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return newOrder
}

fun main() {
    //val url = "http://152.115.71.190:41000/?user=DTUMP3&password=MPor2hRrSE&request=EC02E425-B6BD-4D82-A9A2-F58507385B41&type=requestOrderNew&customerid=215632&licenseplate=215721"
    println(newOrder("215632", "215721")?.ErrCode ?: "null")
}