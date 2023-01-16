package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import android.widget.ScrollView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.materialepladsen.R
import com.example.materialepladsen.ui.theme.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OpretBruger() {

    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        // general information for oprettelse
        val username = remember { mutableStateOf(TextFieldValue("")) }
        val password = remember { mutableStateOf(TextFieldValue("")) }
        val licenceplate = remember { mutableStateOf(TextFieldValue("")) }
        val licenceplateMax = 7
        val firstname = remember { mutableStateOf(TextFieldValue("")) }
        val lastname = remember { mutableStateOf(TextFieldValue("")) }
        val adress = remember { mutableStateOf(TextFieldValue("")) }
        val cityname = remember { mutableStateOf(TextFieldValue("")) }
        val postalcode = remember { mutableStateOf(TextFieldValue("")) }
        val postalcodeMax = 4
        val phonenumber = remember { mutableStateOf(TextFieldValue("")) }
        val phonenumberMax = 8
        val email = remember { mutableStateOf(TextFieldValue("")) }

        // Card information
        val cardtype = remember { mutableStateOf(TextFieldValue("")) }
        val cardnumber = remember { mutableStateOf(TextFieldValue("")) }
        val cardnumberMax = 16
        val CVV = remember { mutableStateOf(TextFieldValue("")) }
        val CVVMax = 3
        val experationdate = remember { mutableStateOf(TextFieldValue("")) }
        val experationdateMax = 5



        Text(text = "Opret Bruger",
        fontSize = 30.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Indsæt venligt nedestående informationer")
        Spacer(modifier = Modifier.height(20.dp))

        // Username field with inputable data
        TextField(
            label = { Text(text = "Brugernavn") },
            placeholder = { Text(text = "Indsæt brugernavn her") },
            value = username.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { username.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // password field with inputable data
        TextField(
            label = { Text(text = "Kodeord") },
            placeholder = { Text(text = "Indsæt Kodeord her") },
            value = password.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // License plate
        TextField(
            label = { Text(text = "Nummer plade") },
            placeholder = { Text(text = "Eksempel: DD12312") },
            value = licenceplate.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                if (it.text.length <= licenceplateMax) licenceplate.value = it
            })
        Spacer(modifier = Modifier.height(20.dp))

        // first name
        TextField(
            label = { Text(text = "Fornanvn") },
            placeholder = { Text(text = "Indsæt fornavn her") },
            value = firstname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { firstname.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // last name
        TextField(
            label = { Text(text = "Efternavn") },
            placeholder = { Text(text = "Indsæt efternavn her") },
            value = lastname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { lastname.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // adress
        TextField(
            label = { Text(text = "Adresse") },
            placeholder = { Text(text = "Indsæt adresse her") },
            value = adress.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { adress.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // city name
        TextField(
            label = { Text(text = "By") },
            placeholder = { Text(text = "Indsæt by her") },
            value = cityname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { cityname.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // postal code
        TextField(
            label = { Text(text = "Postnummer") },
            placeholder = { Text(text = "Eksempel: 2800") },
            value = postalcode.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            onValueChange = {
                if (it.text.length <= postalcodeMax) postalcode.value = it
            })
        Spacer(modifier = Modifier.height(20.dp))

        // Phone number
        TextField(
            label = { Text(text = "Mobil nummer") },
            placeholder = { Text(text = "Eksempel: 11223344") },
            value = phonenumber.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            onValueChange = {
                if (it.text.length <= phonenumberMax) phonenumber.value = it
            })
        Spacer(modifier = Modifier.height(20.dp))

        // Email
        TextField(
            label = { Text(text = "Email Adresse") },
            placeholder = { Text(text = "Indsæt email her") },
            value = email.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { email.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        val options = listOf("Visa Debit", "Visa Elektron", "Mastercard", "American Express")
        var expanded by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf(options[0]) }

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
                label = { Text("kort type") },
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
                options.forEach { selectionOption ->
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
        Spacer(modifier = Modifier.height(20.dp))
            // Cardnumber
            TextField(
                label = { Text(text = "kort nummer") },
                placeholder = { Text(text = " Maks. input: 16") },
                value = cardnumber.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                onValueChange = {
                    if (it.text.length <= cardnumberMax) cardnumber.value = it
                })
            Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,

            modifier = Modifier
                .padding(start = 0.dp)
                .fillMaxWidth()) {
            // CVV
            TextField(
                label = { Text(text = "CVV") },
                placeholder = { Text(text = "Eksempel: 321") },
                value = CVV.value,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                onValueChange = {
                    if (it.text.length <= CVVMax) CVV.value = it
                })
            Spacer(modifier = Modifier.width(20.dp))

            // experation date

            TextField(
                label = { Text(text = "Korts Udløbs dato") },
                placeholder = { Text(text = "Eksempel: 01/24") },
                value = experationdate.value,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                onValueChange = {
                    if (it.text.length <= experationdateMax) experationdate.value = it
                })

        }
        Spacer(modifier = Modifier.height(20.dp))

        val Context = LocalContext.current
        //  Tjekker om alle felter er udfyldt
        // button for finishing registration. skal lave en funktion der gemmer val og sender dem til database
        Button(onClick = {
            if (username.value != null){
            Toast.makeText(Context, "Brugernavn er ikke udfyldt", Toast.LENGTH_LONG).show()
            } },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray))
        {
            Text(text = "Finnish Registration",color = Color.White)
        }

    }
}

@Preview (showBackground = true)
@Composable
fun ComposablePreview() {
    OpretBruger()
}