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
            
            KøbItem(materiale = R.string.Vare1,
                vægt = R.string.Vægt1,
                dato = R.string.Dato1,
                pris =R.string.Pris1 ,
                ordrenr = R.string.Ordrenummer1)

            KøbItem(materiale = R.string.Vare2,
                vægt = R.string.Vægt2,
                dato = R.string.Dato2,
                pris =R.string.Pris2,
                ordrenr = R.string.Ordrenummer2)

            KøbItem(materiale = R.string.Vare3,
                vægt = R.string.Vægt3,
                dato = R.string.Dato3,
                pris =R.string.Pris3,
                ordrenr = R.string.Ordrenummer3)

            KøbItem(materiale = R.string.Vare4,
                vægt = R.string.Vægt4,
                dato = R.string.Dato4,
                pris =R.string.Pris4,
                ordrenr = R.string.Ordrenummer4)

            KøbItem(materiale = R.string.Vare5,
                vægt = R.string.Vægt5,
                dato = R.string.Dato5,
                pris =R.string.Pris5,
                ordrenr = R.string.Ordrenummer5)
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