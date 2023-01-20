package com.example.materialepladsen.SERVER.Network.unusedfiles.Database

import java.sql.Date
import java.sql.DriverManager
import java.sql.ResultSet

data class Customer(
    val number: Int,
    val id: String, // unique identifier??
    val firstName: String?,
    val lastName: String?,
    val address: String?,
    val postalCode: String?,
    val city: String?,
    val phone: String?,
    val mobile: String?,
    val email: String?,
    val password: String?,
    val cardNumber: String?,
    val licensPlates: String?,
    val created: Date?,
    val createdBy: String?,
    val modified: Date?,
    val modifiedBy: String?,
    val archived: Date?,
    val archivedBy: String?,
)

fun getCustomersResultSet(): ResultSet {
    val selectSql = "SELECT * FROM [dbo].[v_mobileApp_customers]"
    return sqlQuery(selectSql)!!
}

fun getCustomers(): List<Customer> {
    val customers = mutableListOf<Customer>()
    val resultSet = getCustomersResultSet()
    while (resultSet.next()) {
        val customer = Customer(
            resultSet.getInt("customer_number"),
            resultSet.getString("customer_guid"),
            resultSet.getString("customer_firstName"),
            resultSet.getString("customer_lastName"),
            resultSet.getString("customer_address"),
            resultSet.getString("customer_postalcode"),
            resultSet.getString("customer_city"),
            resultSet.getString("customer_phone"),
            resultSet.getString("customer_mobile"),
            resultSet.getString("customer_email"),
            resultSet.getString("customer_password"),
            resultSet.getString("card_number"),
            resultSet.getString("licensplates"),
            resultSet.getDate("created"),
            resultSet.getString("createdby"),
            resultSet.getDate("modified"),
            resultSet.getString("modifiedby"),
            resultSet.getDate("archived"),
            resultSet.getString("archivedby"),
        )
        customers.add(customer)
    }
    return customers
}

data class AddCustomerInfo(
    val firstName: String,
    val lastName: String,
    val address: String,
    val postalCode: String,
    val city: String,
    val phone: String,
    val mobile: String,
    val email: String,
    val password: String,
    val cardTag: String,
    val licensPlates: String,
)

fun addCustomer(customerInfo: AddCustomerInfo): ResultSet? {
    val sql = ""
    val connection = DriverManager.getConnection(DatabaseConstants().connectionUrl)
    if (connection.isValid(0)) {
        println("Connection established")
    }

    val preparedStatement = connection.prepareStatement(sql)
    preparedStatement.setString(1, customerInfo.firstName)
    preparedStatement.setString(2, customerInfo.lastName)
    preparedStatement.setString(3, customerInfo.address)
    preparedStatement.setString(4, customerInfo.postalCode)
    preparedStatement.setString(5, customerInfo.city)
    preparedStatement.setString(6, customerInfo.phone)
    preparedStatement.setString(7, customerInfo.mobile)
    preparedStatement.setString(8, customerInfo.email)
    preparedStatement.setString(9, customerInfo.password)
    preparedStatement.setString(10, customerInfo.cardTag)
    preparedStatement.setString(11, customerInfo.licensPlates)

    val resultSet = preparedStatement.executeQuery()
    return resultSet
}

fun removeCustomer(customerNumber: Int): ResultSet? {
    val sql = ""

    val connection = DriverManager.getConnection(DatabaseConstants().connectionUrl)
    if (connection.isValid(0)) {
        println("Connection established")
    }

    val preparedStatement = connection.prepareStatement(sql)
    preparedStatement.setInt(1, customerNumber)

    return preparedStatement.executeQuery()
}