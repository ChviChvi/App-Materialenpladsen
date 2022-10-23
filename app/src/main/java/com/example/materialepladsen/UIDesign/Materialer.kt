package com.example.materialepladsen.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.R


@Composable
fun Material () {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopBar(id = R.string.Materialer)
        }
    ) {

        Column() {

            Logo2()

            Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black)

            Spacer(modifier = Modifier.height(18.dp))

            Text(text = stringResource(id = R.string.Træsorter),
            modifier = Modifier.padding(start=15.dp),
            style=MaterialTheme.typography.overline,
            )

            Spacer(modifier = Modifier.height(21.dp))

            //Første række
            //Måske laves til LazyRow?
            Row(modifier=Modifier.padding(start=28.dp)) {
                Materialeitem(
                    id_et = R.string.askvægt,
                    id_to = R.string.askalder,
                    id_tre = R.string.askpris,
                    billede = R.drawable.woodpile_6364896_960_720_2,
                )

                Spacer(modifier = Modifier.width(50.dp))

                Materialeitem(
                    id_et = R.string.bøgvægt,
                    id_to = R.string.bøgalder,
                    id_tre = R.string.bøgpris,
                    billede = R.drawable.woodpile_6364896_960_720_3,
                )
                
                Spacer(modifier = Modifier.width(35.dp))

                Icon(imageVector=Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier= Modifier
                        .height(45.dp)
                        .width(26.dp)
                        .align(CenterVertically)
                )

            }
            Spacer(modifier = Modifier.height(20.dp))
            Divider(modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Black)

            Spacer(modifier = Modifier.height(18.dp))

            Text(text = stringResource(id = R.string.Metaller),
                modifier = Modifier.padding(start=15.dp),
                style=MaterialTheme.typography.overline,
            )

            Spacer(modifier = Modifier.height(21.dp))

            //Måske laves til LazyRow?
            Row(modifier=Modifier.padding(start=28.dp)) {
                Materialeitem(
                    id_et = R.string.Sølvpladetykkelse,
                    id_to = R.string.sølvpladeinfo,
                    id_tre = R.string.Sølvpladepris,
                    billede = R.drawable.s_lvplade
                )

                Spacer(modifier = Modifier.width(50.dp))

                Materialeitem(
                    id_et = R.string.ASølvplade,
                    id_to = R.string.AInfo,
                    id_tre = R.string.Apris,
                    billede = R.drawable.as_lvplade,
                )

                Spacer(modifier = Modifier.width(35.dp))

                Icon(imageVector=Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier= Modifier
                        .height(45.dp)
                        .width(26.dp)
                        .align(CenterVertically)
                )

            }
            
            Spacer(modifier = Modifier.height(20.dp))
            Divider(modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Black)

            Spacer(modifier = Modifier.height(18.dp))

            Text(text = stringResource(id = R.string.Sten),
                modifier = Modifier.padding(start=15.dp),
                style=MaterialTheme.typography.overline,
            )

            Spacer(modifier = Modifier.height(21.dp))

            //Måske laves til LazyRow?
            Row(modifier=Modifier.padding(start=28.dp)) {
                Materialeitem(
                    id_et = R.string.Hvide,
                    id_to = R.string.Hvideinfo,
                    id_tre = R.string.HvidePris,
                    billede = R.drawable.hvide,
                )

                Spacer(modifier = Modifier.width(50.dp))

                Materialeitem(
                    id_et = R.string.Røde,
                    id_to = R.string.RødeInfo,
                    id_tre = R.string.RødePris,
                    billede = R.drawable.r_de,
                )

                Spacer(modifier = Modifier.width(35.dp))

                Icon(imageVector=Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier= Modifier
                        .height(45.dp)
                        .width(26.dp)
                        .align(CenterVertically)
                )

            }


        }

    }
}

@Composable
fun Logo2(){
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
            .height(30.dp)
            .width(30.dp)
            .align(CenterVertically),
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null)
    }
}


//tekst
//kald en liste med billeder
// icon button
@Composable
fun Materialeitem(
    @StringRes id_et: Int,
    @StringRes id_to: Int,
    @StringRes id_tre: Int,
    @DrawableRes billede: Int,
) {


    Column(modifier = Modifier.width(140.dp)) {


        Image(
            modifier = Modifier
                .height(81.dp)
                .width(98.dp)
                .align(CenterHorizontally),
            painter = painterResource(id = billede),
            contentDescription = null
        )
        Text(text = stringResource(id = id_et),
        style=MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            lineHeight = 14.sp
        )

        Text(text = stringResource(id = id_to),
        style=MaterialTheme.typography.subtitle2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 14.sp
        )

        Text(text ="DKK "+ stringResource(id = id_tre),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        lineHeight = 14.sp,
            color = MaterialTheme.colors.secondaryVariant,
            style=MaterialTheme.typography.h3

        )


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    MaterialepladsenTheme {
        Material()
    }}