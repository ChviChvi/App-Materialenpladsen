package com.example.materialepladsen.UIDesign

import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.blue
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*

@Composable
fun Findos () {

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar={
            TopBar(R.string.Findos)
        }
    ) {

        Column() {
            Logo3()

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
/////////////////////////////////////////////////////////////////////

            Row(modifier=Modifier.padding(start=0.dp)) {
                Spacer(modifier = Modifier.width(1.dp))
                Initialize_Map(
                    billede = R.drawable.pam,
                )
                Spacer(modifier = Modifier.width(1.dp))
            }
/////////////////////////////////////////////////////////////////////
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier=Modifier.padding(start=0.dp)) {
                Spacer(modifier = Modifier.width(1.dp))
                Rectanglefindos(
                    billede = R.drawable.naestved,
                )
                Spacer(modifier = Modifier.width(1.dp))
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier=Modifier.padding(start=0.dp)) {
                Spacer(modifier = Modifier.width(1.dp))
                Rectanglefindos(
                    billede = R.drawable.ringsted,
                )
                Spacer(modifier = Modifier.width(1.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier=Modifier.padding(start=0.dp)) {
                Spacer(modifier = Modifier.width(1.dp))
                Rectanglefindos(
                    billede = R.drawable.roskilde,
                )
                Spacer(modifier = Modifier.width(1.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier=Modifier.padding(start=0.dp)) {
                Spacer(modifier = Modifier.width(1.dp))
                Rectanglefindos(
                    billede = R.drawable.vordingsborg,
                )
                Spacer(modifier = Modifier.width(1.dp))
            }




        }
    }
}

@Composable
fun Logo3(){
    Row(modifier= Modifier
        .height(41.dp)
        .width(360.dp),
        horizontalArrangement = Arrangement.Start)
    {
        Image(
            painter = painterResource(id = R.drawable.unknown_1),
            contentDescription =null,
            modifier= Modifier
                .width(118.dp)
                .height(35.dp)
                .padding(start = 18.dp, top = 5.dp)
        )
        Spacer(modifier = Modifier.width(200.dp))

        Icon(modifier= Modifier
            .height(25.dp)
            .width(25.dp)
            .align(Alignment.CenterVertically),
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null)
    }
}

@Composable
fun Initialize_Map(
    @DrawableRes billede: Int,
) {
    Column(modifier = Modifier.width(500.dp)) {
        Image(
            modifier = Modifier
                .height(280.dp)
                .width(460.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = billede),
            contentDescription = null
        )
    }
}


@Composable
fun Rectanglefindos(
    @DrawableRes billede: Int,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Column(modifier = Modifier.width(screenWidth)) {
        Image(
            modifier = Modifier
                .height(70.dp)
                .width(screenWidth)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = billede),
            contentDescription = null
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    MaterialepladsenTheme {
        Findos()
    }}