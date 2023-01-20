package com.example.apiserver

/**

 To figure this out I have used different snippets of code from:
 https://www.section.io/engineering-education/making-http-requests-with-ktor-in-android/?fbclid=IwAR2ewsu2M9PnZALt7JjpOisFFVGd9-GSPks-CbAg_a6jZf0NZ5Q2j_XFl7E
 https://www.youtube.com/watch?v=FV8xapfFYzw&ab_channel=MetehanBOLAT

 **/

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.net.http.HttpClient
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

    data class Product(
        val group: String,
        val id: String,
        val articleNumber: String,
        val articleName: String,
        val size: String?,
        val weightM3: String,
        val priceExcludeTax: String,
        val priceIncludeTax: String,
        val unit: String,
        val availability: String?,
        val imageURL: String?
    )

    fun main() {
        val server = embeddedServer(Netty, port = 8080) {
            routing {

                //Gets all the products
                get("/products") {
                    val products = getProductsFromSQL()
                    call.respondText(products.toString(), contentType = ContentType.Application.Json)
                }




            }
        }
        server.start(wait = true)
    }




    fun getProductsFromSQL(): JsonArray {
        val products = mutableListOf<Product>()

        val server = "152.115.71.190:48123"
        val database = "materialepladsen_core_DTUMP3"
        val username = "DTUMP3"
        val password = "MPor2hRrSE"

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val connectionUrl =
            "jdbc:sqlserver://$server;databaseName=$database;user=$username;password=$password;encrypt=false;trustServerCertificate=true"
        var connection: Connection? = null
        try {
            connection = DriverManager.getConnection(connectionUrl)
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        connection?.let {
            val statement: Statement = it.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM dbo.v_mobileApp_products")
            while (resultSet.next()) {
                val product = Product(
                    resultSet.getString("product_group"),
                    resultSet.getString("id"),
                    resultSet.getString("product_articlenumber"),
                    resultSet.getString("product_articleName"),
                    resultSet.getString("product_size"),
                    resultSet.getString("product_WeightM3"),
                    resultSet.getString("product_price_dkk_excludingTax"),
                    resultSet.getString("product_price_dkk_includingTax"),
                    resultSet.getString("unit"),
                    resultSet.getString("availability"),
                    resultSet.getString("product_image")
                )
                products.add(product)
            }
        }
        val gson = Gson()
        val end = gson.toJsonTree(products).asJsonArray//fromJson(gson.toJson(products), JsonObject::class.java)
        println(end)
        return end
    }
