package com.example.materialepladsen.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R

@Composable
fun Login (){



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier= Modifier
            .width(360.dp)
            .height(800.dp)
            .fillMaxWidth()
    ){
        logo()
        Divider(color = Color.Black, thickness = 1.dp)
        Spacer(modifier = Modifier.height(30.dp))



        Column(
            modifier= Modifier
                .width(288.dp)
                .height(691.dp)
                .border(1.dp, Color.LightGray, RectangleShape),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,


            ) {
            LoginReg()

            brugerAdgang()
            Spacer(modifier = Modifier.height(350.dp))

            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Gray,
                    backgroundColor = Color.Transparent
                )) {
                Text(text = stringResource(id = R.string.Glemt))

            }


        }
    }}

@Composable
fun logo(){
    Row(modifier= Modifier
        .fillMaxWidth()
        .height(40.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.unknown_1),
            contentDescription =null,
            modifier= Modifier
                .width(150.dp)
                .height(132.dp)
                .padding(start = 18.dp, top = 3.dp)
        )

    }
}

@Composable
fun LoginReg (){
    Row() {
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.Transparent
            )
        ){
            Text(stringResource(id = R.string.Login), style = TextStyle(textDecoration = TextDecoration.Underline))
        }
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.Transparent
            )
        ) {
            Text(stringResource(id = R.string.Registrer),style = TextStyle(textDecoration = TextDecoration.Underline))
        }
    }
}

@Composable
fun brugerAdgang (
) {
    OutlinedTextField(
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        value ="" ,
        onValueChange ={},
        label = { Text(stringResource(id = R.string.Brugernavn))},
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription =null ) }
    )
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedTextField(
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        value = "",
        onValueChange = {},
        label = { Text(stringResource(id = R.string.Adgangskode))},
        leadingIcon= {
            Icon(imageVector = Icons.Default.Lock, contentDescription =null )
        }
    )
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = { /*TODO*/ },
        modifier=Modifier.padding(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.Cyan
        )
    ) {
        Text(text = stringResource(id =R.string.Login ))
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MaterialepladsenTheme {
        Login()
    }}