package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.Material


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReadyScreen(
    onVejIgenButtonClicked: () -> Unit = {},
    onVejIgenOgBetalButtonClicked: () -> Unit = {},
    weighInWeight:Float,
    middleWeight:Float,
    weighToPay: Float,
    navigateToBetaling:() -> Unit = {},
    materiallist: List<Material>,
    chooseMaterial: (Material) -> Unit,
    calculatePrice: () -> Unit = {},
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
            }
        ) {
            TextField(
                readOnly = true,
                value = selectedOption.materialName+" ("+selectedOption.productSize+")",
                onValueChange = {chooseMaterial(selectedOption) },
                label = { Text("Vælg dit materiale") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
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

                        }
                    ) {
                        Text(text = item.materialName +" ("+item.productSize+")")
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
            onClick = { onVejIgenButtonClicked() }) {
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
                onVejIgenOgBetalButtonClicked()
                calculatePrice()
                navigateToBetaling()

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
