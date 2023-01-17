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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.UIDesign.*
import com.example.materialepladsen.ui.theme.Forside
import com.example.materialepladsen.ui.theme.Login
import com.example.materialepladsen.ui.theme.Materialer
import com.example.materialepladsen.ui.theme.Omos
import com.example.materialepladsen.viewmodel.FlowViewModel
import com.example.materialepladsen.viewmodel.Købshistorikliste
import com.example.materialepladsen.viewmodel.ProductListViewModel
import com.example.materialepladsen.viewmodel.StateOfStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun MaterialepladsenApp(
    modifier: Modifier = Modifier,
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
                        .padding(10.dp)) {
                        Image(painterResource(R.drawable.logo_materialepladsen), null)
                    }
                },
                backgroundColor =  MaterialTheme.colors.primarySurface,
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
            startDestination = "login"
        ) {
            composable(route = "login") {
                Login(/*videoUri = getVideoUri()*/
                    navigateToOpretBruger = {navController.navigate("Opret Bruger")})
            }
            composable(route = "Opret Bruger") {
                OpretBruger(navigateFunction = {navController.navigate("login")})
            }
            composable(route = "Pris udregning") {
                PriceCalculatorScreen(navController = navController)
            }
            composable(route = "Betaling") {
                Betaling(
                    navController = navController,
                    weighInWeight = uiState.value.weighInWeight,
                    outWeight = uiState.value.outWeight,
                    weighToPay = uiState.value.weighToPay,
                    materialeBillede = uiState.value.materialeBillede,
                    materiale = uiState.value.materiale,
                    price = uiState.value.price,
                    addToBuyHistory = {flowViewModel.addToBuyHistory()}
                    )
            }
            composable(route = "Købshistorik") {
                Købshistorik(navController = navController, Købshistorikliste)
            }
            composable(route = "Materialer") {
                Materialer(navController = navController,
                            viewModel = ProductListViewModel()
                )
            }
            composable(route = "Forside") {
                Forside(navController = navController)
            }
            composable(route = "Om os") {
                Omos(navController = navController)
            }
            composable(route = "Find os") {
                Findos(navController = navController)
            }

            composable(route = "Start Screen") {
                if(uiState.value.state==StateOfStart.KorrektStart ){
                    ReadyScreen(
                        onVejIgenButtonClicked = {flowViewModel.middleWeight()},
                        weighInWeight = uiState.value.weighInWeight,
                        middleWeight = uiState.value.middleWeight,
                        weighToPay = uiState.value.weighToPay,
                        onVejIgenOgBetalButtonClicked = {flowViewModel.weighOutAndPay()},
                        navigateToBetaling = { navController.navigate("Betaling") }
                    )
                }
                if(uiState.value.state==StateOfStart.Betal ){
                    Betaling(
                        navController = navController,
                        weighInWeight = uiState.value.weighInWeight,
                        outWeight = uiState.value.outWeight,
                        weighToPay = uiState.value.weighToPay,
                        materialeBillede = uiState.value.materialeBillede,
                        materiale = uiState.value.materiale,
                        price = uiState.value.price,
                        addToBuyHistory = {flowViewModel.addToBuyHistory()}
                    )
                }

                else{
                StartScreen(
                    state = uiState.value.state,
                    userFound = uiState.value.userFound,
                    navigateFunction = { navController.navigate("Ready Screen") },
                    setFailState = {flowViewModel.Fejlstart()},
                    weighInFunction = {flowViewModel.weighIn()}
                    )}

            }
            composable(route = "Ready Screen") {
                ReadyScreen(
                    onVejIgenButtonClicked = {flowViewModel.middleWeight()},
                    weighInWeight = uiState.value.weighInWeight,
                    middleWeight = uiState.value.middleWeight,
                    weighToPay = uiState.value.weighToPay,
                    onVejIgenOgBetalButtonClicked = {flowViewModel.weighOutAndPay()},
                    navigateToBetaling = { navController.navigate("Betaling")}
                )
            }

        }


    }


}





@Composable
fun DrawerView(navController: NavController, func1: () -> Unit) {
    val pages = listOf("Forside", "Materialer", "Pris udregning", "Købshistorik", "Om os", "Find os","Start Screen")
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

