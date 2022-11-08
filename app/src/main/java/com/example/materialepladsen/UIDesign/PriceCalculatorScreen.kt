package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.viewmodel.PriceCalculatorViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.cities

@Composable
fun PriceCalculatorScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    priceCalculatorViewModel: PriceCalculatorViewModel = viewModel()
) {
    val uiState = priceCalculatorViewModel.uiState.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            PostalCodeTextField()
            CitySelector(cities = cities.map { city -> city.city })
        }
        DeliveryMethods(tabs = uiState.value.deliveryMethods)
        WeightSlider(priceCalculatorViewModel = priceCalculatorViewModel)
        ChosenMaterial(material = uiState.value.materialName)
        Purchase(text = uiState.value.totalPrice.toString() + " Kr. inkl. moms", onClick = { navController.navigate("Betaling") })
    }
}

@Composable
fun Purchase(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(backgroundColor = Color.hsl(156f, 1f, 0.67f)),
        modifier = Modifier.padding(vertical = 4.dp))
    {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ChosenMaterial(material: String) {
    Text(
        text= "Materiale: $material",
        fontSize = 20.sp,
    )

    Image(
        painter = painterResource(id = R.drawable.udvejning_billede),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(0.8f)
    )
}

@Composable
fun DeliveryMethods(tabs: List<String>) {
    val selected = remember{ mutableStateOf(0) }
    TabRow(selectedTabIndex = selected.value) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selected.value == index,
                onClick = {
                    selected.value = index
                }
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun PostalCodeTextField() {
    val state = remember { mutableStateOf(TextFieldValue(text = "")) }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        singleLine = true,
        label = { Text("Postnummer: ") },
        modifier = Modifier
            .fillMaxWidth(0.3f)
            .padding(end = 5.dp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CitySelector(modifier: Modifier = Modifier, cities: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(cities[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text("By: ") },
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
            cities.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@Composable
fun WeightSlider(modifier: Modifier = Modifier,
                 priceCalculatorViewModel: PriceCalculatorViewModel) {
    var sliderPosition by remember { mutableStateOf(0f) }

    val volume = PriceCalculatorViewModel.getVolumeFromSlider(sliderPosition)

    Text(text = volume.toString() + "m3")
    Slider(
        value = sliderPosition,
        onValueChange = {
            sliderPosition = it
            priceCalculatorViewModel.setVolume(PriceCalculatorViewModel.getVolumeFromSlider(it))
            priceCalculatorViewModel.updatePrice()
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        steps = 35,
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Magenta,
            inactiveTickColor = Color.Yellow
        )
    )
}