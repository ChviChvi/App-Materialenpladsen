package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialepladsen.ui.theme.*
import com.example.materialepladsen.viewmodel.Order


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderHistory (
    buyHistory: List<Order>
    ){

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
    ){
        items(buyHistory){Order->
            OrderItem(order = Order)
        }
    }

    }

@Composable
fun OrderItem (order: Order
    ){

    Column(

        modifier=Modifier
            .fillMaxWidth()
    ) {
        // Materiale, Vægt og dato
        Row(
            modifier=Modifier.padding(start=20.dp,top=20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter)){
                        append(order.materiale.materialName) }
                    append(" ")
                    withStyle(SpanStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = Inter)){
                        append(order.weight.toString()) } },
                modifier=Modifier.width(200.dp))
            
            Spacer(modifier = Modifier.width(80.dp))

            Text(text = order.dato.toString(),
                lineHeight = 12.sp,
            style=MaterialTheme.typography.subtitle2)
        }

        //Pris
        Text(
            buildAnnotatedString {
                withStyle(style= SpanStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Inter)){
                    append("Pris - ")
                }
                withStyle(style= SpanStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Inter)){
                    append(order.pris.toString())
                }
                append("\n")
            },
            modifier=Modifier.padding(start=20.dp),
        textAlign = TextAlign.Start,
            lineHeight = 12.sp,)

        //Ordrenummer

        
        Spacer(modifier = Modifier.height(10.dp))

        Divider(modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    MaterialepladsenTheme {
        //Købshistorik()
    }
}