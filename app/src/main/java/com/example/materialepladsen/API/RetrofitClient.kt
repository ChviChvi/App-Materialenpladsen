package com.example.materialepladsen.API



import android.util.Log
import retrofit2.Retrofit
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {
    @GET("/?user=DTUMP3&password=MPor2hRrSE&request=EC02E425-B6BD-4D82-A9A2-F58507385B41&type=requestOrderNew&customerid=12542&licenseplate=CC11345")
//    @GET("/"
//            +"user={user}&password={pass}&request={request}&type={type}&customerid={customerid}&licenseplate={licenseplate}"
//    )
    fun getData(
//        @Query("user") user: String,
//        @Query("password") pass: String,
//        @Query("request") request: String,
//        @Query("type") type: String,
//        @Query("customerid") customerid: Int,
//        @Query("licenseplate") licenseplate: String,
//      //  @Query("ordrenumber") ordrenumber: Int,
//      //  @Query("site") site: Int?
    ): Call<ResponseBody>
}

const val username = "DTUMP3"
const val password = "MPor2hRrSE"

const val typeGATE = "requestIOCbarrier"
const val typePAY = "requestOrderPayment"
const val typeMELLEM = "requestOrderWeighing"
const val typeSTART = "requestOrderNew"

const val requestGATE = "79FD22F6-66DD-4249-810C-839C28130C11"
const val requestPAY = "DCA382A0-F943-4A76-AE8E-CF894E2B2A7B"
const val requestMELLEM = "=412084F3-98C2-48BA-A322-5CFDCD4E5410"
const val requestSTART = "EC02E425-B6BD-4D82-A9A2-F58507385B41"

const val baseUrl = "http://152.115.71.190:41000"


fun startRetrofit(): Call<ResponseBody> {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(MyApi::class.java)
    val call = api.getData(
        //"DTUMP3", "MPor2hRrSE","EC02E425-B6BD-4D82-A9A2-F58507385B41", "requestOrderNew", 12542, "CC11345"
       // , null,null
    )
//    call.enqueue(object : Callback<ResponseBody> {
//
//
//        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//            if (response.isSuccessful) {
//                val data = response.body()?.string()
//                if (data != null) {
//                    Log.d("Retrofit", data)
//                }
//            } else {
//                Log.d("Retrofit", "Request not successful, code: ${response.code()}")
//            }
//        }
//
//        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//            Log.d("Retrofit", "Request failed, error: ${t.message}")
//        }
//    })
    return call
}

//fun startRetrofit1(
//    Type: String,
//    CustromerID: Int?,
//    Licenseplate: String?,
//    Ordrenumber: Int?,
//    siteid: Int?
//): Call<ResponseBody>? {
//
//    var call: Call<ResponseBody>? = null
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(baseUrl)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    val api = retrofit.create(MyApi::class.java)
//
//
//    if(Type == typeSTART){
//        call = api.getData(
//            username,
//            password,
//            requestSTART,
//            typeSTART,
//            CustromerID!!,
//            Licenseplate!!,
//            Ordrenumber!!,
//            null)
//    }
//    if(Type == typeMELLEM){
//         call = api.getData(
//            username,
//            password,
//            requestMELLEM,
//            typeMELLEM,
//            CustromerID!!,
//            Licenseplate!!,
//            Ordrenumber!!,
//             null)
//    }
//    if(Type == typePAY){
//         call = api.getData(
//            username,
//            password,
//            requestPAY,
//            typePAY,
//            CustromerID!!,
//            Licenseplate!!,
//            Ordrenumber!!,
//            null)
//    }
//    if(Type == typeGATE){
//        call = api.getData(
//            username,
//            password,
//            requestGATE,
//            typeGATE,
//            null,
//            null,
//            null,
//            siteid)
//    }
//
//    //just logs things.
////    call?.enqueue(object : Callback<ResponseBody> {
////        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
////            if (response.isSuccessful) {
////                val data = response.body()?.string()
////                if (data != null) {
////                    Log.d("Retrofit", data)
////                }
////            } else {
////                Log.d("Retrofit", "Request not successful, code: ${response.code()}")
////            }
////        }
////        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
////            Log.d("Retrofit", "Request failed, error: ${t.message}")
////        }
////    })
//    return call
//}

//fun startRetrofit2(
//    Type: String,
//    CustromerID: Int?,
//    Licenseplate: String?,
//    Ordrenumber: Int?,
//    siteid: Int?
//): Call<ResponseBody>? {
//
//    val request = when (Type) {
//        typeSTART -> requestSTART
//        typeGATE -> requestGATE
//        typePAY -> requestPAY
//        typeMELLEM -> requestMELLEM
//        else -> null
//    }
//
//    if (request == null) return null
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(baseUrl)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val api = retrofit.create(MyApi::class.java)
//    return api.getData(username, password, request, Type, CustromerID, Licenseplate, Ordrenumber, siteid)
//}

fun main() {
    print(startRetrofit())
    //startRetrofit2(typeSTART,12562,"DA65205",null,null)
}

//
//interface MyApi {
//    @GET("/")
//    fun getData(
//        @Query("query?") query: String,
//        //@Query("databaseName") database: String,
//        //@Query("user") username: String,
//        //@Query("password") password: String
//               )
//    : Call<ResponseBody>
//}
//
//val server = "152.115.71.190:48123"
//const val database = "materialepladsen_core_DTUMP3"
//const val username = "DTUMP3"
//const val password = "MPor2hRrSE"
//const val QQeury = "SELECT * FROM [dbo].[v_mobileApp_products]"
//
//fun startRetrofit() {
//
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl("http://152.115.71.190:48123/?")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    val api = retrofit.create(MyApi::class.java)
//    val call = api.getData(
//        QQeury
//        //username, password, database
//        )
//
//    // http://152.115.71.190:41000/?
//    // user=DTUMP3&password=MPor2hRrSE
//    // &request=412084F3-98C2-48BA-A322-5CFDCD4E5410
//    // &type=requestOrderWeighing
//    // &customerid=12542
//    // &licenseplate=CC11345
//    // &ordrenummer=2000005
//
//    call.enqueue(object : Callback<ResponseBody> {
//
//        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//            // Log the request headers
//            Log.d("Retrofit", "Request headers: ${call.request().headers()}")
//            // Log the response headers
//            Log.d("Retrofit", "Response headers: ${response.headers()}")
//            // Log the response code
//            Log.d("Retrofit", "Response code: ${response.code()}")
//            // Log the response message
//            Log.d("Retrofit", "Response message: ${response.message()}")
//            if (response.isSuccessful) {
//                val data = response.body()?.string()
//                if (data != null) {
//                    Log.d("Retrofit", data)
//                }
//            } else {
//                Log.d("Retrofit", "Request not successful, code: ${response.code()}")
//            }
//        }
//
//        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//            Log.d("Retrofit", "Request failed, error: ${t.message}")
//        }
//    })
//}