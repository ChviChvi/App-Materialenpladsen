    package com.example.materialepladsen

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.UIDesign.Betaling
import com.example.materialepladsen.UIDesign.Findos
import com.example.materialepladsen.UIDesign.Købshistorik
import com.example.materialepladsen.UIDesign.PriceCalculatorScreen
import com.example.materialepladsen.ui.theme.*
import com.example.materialepladsen.viewmodel.Købshistorikliste
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
import com.google.android.exoplayer2.ui.StyledPlayerView

import kotlinx.coroutines.launch

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
                    drawerContent = { DrawerView(navController) },
                    topBar = {
                        TopAppBar(
                            elevation = 4.dp,
                            title = {
                                Row(modifier = Modifier.fillMaxSize(1f).padding(10.dp)) {
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
fun DrawerView(navController: NavController) {
    val pages = listOf("Forside", "Materialer", "Pris udregning", "Købshistorik", "Om os", "Find os")
    LazyColumn {
        items(pages.size){ index->
            AddDrawerContentView(title = pages[index], func = { navController.navigate(pages[index])})
        }
    }

}
@Composable
fun AddDrawerContentView(title: String, func: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { func() }
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

