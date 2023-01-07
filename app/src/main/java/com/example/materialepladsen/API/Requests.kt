package com.example.materialepladsen.API

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import java.io.IOException


data class API(
    val username: String= "",
    val password: String= "",
    val newOrder: String= "",
    val weighIn: String= "",
    val paymentOrder: String= "",
    val iocBarrier: String= "",
    var webcamSnapshot: Int = 0,
    var weightRequest: Int = 0,
    val url: String = "",
    val client: OkHttpClient = OkHttpClient()
){
    fun replacewebcamSnapshot(newSnapshot: Int) {
        webcamSnapshot = newSnapshot
    }
    fun replaceweightRequest(newSnapshot: Int) {
        weightRequest = newSnapshot
    }
}

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

fun newOrder(url: String,customerId: String, licensePlate: String): NewOrderModel? {
    var newOrder: NewOrderModel? = null
    run(url + API().newOrder.replace("§", customerId).replace("§", licensePlate),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                newOrder = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return newOrder
}

fun weighIn(url: String,customerId: String, licensePlate: String, ordreNumber: String): NewOrderModel? {
    var weighIn: NewOrderModel? = null
    run(url + API().weighIn.replace("§", customerId).replace("§", licensePlate).replace("§", ordreNumber),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                weighIn = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return weighIn
}

fun paymentOrder(url: String,customerId: String, licensePlate: String, ordreNumber: String): NewOrderModel? {
    var paymentOrder: NewOrderModel? = null
    run(url + API().paymentOrder.replace("§", customerId).replace("§", licensePlate).replace("§", ordreNumber),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                paymentOrder = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return paymentOrder
}

fun iocBarrier(url: String,siteID: String): NewOrderModel? {
    var iocBarrier: NewOrderModel? = null
    run(url + API().iocBarrier.replace("§", siteID),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                iocBarrier = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return iocBarrier
}

fun webcamSnapshot(url: String,siteID: Int): NewOrderModel? {
    var webcamSnapshot: NewOrderModel? = null
    run(url + API().replacewebcamSnapshot(siteID),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                webcamSnapshot = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return webcamSnapshot
}


fun weightRequest(url: String, siteID: Int): NewOrderModel? {
    var weightRequest: NewOrderModel? = null
    run(url + API().replaceweightRequest(siteID),
        object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }
            override fun onResponse(call: Call, response: Response) {
                weightRequest = Json.decodeFromString<NewOrderModel>(response.body()?.string() ?: "")
            }
        })
    return weightRequest
}

//url

fun main() {
    val url = "http://152.115.71.190:41000/?user=DTUMP3&password=MPor2hRrSE&request=EC02E425-B6BD-4D82-A9A2-F58507385B41&type=requestOrderNew&customerid=215632&licenseplate=215721"
    println(newOrder(url,"215632", "215721")?.ErrCode ?: "null")
}