package com.example.materialepladsen.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            {
                items(Granitskærver) { Material ->
                    Box(
                    ) {
                        AsyncImage(
                            modifier = Modifier.padding(10.dp).align(Alignment.Center),
                            model = Material.picture,
                            contentDescription = null,
                            placeholder = painterResource(id = R.drawable.loadingimage)
                        )
                        Text(text = Material.materialName, fontSize = 40.sp,
                            modifier = Modifier.align(Alignment.TopStart)
                                .padding(bottom = 10.dp)
                                .background(color = Color.White, shape = RectangleShape))

                        Text(text = Material.productSize, fontSize = 20.sp,
                            modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 10.dp))

                        Text(text = Material.materialPrice.toString(), fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.BottomStart).padding(bottom = 10.dp))
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



