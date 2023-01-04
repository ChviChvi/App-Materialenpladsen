package com.example.materialepladsen.Database

import java.sql.Connection
import java.sql.DriverManager

fun getConnection(): Connection? {
    // Replace these values with your own server name, database name, and credentials
    val server = "152.115.71.190:48123"
    val database = "materialepladsen_core_DTUMP3"
    val username = "DTUMP3"
    val password = "MPor2hRrSE"
    val connectionUrl = "jdbc:sqlserver://$server;databaseName=$database;user=$username;password=$password"
    var connection: Connection? = null
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        connection = DriverManager.getConnection(connectionUrl)
        print("succession")
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return connection
}

fun connectiontryout(){
    val connection = getConnection()

    if (connection != null) {
        print("We have connection!")

        connection.close()
    }
}

fun main() {
    connectiontryout()
}

