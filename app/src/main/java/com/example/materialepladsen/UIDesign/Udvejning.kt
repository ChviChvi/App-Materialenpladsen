package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.example.materialepladsen.ui.theme.Inter
import com.example.materialepladsen.ui.theme.Logo2
import com.example.materialepladsen.ui.theme.MaterialepladsenTheme
import com.example.materialepladsen.ui.theme.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Udvejning() {
        Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopBar(id = R.string.Udvejning)
        }
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
                ){

            Logo2()

            Divider(modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Black)

            Boks(enhed = R.string.Udvjening_Vægt,
                tal =R.string.Udvejning_Vægt_Værdi )

            Boks(enhed=R.string.Udvejning_Pris,
                tal= R.string.Udvejning_Pris_Værdi)
            
            Spacer(modifier = Modifier.height(29.dp))

            Divider(modifier = Modifier.width(300.dp),
                thickness = 1.dp,
                color = Color.Black)

            Text(
                text= stringResource(id = R.string.Valgt_Materiale),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Inter,
                lineHeight = 24.sp,
                modifier=Modifier.padding(top=15.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.udvejning_billede),
                contentDescription =null,
                modifier= Modifier
                    .padding(top = 20.dp)
                    .height(150.dp)
                    .width(180.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Billedetekst(tekst = R.string.Infotekst,
                varenr = R.string.Varenr,
                krprkg =R.string.Krprkg )

            Spacer(modifier = Modifier.height(40.dp))

            TextButton(
                modifier = Modifier.width(150.dp).height(45.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = colorResource(id = R.color.Betalgrøn),
                    )
            ) {
                Text(text = stringResource(id =R.string.Betal),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter,
                    lineHeight = 24.sp,
                    )
            }
        }
    }
}
@Composable
    fun Boks (@StringRes enhed: Int,
              @StringRes tal: Int
                ) {
        Row(modifier= Modifier
            .width(400.dp)
            .height(120.dp)
            .padding(start = 29.dp, top = 20.dp, end = 30.dp)
            .border(width = 1.dp, color = Color.Black),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
            buildAnnotatedString {
                withStyle(style= SpanStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Inter,)){
                    append(stringResource(id = enhed))
                }
                append("\n")
                withStyle(style= SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Inter,)){
                    append(stringResource(id = tal))
                }
            },
            modifier=Modifier.padding(top=20.dp),
                textAlign=TextAlign.Center)
        }
}

@Composable
fun Billedetekst (@StringRes tekst: Int,
                @StringRes varenr: Int,
                @StringRes krprkg: Int) {
    Column(
        modifier = Modifier
            .width(330.dp)
            .height(105.dp)
            .background(color = colorResource(id = R.color.LyseGrå))
    ) {
        Text(
            text = stringResource(id = tekst),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Inter,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row() {

            Text(text = "Varenr: "+stringResource(id = varenr),
            textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Inter,
                color = Color.Gray,
            modifier = Modifier.padding())

            Spacer(modifier = Modifier.width(140.dp))


            Text(text = stringResource(id = krprkg),
            textAlign = TextAlign.End,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Inter,
                modifier = Modifier.padding())
        }
    }
}

@Preview (showBackground = true)
@Composable
fun DefaultPreview12() {
    MaterialepladsenTheme {
        Udvejning()
    }
}