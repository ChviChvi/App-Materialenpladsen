package com.example.materialepladsen.Database

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order


class CustomersTest {
    companion object {
        private val customerFirstName = "This is a"
        private var customerNumber = 0
    }

    @Test
    @Order(1)
    fun customerCanBeAdded() {
        val result = addCustomer(AddCustomerInfo(customerFirstName, "Test", "Testing street 5", "0000", "TestCty", "01234567", "12345678", "test@testing.test", "1234", "Test", "123456789"))
        val customer = getCustomers().find { it.firstName == customerFirstName && it.archived == null }
        assertNotNull(customer)
        assertEquals(customerFirstName, customer?.firstName)
        assertEquals("Test", customer?.lastName)
        assertEquals("Testing street 5", customer?.address)
        assertEquals("0000", customer?.postalCode)
        assertEquals("TestCty", customer?.city)
        assertEquals("01234567", customer?.phone)
        assertEquals("12345678", customer?.mobile)
        customerNumber = customer?.number ?: 0
    }

    // Will remove test customer after test above
    @Test
    @Order(2)
    fun customerCanBeArchivedFromDatabase() {
        Thread.sleep(5000) // wait 5 seconds for customer to be added
        val customer = getCustomers().find { it.number == customerNumber }
        assertNotNull(customer)
        if (customer != null) {
            assert(customer.archived == null)
            val result = removeCustomer(customer.number)
            val archivedCustomer = getCustomers().find { it.number == customerNumber }
            assertNotNull(archivedCustomer)
            if (archivedCustomer != null) {
                assert(archivedCustomer.archived != null)
            }
        }
    }
}