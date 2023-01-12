package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Betaling (
    modifier: Modifier = Modifier,
    navController: NavController,
    weighInWeight:Float,
    outWeight:Float,
    weighToPay:Float,
    @DrawableRes materialeBillede: Int,
    @StringRes materiale:Int,
    price: Float,
    addToBuyHistory :() -> Unit = {}
) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Indvejningsvægt)+ weighInWeight,
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Udvejningsvægt)+outWeight,
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Afrejningsvægt)+weighToPay,
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
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
                Image(
                    painterResource(materialeBillede),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                )
                Spacer(modifier = Modifier.height(15.dp))
            }

            //Materiale
            Text(
                text = stringResource(id = R.string.Materiale)+ stringResource(id = materiale),
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )

            Spacer(modifier = Modifier.height(30.dp))

            //Pris
            Text(
                text = stringResource(id = R.string.Samletpris)+price+"DKK",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))

            Column(
                Modifier
                    .padding(start = 90.dp)
                    .align(Alignment.Start)) {
                // Button 1: Betalingskort
                TextButton(
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    onClick = { addToBuyHistory()},
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
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    onClick = { addToBuyHistory },
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
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    onClick = { addToBuyHistory  },
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
        //Betaling(100f,200f,R.drawable.s_lvplade,"sølvplade",300.00f)
    }}