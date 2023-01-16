package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GlemtAdgangskode(){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        val Newpassword = remember { mutableStateOf(TextFieldValue("")) }
        val RepeatNewpassword = remember { mutableStateOf(TextFieldValue("")) }


        Text(text = "Ændre Adgangkode",
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Udfyld felt for ny adgangkode")
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            label = { Text(text = "Ny Adgangskode") },
            value = Newpassword.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { Newpassword.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            label = { Text(text = " Gentag Ny Adgangskode") },
            value = RepeatNewpassword.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { RepeatNewpassword.value = it })
        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = { /*TODO*/},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray))
        {
            Text(text = "Gem Nye adgankskode",color = Color.White)
        }
        
    }

}
@Preview(showBackground = true)
@Composable
fun ComposablePreview1() {
    GlemtAdgangskode()
}