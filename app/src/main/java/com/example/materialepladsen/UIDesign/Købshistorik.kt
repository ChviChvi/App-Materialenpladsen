package com.example.materialepladsen.UIDesign

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*

@Composable
fun Købshistorik (){

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopBar(id = R.string.Købshistorik)
        }

    ){
        //Lazycolum?
        Column(
            modifier = Modifier.fillMaxWidth()

        ){

            Logo2()

            Divider(modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Black)
            
            KøbItem(materiale = R.string.første,
                vægt = R.string.førstevægt,
                dato = R.string.førstedato,
                pris =R.string.førstepris ,
                ordrenr = R.string.førsteordrenummer)

            KøbItem(materiale = R.string.anden,
                vægt = R.string.andenvægt,
                dato = R.string.andendato,
                pris =R.string.andenpris ,
                ordrenr = R.string.andenordrenr)

            KøbItem(materiale = R.string.tredje,
                vægt = R.string.tredjevægt,
                dato = R.string.tredjedato,
                pris =R.string.tredjepris ,
                ordrenr = R.string.tredjeordrenr)

            KøbItem(materiale = R.string.fjerde,
                vægt = R.string.fjerdevægt,
                dato = R.string.fjerdedato,
                pris =R.string.fjerdepris ,
                ordrenr = R.string.fjerdeordrenr)

            KøbItem(materiale = R.string.femte,
                vægt = R.string.femtevægt,
                dato = R.string.femtedato,
                pris =R.string.femtepris ,
                ordrenr = R.string.femteordrenr)

        }

    }
}

@Composable
fun KøbItem (@StringRes materiale: Int,
             @StringRes vægt: Int,
             @StringRes dato: Int,
             @StringRes pris: Int,
             @StringRes ordrenr: Int
    ){

    Column(

        modifier=Modifier
            .fillMaxWidth()
    ) {
        // Materiale, Vægt og dato
        Row(
            modifier=Modifier.padding(start=20.dp,top=20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter)){
                        append(stringResource(id = materiale)) }
                    append(" ")
                    withStyle(SpanStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = Inter)){
                        append(stringResource(id = vægt)) } },
                modifier=Modifier.width(200.dp))
            
            Spacer(modifier = Modifier.width(80.dp))

            Text(text = stringResource(id = dato),
                lineHeight = 12.sp,
            style=MaterialTheme.typography.subtitle2)
        }

        //Pris
        Text(
            buildAnnotatedString {
                withStyle(style= SpanStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Inter)){
                    append("Pris - ")
                }
                withStyle(style= SpanStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter)){
                    append(stringResource(id = pris))
                }
                append("\n")
            },
            modifier=Modifier.padding(start=20.dp),
        textAlign = TextAlign.Start,
            lineHeight = 12.sp,)

        //Ordrenummer
        Text(
            buildAnnotatedString {
                withStyle(style= SpanStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Inter)){
                    append("Ordrenummer - ")
                }
                withStyle(style= SpanStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter)){
                    append(stringResource(id = ordrenr))
                }
            },
            modifier=Modifier.padding(start=20.dp),
            textAlign = TextAlign.Start,
            lineHeight = 12.sp )
        
        Spacer(modifier = Modifier.height(10.dp))

        Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black)


    }


}






@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    MaterialepladsenTheme {
        Købshistorik()
    }
}