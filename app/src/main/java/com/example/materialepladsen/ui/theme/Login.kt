package com.example.materialepladsen.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R

@Composable
fun Login () {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            Logo()

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
                LoginReg()
                Spacer(modifier = Modifier.height(27.dp))

                BrugerAdgang()
                Spacer(modifier = Modifier.height(300.dp))

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

@Composable
fun LoginReg (){
    Row(
        modifier=Modifier.padding(start=20.dp,top=43.dp,end=30.dp)
    ) {
        Logreg(id = R.string.Login)
        Spacer(modifier = Modifier.width(35.dp))
        Logreg(id = R.string.Registrer)
    }
}

@Composable
fun Logreg (@StringRes id:Int){

    Column (){
        TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.Transparent,

        )
    ) {
        Text(
            stringResource(id = id),
            style = MaterialTheme.typography.h2,
            textDecoration=TextDecoration.Underline

        )
    }

    }
}

@Composable
fun BrugerAdgang (
) {
    
    OutlinedTextField(
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        value ="" ,
        onValueChange ={},
        label = { Text(stringResource(id = R.string.Brugernavn))},
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription =null ) },
        textStyle = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(26.dp))
    OutlinedTextField(
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        value = "",
        onValueChange = {},
        label = { Text(stringResource(id = R.string.Adgangskode))},
        leadingIcon= {
            Icon(imageVector = Icons.Default.Lock, contentDescription =null ) },
        textStyle = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(32.dp))
    Button(onClick = { /*TODO*/ },
        modifier=Modifier.padding(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor =MaterialTheme.colors.secondary
        )
    ) {
        Text(text = stringResource(id =R.string.Login ),
            style = MaterialTheme.typography.h2)
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MaterialepladsenTheme {
        Login()
    }}