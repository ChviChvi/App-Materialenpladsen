package com.example.materialepladsen.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.materialepladsen.R
import com.example.materialepladsen.UIDesign.GlemtAdgangskode
import com.example.materialepladsen.viewmodel.Granitskærver
import com.example.materialepladsen.viewmodel.Genbrugsmaterialer
import com.example.materialepladsen.viewmodel.GrusOgSand
import com.example.materialepladsen.viewmodel.JordOgMuld
import com.example.materialepladsen.viewmodel.Sten
import com.example.materialepladsen.viewmodel.TræflisOgBark
import com.example.materialepladsen.viewmodel.MaterialList

@Composable
fun Materialer(){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()

    ){
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            )
            {
                items(Granitskærver) { Material ->
                    Box() {
                        Text(text = Material.materialName)
                        AsyncImage(
                            model = Material.picture,
                            contentDescription = null,
                            placeholder = painterResource(id = R.drawable.loadingimage)
                        )
                        Text(text = Material.materialPrice.toString())
                    }

                }
            }
        }
    }
 }
@Preview(showBackground = true)
@Composable
fun ComposablePreview3() {
    Materialer()
}



