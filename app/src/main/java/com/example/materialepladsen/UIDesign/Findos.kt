package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Findos(navController: NavController) {
    Column() {
        Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = Color.Black)

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = stringResource(id = R.string.Find_Nærmeste),
            modifier = Modifier.padding(start=15.dp),
            style=MaterialTheme.typography.h6,
        )
        Text(text = stringResource(id = R.string.Find_Åbent),
            modifier = Modifier.padding(start=15.dp),
            style=MaterialTheme.typography.overline,
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier=Modifier.padding(start=0.dp)) {
            Spacer(modifier = Modifier.width(1.dp))
            Initialize_Map(
                billede = R.drawable.pam,
            )
            Spacer(modifier = Modifier.width(1.dp))
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier=Modifier.padding(start=0.dp)) {
            Spacer(modifier = Modifier.width(1.dp))
            Rectanglefindos(
                billede = R.drawable.naestved,

                url = "https://www.google.com/maps/place/Materialepladsen+A%2FS/@55.2053096,11.7376498,15z/data=!4m2!3m1!1s0x0:0x9020861f2ac5f878?sa=X&ved=2ahUKEwiaj9KLj9D8AhUu9bsIHa5-C0MQ_BJ6BAh4EAg",

            )
            Spacer(modifier = Modifier.width(1.dp))
        }

        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier=Modifier.padding(start=0.dp)) {
            Spacer(modifier = Modifier.width(1.dp))
            Rectanglefindos(
                billede = R.drawable.ringsted,
                url = "https://www.google.com/maps/place/Materialepladsen+Ringsted/@55.4216158,11.7906934,17z/data=!3m1!4b1!4m5!3m4!1s0x465291a35a6d0cef:0x3a858386c3f59ed6!8m2!3d55.4216128!4d11.7928821",
            )
            Spacer(modifier = Modifier.width(1.dp))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier=Modifier.padding(start=0.dp)) {
            Spacer(modifier = Modifier.width(1.dp))
            Rectanglefindos(
                billede = R.drawable.roskilde,

                url = "https://www.google.com/maps/place/Materialepladsen+Roskilde/@55.6428436,12.1347057,15z/data=!4m2!3m1!1s0x0:0xda31f77a784ddc82?sa=X&ved=2ahUKEwjwrNSGj9D8AhVw_rsIHXCvCiwQ_BJ6BAh-EAg",

            )
            Spacer(modifier = Modifier.width(1.dp))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier=Modifier.padding(start=0.dp)) {
            Spacer(modifier = Modifier.width(1.dp))
            Rectanglefindos(
                billede = R.drawable.vordingsborg,
                url = "https://www.google.com/maps/place/Materialepladsen+Vordingborg/@55.0438946,11.956988,15z/data=!4m2!3m1!1s0x0:0xe03711cd507525f?sa=X&ved=2ahUKEwjgx6SQj9D8AhUfh_0HHRG6AtAQ_BJ6BAhZEAg",

            )
            Spacer(modifier = Modifier.width(1.dp))
        }
    }
}


@Composable
fun Initialize_Map(
    @DrawableRes billede: Int,
) {
    Column(modifier = Modifier.width(500.dp)) {
        Image(
            modifier = Modifier
                .height(260.dp)
                .width(420.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = billede),
            contentDescription = null
        )
    }
}


@Composable
fun Rectanglefindos(
    @DrawableRes billede: Int,
    url: String,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(url)) }

//    Button(onClick = { context.startActivity(intent) },
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
//    ){
    Column(modifier = Modifier.width(screenWidth)
    ) {
        Image(
            modifier = Modifier
                .height(60.dp)
                .width(screenWidth)
                .align(Alignment.CenterHorizontally)
                .clickable( enabled = true,
                            onClick = { context.startActivity(intent) }),
            painter = painterResource(id = billede),
            contentDescription = null,
        )



        }
//}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview14() {
    MaterialepladsenTheme {
        val navController = rememberNavController()
        Findos(navController = navController)
    }}