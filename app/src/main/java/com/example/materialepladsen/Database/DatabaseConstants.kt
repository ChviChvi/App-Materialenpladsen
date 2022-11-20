package com.example.materialepladsen.Database

import java.sql.ResultSet
import java.sql.ResultSetMetaData

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

fun printTable(resultSet: ResultSet) {
    val metaData: ResultSetMetaData = resultSet.metaData
    val columnsNumber: Int = metaData.columnCount

    while (resultSet.next()) {
        for (i in 1..columnsNumber) {
            if (i > 1) print(",  ")
            val columnValue: String = resultSet.getString(i)
            print(columnValue + " " + metaData.getColumnName(i))
        }
        println("")
    }
}