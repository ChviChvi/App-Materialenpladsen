package com.example.materialepladsen.SERVER.Network

/**

To figure this out I have used different snippets of code from:
https://www.section.io/engineering-education/making-http-requests-with-ktor-in-android/?fbclid=IwAR2ewsu2M9PnZALt7JjpOisFFVGd9-GSPks-CbAg_a6jZf0NZ5Q2j_XFl7E
https://www.youtube.com/watch?v=FV8xapfFYzw&ab_channel=MetehanBOLAT

 **/


object ApiRoutes {
    private const val BASE_URL = "http://192.168.0.4:8080"
    const val PRODUCTS = "$BASE_URL/products"
}