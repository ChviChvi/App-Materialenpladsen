package com.example.materialepladsen.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.materialepladsen.ui.theme.Login
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.R


@Composable
fun Forside (){
    Column (modifier=Modifier.height(800.dp)){
        Topbar()
        Logo()
        Text(text = stringResource(id =R.string.Velkommen ),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = stringResource(id = R.string.hent) )
        Buttons()
        Divider(
            color = Color.Black,
            thickness = 1.dp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painterResource(id = R.drawable.unknown__3__1),
        contentDescription = null)
        Image(
            painterResource(id = R.drawable.unknown__3__2),
            contentDescription = null)
        Divider(
            color = Color.Black,
            thickness = 1.dp)
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Gray,
                backgroundColor = Color.Transparent
            )) {
           Text(text = stringResource(id = R.string.sevores))
        }

        Spacer(modifier = Modifier.height(50.dp))
        Divider(
                color = Color.Black,
            thickness = 1.dp)
        Text(text = stringResource(id = R.string.Bestil_idag___) )
    }
}


@Composable
fun Topbar(){
    Row {
        IconButton(
            onClick ={}

        ){
            Icon(imageVector = Icons.Default.Menu,
            contentDescription = null)}
        Spacer(modifier = Modifier.width(10.dp))
        /*Text(text = stringResource(id = R.string.forside),
        FontWeight(700),


            )*/
        Spacer(modifier = Modifier.width(100.dp))
        IconButton(
            onClick ={}

        ){
            Icon(imageVector = Icons.Default.Search,
                contentDescription = null)}


    }
}

@Composable
fun Buttons () {
    Row() {

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Green
            )) {
            Text(text = stringResource(id = R.string.se_produkter))

        }

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Green
            )) {
            Text(text = stringResource(id = R.string.Bestil_levering))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MaterialepladsenTheme {
        Login()
    }}
