package com.example.materialepladsen.Database

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
    val sql =
        "DECLARE @return_value int,\n" +
                "@output_customer_number int,\n" +
                "@output_customer_guid uniqueidentifier,\n" +
                "@output_customer_cardNumber int,\n" +
                "@output_resultMessage nvarchar(100),\n" +
                "@output_exceptionMessage nvarchar(1000)\n" +
                "\n" +
                "EXEC @return_value = [dbo].[usp_customer_add]\n" +
                "@input_customer_firstName = ?,\n" +
                "@input_customer_lastName = ?,\n" +
                "@input_customer_address = ?,\n" +
                "@input_customer_postalcode = ?,\n" +
                "@input_customer_city = ?,\n" +
                "@input_customer_phone = ?,\n" +
                "@input_customer_mobile = ?,\n" +
                "@input_customer_email = ?,\n" +
                "@input_customer_password = ?,\n" +
                "@input_customer_cardtag = ?,\n" +
                "@input_customer_licensplate = ?,\n" +
                "@output_customer_number = @output_customer_number OUTPUT,\n" +
                "@output_customer_guid = @output_customer_guid OUTPUT,\n" +
                "@output_customer_cardNumber = @output_customer_cardNumber OUTPUT,\n" +
                "@output_resultMessage = @output_resultMessage OUTPUT,\n" +
                "@output_exceptionMessage = @output_exceptionMessage OUTPUT\n" +
                "\n" +
                "SELECT @output_customer_number as N'@output_customer_number',\n" +
                "@output_customer_guid as N'@output_customer_guid',\n" +
                "@output_customer_cardNumber as N'@output_customer_cardNumber',\n" +
                "@output_resultMessage as N'@output_resultMessage',\n" +
                "@output_exceptionMessage as N'@output_exceptionMessage'\n" +
                "\n" +
                "SELECT 'Return Value' = @return_value"

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
    val sql = "DECLARE @return_value int,\n" +
            "@output_customer_number INT,\n" +
            "@output_customer_guid UNIQUEIDENTIFIER,\n" +
            "@output_resultMessage NVARCHAR(100),\n" +
            "@output_exceptionMessage NVARCHAR(1000)\n" +
            "\n" +
            "EXEC @return_value = [dbo].[usp_customer_delete]\n" +
            " @input_customer_number = ?,\n" +
            " @output_customer_number = @output_customer_number OUTPUT,\n" +
            " @output_customer_guid = @output_customer_guid OUTPUT,\n" +
            " @output_resultMessage = @output_resultMessage OUTPUT,\n" +
            " @output_exceptionMessage = @output_exceptionMessage OUTPUT\n" +
            "\n" +
            "SELECT @output_customer_number as N'@output_customer_number',\n" +
            "   @output_customer_guid as N'@output_customer_guid',\n" +
            "   @output_resultMessage as N'@output_resultMessage',\n" +
            "   @output_exceptionMessage as N'@output_exceptionMessage'\n" +
            "\n" +
            "SELECT 'Return Value' = @return_value"

    val connection = DriverManager.getConnection(DatabaseConstants().connectionUrl)
    if (connection.isValid(0)) {
        println("Connection established")
    }

    val preparedStatement = connection.prepareStatement(sql)
    preparedStatement.setInt(1, customerNumber)

    return preparedStatement.executeQuery()
}