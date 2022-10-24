package com.example.materialepladsen.UIDesign

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn


import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.example.materialepladsen.ui.theme.*

@Composable
fun Omos () {

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar={
            TopBar(R.string.Omos)
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
                Logo2()
            }
            item {
                Divider(color = Color.Black, thickness = 1.2.dp)
            }
            //Velkomsttekst
            item {
                Text(
                    modifier = Modifier
                        .padding(start = 25.dp, top = 15.dp, end = 13.dp)
                        .width(323.dp),
                    text = stringResource(id = R.string.Velkommen),
                    style = MaterialTheme.typography.h6
                )
            }
            //Velkomsttekst 2.
            // Velkomst test 1 og 2 samles til en tekst.
            item {
                Text(
                    modifier = Modifier
                        .padding(start = 25.dp, top = 25.dp, end = 13.dp)
                        .width(323.dp),
                    text = stringResource(id = R.string.hent),
                    style = MaterialTheme.typography.h3
                )
            }
            //Se produkter og Bestil Levering knapper
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
            //Se Anmeldelser knap
            item{
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        backgroundColor = Color.Transparent,
                    )
                ) {
                    Text(text = stringResource(id = R.string.sevores),
                        style = MaterialTheme.typography.caption,
                    )
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
            // Bestil i dag of få leveret tekst 1
            item{
                Text(text= stringResource(id = R.string.Bestil),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h3,
                    lineHeight = 20.sp,
                )}

            item{
                Spacer(modifier = Modifier.height(20.dp))
            }
            //Bestil i dag og få leveret tekst 2
            // 1 og 2 samles
            item{
                Text(text= stringResource(id = R.string.skal_du_bruge),
                    textAlign = TextAlign.Center,
                    style=MaterialTheme.typography.body1,
                    lineHeight = 20.sp)
            }
            // Hent selv knap og beregn pris knap
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
fun TopBar(@StringRes id: Int){

    Row (modifier= Modifier
        .height(60.dp)
        .fillMaxWidth()
        .padding(start = 9.dp, end = 70.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = CenterVertically

    ){
        //Dropdown menu icon
        IconButton(
            onClick ={/*TODO*/}

        ){
            Icon(modifier= Modifier
                .height(20.dp)
                .width(18.dp)
                .align(CenterVertically),
                imageVector = Icons.Default.Menu,
                contentDescription = null)}
        Spacer(modifier = Modifier.width(15.dp))
        Text(modifier= Modifier
            .width(194.dp)
            .align(CenterVertically),
            text = stringResource(id),
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.width(10.dp))

        //Magnifying glass icon
        IconButton(
            onClick ={/*TODO*/}

        ){
            Icon(modifier= Modifier
                .height(20.dp)
                .width(18.dp)
                .align(CenterVertically),
                imageVector = Icons.Default.Search,
                contentDescription = null)}
    }
}


