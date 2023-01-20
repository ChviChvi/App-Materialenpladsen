package com.example.materialepladsen.SERVER.Network.Network1

/**

To figure this out I have used different snippets of code from:
https://www.section.io/engineering-education/making-http-requests-with-ktor-in-android/?fbclid=IwAR2ewsu2M9PnZALt7JjpOisFFVGd9-GSPks-CbAg_a6jZf0NZ5Q2j_XFl7E
https://www.youtube.com/watch?v=FV8xapfFYzw&ab_channel=MetehanBOLAT

 **/


import com.example.materialepladsen.SERVER.Network.ApiRoutes
import com.example.materialepladsen.SERVER.Network.Models.RequestModel
import com.example.materialepladsen.SERVER.Network.Models.ResponseModel
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

    override suspend fun getProducts(): List<ResponseModel> {
        return try {
            client.get { url(ApiRoutes.PRODUCTS) }
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            emptyList()
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            emptyList()
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            emptyList()
        }catch (ex: ServerResponseException) {
            println("Error: ${ex.message}")
            emptyList()
        }
    }



    override suspend fun createProducts(productRequest: RequestModel): ResponseModel? {
        return try {

            client.post<ResponseModel> {
                url(ApiRoutes.PRODUCTS)
                body = productRequest
            }
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.message}")
            null
        }

    }
}