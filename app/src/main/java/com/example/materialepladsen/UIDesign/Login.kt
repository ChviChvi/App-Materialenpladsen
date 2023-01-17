package com.example.materialepladsen.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R
import com.example.materialepladsen.UIDesign.OpretBruger

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Login (
    navigateToOpretBruger :() -> Unit = {}, navigatetoGlemt :() -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
        }

    ) {

        Divider(color = Color.Black, thickness = 1.dp)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(800.dp)

        ) {

            Spacer(modifier = Modifier.height(26.dp))

            Column(
                modifier = Modifier
                    .width(288.dp)
                    .height(691.dp)
                    .shadow(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally,


                ) {

                Spacer(modifier = Modifier.height(50.dp))

                Text(text = stringResource(id = R.string.LoginEllerRegistrer),
                    style = MaterialTheme.typography.h2)

                Spacer(modifier = Modifier.height(50.dp))

                // Bruger og adganskode textfields
                //Grøn Login knap
                BrugerAdgang()

                Spacer(modifier = Modifier.height(32.dp))

                TextButton(
                    onClick = { navigateToOpretBruger() },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        backgroundColor = Color.Transparent,

                        )
                ) {
                    Text(
                        text = "Opret bruger",
                        style = MaterialTheme.typography.h2,
                        textDecoration=TextDecoration.Underline

                    )
                }
                TextButton(onClick = { navigatetoGlemt() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.Black) ) {
                    Text(
                        text = "Glemt Adgangskode",
                        style = MaterialTheme.typography.h2,
                        textDecoration=TextDecoration.Underline
                    )

                }

                Spacer(modifier = Modifier.height(300.dp))

                //Glemt adgangskode eller brugernavn knap
                TextButton(
                    modifier = Modifier.padding(bottom=31.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Gray,
                        backgroundColor = Color.Transparent,

                        )
                ) {
                    Text(text = stringResource(id = R.string.Glemt),
                        style=MaterialTheme.typography.h4)
                }
            }
        }
    }
}

@Composable
fun Logo(){
    Row(modifier= Modifier
        .fillMaxWidth()
        .height(41.dp)
        .width(360.dp)

    ){
        Image(
            painter = painterResource(id = R.drawable.unknown_1),
            contentDescription =null,
            modifier= Modifier
                .width(118.dp)
                .height(35.dp)
                .padding(start = 18.dp, top = 5.dp)
        )

    }
}


// bruger og adgangskode texfields
//Grøn Login knap
@Composable
fun BrugerAdgang (

) {
    val brugernavn = remember { mutableStateOf(TextFieldValue()) }
    val adgangskode = remember { mutableStateOf(TextFieldValue()) }

    OutlinedTextField(
        modifier = Modifier
            .width(180.dp)
            .height(60.dp),
        value =brugernavn.value ,
        onValueChange ={ brugernavn.value = it },
        label = { Text(stringResource(id = R.string.Brugernavn))},
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription =null ) },
        textStyle = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(26.dp))
    OutlinedTextField(
        modifier = Modifier
            .width(180.dp)
            .height(60.dp),
        value = adgangskode.value,
        onValueChange = {adgangskode.value=it},
        label = { Text(stringResource(id = R.string.Adgangskode))},
        leadingIcon= {
            Icon(imageVector = Icons.Default.Lock, contentDescription =null ) },
        textStyle = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(32.dp))
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = colorResource(id = R.color.DarkRed)
        )
    ) {
        Text(text = stringResource(id =R.string.Login),
            style = MaterialTheme.typography.h2)
    }

}


@Preview (showBackground = true)
@Composable
fun ComposablePreview2() {
    Login()
}