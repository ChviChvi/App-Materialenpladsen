package com.example.materialepladsen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.UIDesign.Betaling
import com.example.materialepladsen.UIDesign.PriceCalculatorScreen
import com.example.materialepladsen.ui.theme.Login

import com.example.materialepladsen.ui.theme.MaterialepladsenTheme
import com.example.materialepladsen.ui.theme.TopBar

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            /*
            composable(
                route = "second/{content}",
                arguments = listOf(
                    navArgument("content") {
                        /* configuring arguments for navigation */
                        type = NavType.StringType
                    }
                )
            ) {
                SecondScreen(
                    navController,
                    it.arguments?.getString("content")
                )
            }
            */

        setContent {
            MaterialepladsenTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxWidth(),
                    topBar = {
                        TopBar(id = R.string.Materialer)
                    }
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "weightCalculator"
                    ) {
                        composable(route = "weightCalculator") {
                            PriceCalculatorScreen(navController = navController)
                        }
                        composable(route = "payment") {
                            Betaling(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialepladsenTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                TopBar(id = R.string.Materialer)
            }
        ) {
            //PriceCalculatorScreen()
        }
    }
}