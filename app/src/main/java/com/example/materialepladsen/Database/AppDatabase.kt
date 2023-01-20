package com.example.materialepladsen.Database

//import android.content.Context
//import androidx.room.*
//
//@Database(entities = [Customer::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun customerDao(): CustomerDao
//
//
//
//    @Dao
//    interface CustomerDao {
//        @Query("SELECT * FROM v_mobileApp_customers")
//        fun getAllCustomers(): List<Customer>
//
//        @Insert
//        fun insertCustomer(customer: Customer)
//
//        @Update
//        fun updateCustomer(customer: Customer)
//
//        @Delete
//        fun deleteCustomer(customer: Customer)
//    }
//
//    @Entity(tableName = "v_mobileApp_customers")
//    data class Customer(
//        val customer_number: Int,
//        val customer_guid: String,
//        val customer_firstName: String,
//        val customer_lastName: String,
//        val customer_address: String,
//        val customer_postalcode: String,
//        val customer_city: String,
//        val customer_phone: String,
//        val customer_mobile: String,
//        val customer_email: String,
//        val customer_password: String,
//        val customer_cardtag: String,
//        val customer_licensplate: String
//    )
//
//    companion object {
//        private var instance: AppDatabase? = null
//        fun getInstance(context: Context): AppDatabase {
//            if (instance == null) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java, "materialepladsen_core_DTUMP3"
//                ).build()
//            }
//            return instance!!
//        }
//    }
//}