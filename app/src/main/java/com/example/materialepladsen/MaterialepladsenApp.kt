package com.example.materialepladsen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.UIDesign.*
import com.example.materialepladsen.ui.theme.*
import com.example.materialepladsen.viewmodel.FlowViewModel
import com.example.materialepladsen.viewmodel.StateOfStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun MaterialepladsenApp(
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "loginpladsen"
    ) {
        composable(route = "loginpladsen") {
            LoginPladsen(navigateToForside = { navController.navigate("materialepladsen")})
        }
        composable(route = "materialepladsen") {
            Materialepladsen()
        }

    }

}


@Composable
fun DrawerView(navController: NavController, func1: () -> Unit) {
    val pages = listOf("Forside", "Materialer", "Købshistorik", "Om os", "Find os","Materialepladsen")
    LazyColumn {
        items(pages.size){ index->
            AddDrawerContentView(
                title = pages[index],
                func = { navController.navigate(pages[index])},
                func1 = func1)
        }
    }

}

@Composable
fun AddDrawerContentView(title: String, func: () -> Unit, func1: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { func(); func1() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        if (title.isNotEmpty()) {
            Text(text = title, modifier = Modifier.weight(1f),fontSize = 12.sp)
        }

    }
}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun Materialepladsen(
    flowViewModel: FlowViewModel = viewModel()
){

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val uiState = flowViewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxWidth(),
        drawerContent = { DrawerView(navController) { scope.launch { delay(250); scaffoldState.drawerState.close() } } },
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Row(modifier = Modifier
                        .fillMaxSize(1f)
                        .padding(10.dp)
                        .clickable { navController.navigate("Forside") }) {
                        Image(painterResource(R.drawable.logo_materialepladsen), null)
                    }
                },
                backgroundColor =  colorResource(id = R.color.DarkRed),
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, null)
                    }
                })
        }
    ){
        NavHost(
            navController = navController,
            startDestination = "Forside"
        ) {

            composable(route = "Pris udregning") {
                PriceCalculatorScreen(navController = navController)
            }
            composable(route = "Betaling") {
                Betaling(
                    weighInWeight = uiState.value.weighInWeight,
                    outWeight = uiState.value.outWeight,
                    weighToPay = uiState.value.weighToPay,
                    materiale = uiState.value.chosenMaterial,
                    price = uiState.value.price,
                    addToBuyHistory = {flowViewModel.addToBuyHistory(it)},
                    navigateToOrderHistory = {navController.navigate("Købshistorik")},

                )
            }
            composable(route = "Købshistorik") {
                OrderHistory(
                    buyHistory = uiState.value.orderhistory,
                    state = uiState.value.state,
                    resetBuy = {flowViewModel.resetBuy()})
            }
            composable(route = "Materialer") {
                Materialer()
            }
            composable(route = "Forside") {
                Forside(navController = navController,
                    navigateToProducts = {navController.navigate("Materialer")})
            }
            composable(route = "Om os") {
                Omos(navController = navController)
            }
            composable(route = "Find os") {
                Findos(navController = navController)
            }

            composable(route = "Materialepladsen") {
                if(uiState.value.state==StateOfStart.KorrektStart ){
                    ReadyScreen(
                        weighInWeight = uiState.value.weighInWeight,
                        middleWeight = uiState.value.middleWeight,
                        weighToPay = uiState.value.weighToPay,
                        materiallist = uiState.value.materialList,
                        chooseMaterial = {flowViewModel.chooseMaterial(it)},
                        navigateToWaitingScreen2 = { navController.navigate("Waiting Screen2")},
                        navigateToWaitingScreen3 = { navController.navigate("Waiting Screen3")},
                    )
                }
                if(uiState.value.state==StateOfStart.Betal ){
                    Betaling(
                        weighInWeight = uiState.value.weighInWeight,
                        outWeight = uiState.value.outWeight,
                        weighToPay = uiState.value.weighToPay,
                        materiale = uiState.value.chosenMaterial,
                        price = uiState.value.price,
                        addToBuyHistory = {flowViewModel.addToBuyHistory(it)},
                        navigateToOrderHistory = {navController.navigate("Købshistorik")}
                    )
                }
                else if (uiState.value.state==StateOfStart.Start ){
                    StartScreen(
                        state = uiState.value.state,
                        userFound = uiState.value.userFound,
                        setFailState = {flowViewModel.Fejlstart()},
                        navigateFunction = {navController.navigate("Waiting Screen")}
                    )}

            }
            composable(route = "Waiting Screen") {
                WaitingScreen(
                    navigateFunction = { navController.navigate("Ready Screen") },
                    weighInFunction = {flowViewModel.weighIn()},
                )
            }
            composable(route = "Waiting Screen2") {
                WaitingScreen2(
                    middleWeight = {flowViewModel.middleWeight()},
                    navigateFunction = {navController.navigate("Ready Screen")},
                )
            }
            composable(route = "Waiting Screen3") {
                WaitingScreen3(
                    calculatePrice ={flowViewModel.calculatePrice()} ,
                    onVejIgenOgBetalButtonClicked = {flowViewModel.weighOutAndPay()},
                    navigateToBetaling = {navController.navigate("Betaling")},
                )
            }
            composable(route = "Ready Screen") {
                ReadyScreen(
                    weighInWeight = uiState.value.weighInWeight,
                    middleWeight = uiState.value.middleWeight,
                    weighToPay = uiState.value.weighToPay,
                    materiallist = uiState.value.materialList,
                    chooseMaterial = {flowViewModel.chooseMaterial(it)},
                    navigateToWaitingScreen2 = { navController.navigate("Waiting Screen2")},
                    navigateToWaitingScreen3 = { navController.navigate("Waiting Screen3")},
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginPladsen(
    navigateToForside:() -> Unit = {}
){
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Row(modifier = Modifier
                        .fillMaxSize(1f)
                        .padding(10.dp)) {
                        Image(painterResource(R.drawable.logo_materialepladsen), null)
                    }
                },
                backgroundColor =  colorResource(id = R.color.DarkRed),
                )
        }


    ) {
        NavHost(
            navController=navController,
            startDestination = "login"
        ){
            composable(route = "login") {
                Login(navigateToOpretBruger = {navController.navigate("Opret Bruger")},
                    navigateToGlemt = {navController.navigate("Glemt adgangskode")},
                    navigateToForside = {navigateToForside()})
            }
            composable(route = "Glemt adgangskode") {
                GlemtAdgangskode(navigateGem = {navController.navigate("login")},
                    navigateback = {navController.navigate("login")})
            }
            composable(route = "Opret Bruger") {
                OpretBruger(navigateFunction = {navController.navigate("login")},
                    navigateFunction1 = { navController.navigate("login") })
            }


        }

    }




}