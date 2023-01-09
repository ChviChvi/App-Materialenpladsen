    package com.example.materialepladsen

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.materialepladsen.ui.theme.*



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialepladsenTheme {
                MaterialepladsenApp()
            }
        }
    }
}
/*
    class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            MaterialepladsenTheme {
                val navController = rememberNavController()
                Scaffold(
                    scaffoldState = scaffoldState,
                    modifier = Modifier.fillMaxWidth(),
                    drawerContent = { DrawerView(navController) { scope.launch { delay(350); scaffoldState.drawerState.close() } } },
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
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") {
                            Login(videoUri = getVideoUri())
                        }
                        composable(route = "Pris udregning") {
                            PriceCalculatorScreen(navController = navController)
                        }
                        composable(route = "Betaling") {
                            Betaling(navController = navController)
                        }
                        composable(route = "Købshistorik") {
                            Købshistorik(navController = navController,Købshistorikliste)
                        }
                        composable(route = "Materialer") {
                            Materialer(navController = navController)
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
                        composable(route = "Start Navigate") {
                            StartNavigate()
                        }
                    }
                }
            }
        }
    }


    private fun getVideoUri(): Uri {
        val rawId = resources.getIdentifier("materialepladsenvideo", "raw", packageName)
        val videoUri = "android.resource://$packageName/$rawId"
        return Uri.parse(videoUri)
    }

}


@Composable
fun DrawerView(navController: NavController,func1: () -> Unit) {
    val pages = listOf("Forside", "Materialer", "Pris udregning", "Købshistorik", "Om os", "Find os","Start Navigate")
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
            .clickable { func(); func1()  }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
        if (title.isNotEmpty()) {
                Text(text = title, modifier = Modifier.weight(1f),fontSize = 12.sp)
        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialepladsenTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                TopBar(id = R.string.Materialer)
            }
        ) {
            //PriceCalculatorScreen()
        }
    }
}

 */



