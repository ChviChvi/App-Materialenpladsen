package com.example.materialepladsen.SERVER.Network.Network1

import com.example.materialepladsen.SERVER.Network.Models.RequestModel
import com.example.materialepladsen.SERVER.Network.Models.ResponseModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

/**

To figure this out I have used different snippets of code from:
https://www.section.io/engineering-education/making-http-requests-with-ktor-in-android/?fbclid=IwAR2ewsu2M9PnZALt7JjpOisFFVGd9-GSPks-CbAg_a6jZf0NZ5Q2j_XFl7E
https://www.youtube.com/watch?v=FV8xapfFYzw&ab_channel=MetehanBOLAT

 **/


interface ApiService {

    suspend fun getProducts(): List<ResponseModel>

    suspend fun createProducts(productRequest: RequestModel): ResponseModel?

    //suspend fun getDataFromSQL(productRequest: RequestModel): ResponseModel?

    companion object  {
        fun create(): ApiService {
            return ApiServiceImpl(
                client = HttpClient(Android) {
                    // Logging
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    // JSON
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(json)
                        //or serializer = KotlinxSerializer()
                    }
                    // Timeout
//                    install(HttpTimeout) {
//                        requestTimeoutMillis = 15000L
//                        connectTimeoutMillis = 15000L
//                        socketTimeoutMillis = 15000L
//                    }
//                    // Apply to all requests
//                    defaultRequest {
//                        // Parameter("api_key", "some_api_key")
//                        // Content Type
//                        if (method != HttpMethod.Get) contentType(ContentType.Application.Json)
//                        accept(ContentType.Application.Json)
//                    }
                }
            )
        }



        private val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }


    }
}