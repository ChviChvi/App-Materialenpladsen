package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
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
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*
import coil.compose.AsyncImage
import com.example.materialepladsen.viewmodel.Material
import com.example.materialepladsen.viewmodel.Order
import java.util.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Betaling (
    weighInWeight:Float,
    outWeight:Float,
    weighToPay:Float,
    materiale:Material,
    addToBuyHistory :(Order) -> Unit,
    price:Float,
    navigateToOrderHistory:() -> Unit = {},
    resetBuy:() -> Unit = {},
) {

    val order=Order(materiale,weighToPay, Date(),price)

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
                text = stringResource(id = R.string.Indvejningsvægt)+" "+ weighInWeight+" KG",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Udvejningsvægt)+" "+outWeight+" KG",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Afrejningsvægt)+" " +weighToPay+" KG",
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
                AsyncImage(
                    model=materiale.picture,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.loadingimage),
                )
                Spacer(modifier = Modifier.height(15.dp))
            }

            //Materiale
            Text(
                text = stringResource(id = R.string.Materiale)+" "+ materiale.materialName,
                modifier = Modifier
                    .padding(start = 15.dp,top=15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = stringResource(id = R.string.prisprkg)+" "+ materiale.materialPrice+ " DKK",
                modifier = Modifier
                    .padding(start = 15.dp,top=15.dp)
                    .align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )



            //Pris
            Text(
                text = stringResource(id = R.string.Samletpris)+" "+price+" DKK",
                modifier = Modifier
                    .padding(start = 15.dp,top=15.dp)
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
                    onClick = {
                        addToBuyHistory(order)
                        resetBuy()
                        navigateToOrderHistory()
                        },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = colorResource(id = R.color.DarkRed),
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
                    onClick = {
                        addToBuyHistory(order)
                        resetBuy()
                        navigateToOrderHistory()
                        },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = colorResource(id = R.color.DarkRed),
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
                    onClick = {
                        addToBuyHistory(order)
                        resetBuy()
                        navigateToOrderHistory() },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = colorResource(id = R.color.DarkRed),
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