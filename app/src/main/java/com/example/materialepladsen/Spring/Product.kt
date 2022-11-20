package com.example.materialepladsen.Spring

import com.example.materialepladsen.Database.DBTablePrinter
import com.example.materialepladsen.Database.DatabaseConstants
import com.example.materialepladsen.Database.printTable
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


data class Product(
    val group: String,
    val id: String,
    val articleNumber: String,
    val articleName: String,
    val size: String,
    val weightM3: String,
    val priceExcludeTax: String,
    val priceIncludeTax: String,
    val unit: String,
    val availability: String,
    val imageURL: String
)

fun main() {
    var resultSet: ResultSet? = null
    try {
        val connection = DriverManager.getConnection(DatabaseConstants().connectionUrl)
        if (connection.isValid(0)) {
            println("Connection established")
        }

        val statement: Statement = connection.createStatement()
        val selectSql = "SELECT * FROM [dbo].[v_mobileApp_products]"
        resultSet = statement.executeQuery(selectSql)
        DBTablePrinter.printResultSet(resultSet);
    } catch (e: SQLException) {
        e.printStackTrace()
    }

    //val jdbcUrl = "jdbc:sqlserver://$host:$port;DatabaseName=$database"
    //val connection = DriverManager.getConnection(jdbcUrl, username, password)
    //println(connection.isValid(0))
}