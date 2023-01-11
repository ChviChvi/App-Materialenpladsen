package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
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
import com.example.materialepladsen.viewmodel.BetalingViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OpretBruger() {

    Column (
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,



    ) {
        // general information for oprettelse
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val licenceplate = remember { mutableStateOf(TextFieldValue()) }
        val firstname = remember { mutableStateOf(TextFieldValue()) }
        val lastname = remember { mutableStateOf(TextFieldValue()) }
        val adress = remember { mutableStateOf(TextFieldValue()) }
        val cityname = remember { mutableStateOf(TextFieldValue()) }
        val postalcode = remember { mutableStateOf(TextFieldValue()) }
        val email = remember { mutableStateOf(TextFieldValue()) }

        // Card information
        val cardtype = remember { mutableStateOf(TextFieldValue()) }
        val cardnumber = remember { mutableStateOf(TextFieldValue()) }
        val CVV = remember { mutableStateOf(TextFieldValue()) }
        val experationdate = remember { mutableStateOf(TextFieldValue()) }



        Text(text = "Register user",
        fontSize = 30.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Please insert information")
        Spacer(modifier = Modifier.height(20.dp))

        // Username field with inputable data
        TextField(
            label = { Text(text = "Username") },
            value = username.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { username.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // password field with inputable data
        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // License plate
        TextField(
            label = { Text(text = "License plate") },
            value = licenceplate.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { licenceplate.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // first name
        TextField(
            label = { Text(text = "First name") },
            value = firstname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { firstname.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // last name
        TextField(
            label = { Text(text = "Last name") },
            value = lastname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { lastname.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // adress
        TextField(
            label = { Text(text = "Adress") },
            value = adress.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { adress.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // city name
        TextField(
            label = { Text(text = "City") },
            value = cityname.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { cityname.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // postal code
        TextField(
            label = { Text(text = "Postal code") },
            value = postalcode.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            onValueChange = { postalcode.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // Email
        TextField(
            label = { Text(text = "Email Adress") },
            value = email.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { email.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // Cardtype
        TextField(
            label = { Text(text = "Cardtype") },
            value = cardtype.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { cardtype.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // Cardnumber
        TextField(
            label = { Text(text = "Card number") },
            value = cardnumber.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            onValueChange = { cardnumber.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // CVV
        TextField(
            label = { Text(text = "CVV") },
            value = CVV.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            onValueChange = { CVV.value = it })
        Spacer(modifier = Modifier.height(20.dp))

        // experation date
        TextField(
            label = { Text(text = "Experation Date") },
            value = experationdate.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            onValueChange = { experationdate.value = it })
        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Preview (showBackground = true)
@Composable
fun ComposablePreview() {
    OpretBruger()
}