package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.materialepladsen.ui.theme.*
import com.example.materialepladsen.viewmodel.Order
import com.example.materialepladsen.R


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
    ){
        items(buyHistory){Order->
            OrderItem(order = Order)
        }
    }

    }

@Composable
fun OrderItem (order: Order
    ){

        // Materiale, Vægt og dato
        Row(
            modifier=Modifier.padding(start=20.dp,top=20.dp).
            height(100.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            Text(text = stringResource(id = R.string.Materiale) + order.materiale.materialName
            +"\n"+ stringResource(id = R.string.Udvejningsvægt)+order.weight.toString()+"\n"+
            stringResource(id = R.string.prisprkg)+order.materiale.materialPrice+"\n"
            +order.pris)

            AsyncImage(model = order.materiale.picture,
                contentDescription =null,
                modifier = Modifier.size(40.dp) )

            
            Spacer(modifier = Modifier.width(80.dp))

            Text(text = order.dato.toString(),
                lineHeight = 12.sp,
            style=MaterialTheme.typography.subtitle2)
        }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    MaterialepladsenTheme {
        //Købshistorik()
    }
}