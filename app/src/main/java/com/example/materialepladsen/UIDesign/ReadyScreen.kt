package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.Material
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReadyScreen(
    weighInWeight:Float,
    middleWeight:Float,
    weighToPay: Float,
    materiallist: List<Material>,
    chooseMaterial: (Material) -> Unit,
    navigateToWaitingScreen2:() -> Unit = {},
    navigateToWaitingScreen3:() -> Unit = {},
){




    Column(
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = stringResource(id = R.string.Readytopickmaterials),
            modifier= Modifier.padding(top = 30.dp, bottom = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        var expanded by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf(materiallist[0]) }

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(top=30.dp, bottom = 30.dp),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
        ) {
            TextField(
                readOnly = true,
                value = selectedOption.materialName+" ("+selectedOption.productSize+")",
                onValueChange = {chooseMaterial(selectedOption) },
                label = { Text("Vælg dit materiale", color = Color.White) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.DarkRed),
                    textColor = Color.White,
                    trailingIconColor = Color.White,
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    leadingIconColor = Color.White,
                    focusedTrailingIconColor = Color.White,
                    focusedLabelColor = Color.White,
                    placeholderColor = Color.White,

                    )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                materiallist.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = item
                            expanded = false
                            chooseMaterial(item)

                        },
                        modifier = Modifier.background(color = colorResource(id = R.color.DarkRed))

                    ) {
                        Text(text = item.materialName +" ("+item.productSize+")",
                        color = Color.White)
                    }
                }
            }
        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkRed),
            ),
            modifier = Modifier
                .padding(top = 30.dp)
                .width(150.dp)
                .height(40.dp),
            onClick = { navigateToWaitingScreen2() }) {
            Text(text = stringResource(id = R.string.vejigen),
            fontWeight = FontWeight.Bold
            )

        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkRed),
            ),
            modifier = Modifier
                .padding(top = 30.dp)
                .width(150.dp)
                .height(40.dp),
            onClick = {
                navigateToWaitingScreen3()
        }) {
            Text(text = stringResource(id = R.string.vejigenogbetal),
                fontWeight = FontWeight.Bold)

        }



        Text(text = stringResource(id = R.string.dinindvejning)+"\n"+weighInWeight+ stringResource(id = R.string.Kg),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline )

        Text(text = stringResource(id = R.string.dinvejning)+"\n"+middleWeight+stringResource(id = R.string.Kg),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        Text(text = stringResource(id = R.string.Differens)+"\n"+weighToPay+stringResource(id = R.string.Kg),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline )

    }
}

@Composable
fun WaitingScreen2(
    middleWeight:() -> Unit = {},
    navigateFunction:() -> Unit = {},
    ){
    val scope = rememberCoroutineScope()


    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,){
        Text(text = stringResource(id = R.string.dinbilblirvejet),
            modifier= Modifier.padding(30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loadingimage),
            contentDescription = null,

            )

        LaunchedEffect(Unit){
            scope.launch { delay(1000); middleWeight();navigateFunction(); }
        }
    }
}

@Composable
fun WaitingScreen3(
    navigateToBetaling :() -> Unit = {},
    onVejIgenOgBetalButtonClicked:() -> Unit = {},
    calculatePrice:() -> Unit = {}
    ){
    val scope = rememberCoroutineScope()


    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,){
        Text(text = stringResource(id = R.string.dinbilblirvejet),
            modifier= Modifier.padding(30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loadingimage),
            contentDescription = null,

            )

        LaunchedEffect(Unit){
            scope.launch {delay(1000); onVejIgenOgBetalButtonClicked();calculatePrice();navigateToBetaling() }
        }
    }
}
