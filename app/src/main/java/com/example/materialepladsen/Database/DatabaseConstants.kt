package com.example.materialepladsen.Database

import java.sql.*

data class DatabaseConstants(
    val host: String = "152.115.71.190",
    val port: String = "48123",
    val database: String = "materialepladsen_core_DTUMP3",
    val username: String = "DTUMP3",
    val password: String = "MPor2hRrSE",
    val server: String = "sqlserver",
    val encrypt: String = "true",
    val trustServerCertificate: String = "true",
    val connectionUrl: String = "jdbc:$server://$host:$port;DatabaseName=$database;user=$username;password=$password;encrypt=$encrypt;trustServerCertificate=$trustServerCertificate;"
)

fun sqlQuery(query: String): ResultSet? {
    var resultSet: ResultSet? = null
    try {
        val connection = DriverManager.getConnection(DatabaseConstants().connectionUrl)
        if (connection.isValid(0)) {
            println("Connection established")
        }

        val statement: Statement = connection.createStatement()
        resultSet = statement.executeQuery(query)
    } catch (e: SQLException) {
        e.printStackTrace()
    }
    return resultSet
}


fun getSitesResultSet(): ResultSet {
    val selectSql = "SELECT * FROM [dbo].[v_mobileApp_sites]"
    return sqlQuery(selectSql)!!
}