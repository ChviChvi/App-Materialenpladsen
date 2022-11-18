package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*
import com.example.materialepladsen.viewmodel.BetalingViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Betaling (
    modifier: Modifier = Modifier,
    navController: NavController,
    betalingViewModel: BetalingViewModel = viewModel()
) {
    val uiState = betalingViewModel.uiState.collectAsState()


    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopBar(R.string.Betaling)
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo3()

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Indvejningsvægt)+ uiState.value.weighIn.toString(),
                modifier = Modifier.padding(start = 15.dp).align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Udvejningsvægt)+uiState.value.weighOut.toString(),
                modifier = Modifier.padding(start = 15.dp).align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.Afrejningsvægt)+uiState.value.totalWeight.toString(),
                modifier = Modifier.padding(start = 15.dp).align(Alignment.Start),
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
                    painterResource(uiState.value.materialPicture),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                )
                Spacer(modifier = Modifier.height(15.dp))
            }

            //Materiale
            Text(
                text = stringResource(id = R.string.Materiale)+uiState.value.material,
                modifier = Modifier.padding(start = 15.dp).align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )

            Spacer(modifier = Modifier.height(30.dp))

            //Pris
            Text(
                text = stringResource(id = R.string.Samletpris)+uiState.value.price.toString()+"DKK",
                modifier = Modifier.padding(start = 15.dp).align(Alignment.Start),
                style = MaterialTheme.typography.h6,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))

            Column(Modifier.padding(start = 90.dp).align(Alignment.Start)) {
                // Button 1: Betalingskort
                TextButton(
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    onClick = {betalingViewModel.addToBuyHistory(
                        uiState.value.material,
                        uiState.value.totalWeight,
                        uiState.value.date,
                        uiState.value.price,
                        uiState.value.ordernr,
                        navController=navController
                    ) },
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
                    onClick = { betalingViewModel.addToBuyHistory(
                        uiState.value.material,
                        uiState.value.totalWeight,
                        uiState.value.date,
                        uiState.value.price,
                        uiState.value.ordernr,
                        navController=navController
                    ) },
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
                    onClick = { betalingViewModel.addToBuyHistory(
                        uiState.value.material,
                        uiState.value.totalWeight,
                        uiState.value.date,
                        uiState.value.price,
                        uiState.value.ordernr,
                        navController=navController
                    )  },
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
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    MaterialepladsenTheme {
        //Betaling(100f,200f,R.drawable.s_lvplade,"sølvplade",300.00f)
    }}