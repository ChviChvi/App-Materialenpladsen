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
import com.example.materialepladsen.UIDesign.Købshistorik
import com.example.materialepladsen.UIDesign.PriceCalculatorScreen
import com.example.materialepladsen.ui.theme.Login

import com.example.materialepladsen.ui.theme.MaterialepladsenTheme
import com.example.materialepladsen.ui.theme.TopBar

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialepladsenTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxWidth(),
                    topBar = {
                        TopBar(id = R.string.Materialer)
                    }
                ) {
                    PriceCalculatorScreen()
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
            PriceCalculatorScreen()
            Købshistorik()
        }
    }
}