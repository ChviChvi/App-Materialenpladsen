    package com.example.materialepladsen

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.materialepladsen.SERVER.Network.Network1.ApiService
import com.example.materialepladsen.ui.theme.*



    class MainActivity : ComponentActivity() {


        val apiService by lazy {
            ApiService.create()
        }


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialepladsenTheme {
                MaterialepladsenApp(apiService)

            }
        }

    }
}





