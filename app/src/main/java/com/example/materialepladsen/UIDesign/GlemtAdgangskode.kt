package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.ui.theme.Green
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import com.example.materialepladsen.R


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

        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray) ) {
                Image(
                    painterResource(id = R.drawable.b_arrow),
                    contentDescription ="Go back",
                    modifier = Modifier.size(20.dp))

                Text(text = "Tilbage",Modifier.padding(start = 10.dp))
            }
        }


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

        val Context = LocalContext.current
        //Chekker om de to koder mathcer hinanden og displayer en message for "godkent" og "ikke godkendt"
        Button(onClick = {
            if (Newpassword.value.equals(RepeatNewpassword.value) && (Newpassword.value.text.isNotEmpty()))
            { Toast.makeText(Context, "Kode er Godkendt", Toast.LENGTH_SHORT).show()}
            if (Newpassword.value.text.isEmpty())
            { Toast.makeText(Context, "Felter er tomme, skriv kode", Toast.LENGTH_SHORT).show()}
                else {Toast.makeText(Context, "koder matcher ikke", Toast.LENGTH_SHORT).show()}
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Green))
        {
            Text(text = "Gem Ny adgankskode",color = Color.White)
        }
        
    }

}
@Preview(showBackground = true)
@Composable
fun ComposablePreview1() {
    GlemtAdgangskode()
}