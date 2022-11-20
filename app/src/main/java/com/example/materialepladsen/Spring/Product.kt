package com.example.materialepladsen.Spring

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

// "jdbc:sqlserver://mssql.db.server\\mssql_instance;databaseName=my_database";
// jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]

fun main() {
    val host = "152.115.71.190"
    val port = "48123"
    val database = "materialepladsen_core_DTUMP3"
    val cp = "utf8"

    val username = "DTUMP3"
    val password = "MPor2hRrSE"

    /*
    val connectionUrl = ("jdbc:sqlserver://$host:$port;"
            + "database=$database;"
            + "user=$username;"
            + "password=$password;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "loginTimeout=30;")
            */

    val connectionUrl = "jdbc:sqlserver://$host:$port;DatabaseName=$database;" + "user=$username; password=$password;" +";encrypt=true;trustServerCertificate=true;"

    var resultSet: ResultSet? = null
    try {
        val connection = DriverManager.getConnection(connectionUrl)
        if (connection.isValid(0)) {
            println("Connection established")
        }

        val statement: Statement = connection.createStatement()
        val selectSql = "SELECT * FROM [dbo].[v_mobileApp_products]"
        resultSet = statement.executeQuery(selectSql)
        while (resultSet.next()) {
            println(resultSet.getString(2) + " " + resultSet.getString(3));
        }
    } catch (e: SQLException) {
        e.printStackTrace()
    }

    //val jdbcUrl = "jdbc:sqlserver://$host:$port;DatabaseName=$database"
    //val connection = DriverManager.getConnection(jdbcUrl, username, password)
    //println(connection.isValid(0))
}