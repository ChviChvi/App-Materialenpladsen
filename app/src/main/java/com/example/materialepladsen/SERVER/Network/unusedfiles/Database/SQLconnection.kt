package com.example.materialepladsen.SERVER.Network.unusedfiles.Database

import java.sql.*

fun getConnection(query: String): ResultSet? {

        var resultSet: ResultSet? = null

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
            resultSet = statement.executeQuery(query)
        }
        return resultSet
    }

//fun connectiontryout(){
//    val connection = getConnection()
//
//    if (connection != null) {
//        print("We have connection!")
//        println(connection)
//        connection.close()
//    }
//}


//fun loadData(query: String): ResultSet? {
//
//    var resultSet: ResultSet? = null
//    val connection = getConnection()
//    println("connection status: "+connection)
//    val list = mutableListOf<String>()
//
//    if (connection != null) {
//        try {
//            val statement: Statement = connection.createStatement()
//            resultSet = statement.executeQuery(query)
//        } catch (e: SQLException) {
//            e.printStackTrace()
//        }
//    } else {
//        println("there was no connection!!!!!!!")
//    }
//        return resultSet
//
//}


//    if (connection != null) {
//        val statement = connection.createStatement()
//        val Table_info = statement.executeQuery("SELECT * FROM materialepladsen_core_DTUMP3")
//
//        while (Table_info.next()) {
//            val column1 = Table_info.getString("customer_lastName")
//            val column2 = Table_info.getString("licensplates")
//            list.add("$column1 - $column2")
//        }
//
//        Table_info.close()
//        statement.close()
//        connection.close()
//
//        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, list)
//        //listView.adapter = adapter
//    }
//}

    fun startSQLconnection() {
        //val results = getConnection("SELECT * FROM [dbo].[v_mobileApp_products]")
        val results = getProducts2()
        println(results)
        //val list: MutableList<Int> = mutableListOf()
        // loadData(list,this)


    }

    fun main111() {
        //val results = getConnection("SELECT * FROM [dbo].[v_mobileApp_products]")
        val results = getProducts2()
        println(results)
        //val list: MutableList<Int> = mutableListOf()
        // loadData(list,this)


    }


