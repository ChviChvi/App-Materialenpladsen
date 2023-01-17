    package com.example.materialepladsen

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.materialepladsen.ui.theme.*



    class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialepladsenTheme {
                MaterialepladsenApp()

            }
        }
    }
}





