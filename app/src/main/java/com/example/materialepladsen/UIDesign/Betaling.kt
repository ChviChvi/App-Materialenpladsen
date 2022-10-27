package com.example.materialepladsen.UIDesign

import android.graphics.Paint.Align
import android.location.GnssAntennaInfo.PhaseCenterOffset
import android.view.Gravity
import android.widget.LinearLayout
import androidx.compose.foundation.Image
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
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
import com.example.materialepladsen.ui.theme.*

@Composable
fun Betaling () {

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopBar(R.string.Betaling)
        }
    ) {

        Column() {
            Logo3()

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Indvejningsvægt),
                modifier = Modifier.padding(start = 15.dp),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Udvejningsvægt),
                modifier = Modifier.padding(start = 15.dp),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Afrejningsvægt),
                modifier = Modifier.padding(start = 15.dp),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))

// Det valgte materiale
            Row(modifier = Modifier.padding(start = 0.dp)) {
                Spacer(modifier = Modifier.width(1.dp))
                Initialize_Map(
                    billede = R.drawable.udvejning_billede,
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
//Materiale
            Text(
                text = stringResource(id = R.string.Materiale),
                modifier = Modifier.padding(start = 15.dp),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(30.dp))
//Pris
            Text(
                text = stringResource(id = R.string.Samletpris),
                modifier = Modifier.padding(start = 15.dp),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))

// Button 1: Betalingskort
            TextButton(
                modifier = Modifier.width(200.dp).height(50.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Blue,
                    backgroundColor = colorResource(id = R.color.LyseGrå),
                )
            ) {
                Text(
                    text = stringResource(id = R.string.Betalingkort),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter,
                    lineHeight = 24.sp,
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

// Button 2: Mobilepay
            TextButton(
                modifier = Modifier.width(200.dp).height(50.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Blue,
                    backgroundColor = colorResource(id = R.color.LyseGrå),
                )
            ) {
                Text(
                    text = stringResource(id = R.string.Mobilepay),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter,
                    lineHeight = 24.sp,
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

// Button 3: Pay by Plate
            TextButton(
                modifier = Modifier.width(200.dp).height(50.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Blue,
                    backgroundColor = colorResource(id = R.color.LyseGrå),
                )
            ) {
                Text(
                    text = stringResource(id = R.string.PaybyPlate),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter,
                    lineHeight = 24.sp,
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    MaterialepladsenTheme {
        Betaling()
    }}