package com.example.materialepladsen.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.materialepladsen.ui.theme.Login
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search

import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.R


@Composable
fun Forside () {

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
    topBar={
        Topbar()

    }
    ) {


        LazyColumn(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(800.dp)

        ){
            item {
                Logo()
            }
            item {
                Divider(color = Color.Black, thickness = 1.2.dp)
            }
            item {
                Text(
                    modifier = Modifier
                        .padding(start = 25.dp, top = 15.dp, end = 13.dp)
                        .width(323.dp),
                    text = stringResource(id = R.string.Velkommen),
                    style = MaterialTheme.typography.h6
                )
            }
            item {
                Text(
                    modifier = Modifier
                        .padding(start = 25.dp, top = 25.dp, end = 13.dp)
                        .width(323.dp),
                    text = stringResource(id = R.string.hent),
                    style = MaterialTheme.typography.h3
                )
            }
            item {
                Buttons()
            }
            item{
                Divider(
                    color = Color.Black,
                    thickness = 1.dp,
                    modifier = Modifier.width(360.dp)
                )}
            item{
            Image(
                    painterResource(id = R.drawable.unknown__3__1),
                    contentDescription = null,
                    modifier = Modifier
                        .height(78.dp)
                        .width(296.dp)
                )}
            item{
                Image(
                    painterResource(id = R.drawable.unknown__3__2),
                    contentDescription = null,
                    modifier = Modifier
                        .height(78.dp)
                        .width(296.dp)
                )}
            item{
                Divider(
                    modifier= Modifier
                        .padding(top = 16.dp)
                        .width(293.dp),
                    color = Color.Black,
                    thickness = 1.dp
                )}
            item{
                Spacer(modifier = Modifier.height(15.dp))
            }
            item{
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        backgroundColor = Color.Transparent,
                    )
                ) {
                    Text(text = stringResource(id = R.string.sevores),
                    style = MaterialTheme.typography.caption)
                }}
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                Divider(
                    modifier=Modifier.width(293.dp),
                    color = Color.Black,
                    thickness = 1.dp
                )}
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item{
                Text(text= stringResource(id = R.string.Bestil),
                    textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3,
                    lineHeight = 20.sp,
                    )}

            item{
                Spacer(modifier = Modifier.height(20.dp))
            }
            item{
                Text(text= stringResource(id = R.string.skal_du_bruge),
                textAlign = TextAlign.Center,
                style=MaterialTheme.typography.body1,
                lineHeight = 20.sp)
            }
            item{
                Buttons2()

            }
            item{
                Spacer(modifier = Modifier.height(20.dp))
            }
            }
        }
    }


@Composable
fun Topbar(){
    Row (modifier= Modifier
        .height(60.dp)
        .fillMaxWidth()
        .padding(start = 9.dp, end = 70.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = CenterVertically

    ){
        IconButton(
            onClick ={}

        ){
            Icon(modifier= Modifier
                .height(10.dp)
                .width(15.dp)
                .align(CenterVertically),
                imageVector = Icons.Default.Menu,
            contentDescription = null)}
        Spacer(modifier = Modifier.width(25.dp))
        Text(modifier= Modifier
            .width(194.dp)
            .align(CenterVertically),
            text = stringResource(id = R.string.forside),
        style = MaterialTheme.typography.h5
            )
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            onClick ={}

        ){
            Icon(modifier= Modifier
                .height(17.dp)
                .width(15.dp)
                .align(CenterVertically),
                imageVector = Icons.Default.Search,
                contentDescription = null)}


    }
}

@Composable
fun Buttons2(){
    Row (
        horizontalArrangement = Arrangement.Center
            ){
        TextButton(
            modifier = Modifier
                .width(123.dp)
                .height(40.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkGreen)
        )){
           Text(text= stringResource(id = R.string.førsteknap), fontSize = 10.sp)
            }
        Spacer(modifier = Modifier.width(20.dp))
        TextButton(
            modifier = Modifier
                .width(112.dp)
                .height(40.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkGreen)
            )){
            Text(text= stringResource(id = R.string.andenknap),fontSize = 10.sp)
        }

    }
}

@Composable
fun Buttons () {
    Row(modifier = Modifier
        .padding(start = 40.dp, top = 8.dp)
        .fillMaxWidth(),

    ) {

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkGreen)
            )) {
            Text(text = stringResource(id = R.string.se_produkter))

        }

        TextButton(
            modifier=Modifier.padding(start=11.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkGreen)
            )) {
            Text(text = stringResource(id = R.string.Bestil_levering))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MaterialepladsenTheme {
        Forside()
    }}
