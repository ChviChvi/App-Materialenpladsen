package com.example.materialepladsen.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.materialepladsen.ui.theme.*
import com.example.materialepladsen.Data.Order
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.StateOfStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderHistory (
    buyHistory: List<Order>,
    state: StateOfStart,
    resetBuy:() -> Unit = {},
    ){
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit){
        scope.launch { delay(2500); resetBuy() }
    }

    if (state==StateOfStart.Betal){
    val openDialog = remember{ mutableStateOf(true) }

    if (openDialog.value) {



        LaunchedEffect(Unit){
            scope.launch { delay(2500); openDialog.value=false; }
        }
        AlertDialog(
            modifier = Modifier.width(200.dp),
            onDismissRequest = { openDialog.value = false},
            title = { Text(
                    text = stringResource(id = R.string.Tak),
                    color = colorResource(id = R.color.DarkRed),
                    style = MaterialTheme.typography.overline


                ) },
            text = { Text(
                    text = stringResource(id = R.string.Takfordi),
                    color = colorResource(id = R.color.DarkRed),
                    style = MaterialTheme.typography.overline) },
            confirmButton = {
                Button(onClick = { openDialog.value = false},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = colorResource(
                            id = R.color.DarkRed
                        ))) {
                    Text(text = stringResource(id = R.string.SelvTak,
                    ))
                }
            }
        )

    }}



    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
    ){
        items(buyHistory){Order->
            OrderItem(order = Order)
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }

    }

@Composable
fun OrderItem (order: Order
    ){

        // Materiale, Vægt og dato
        Row(
            modifier= Modifier
                .padding(start = 5.dp, top = 10.dp, bottom = 2.dp)
                .height(80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {

            Text(text = stringResource(id = R.string.Materiale) +" "+ order.materiale.materialName
            +"\n"+ stringResource(id = R.string.Udvejningsvægt)+" "+order.weight.toString()+" KG"+"\n"+
            stringResource(id = R.string.prisprkg)+" "+order.materiale.materialPrice+" DKK"+"\n"
            + stringResource(id = R.string.Samletpris)+" "+order.pris+" DKK")

            Spacer(modifier = Modifier.width(10.dp))

            AsyncImage(model = order.materiale.picture,
                contentDescription =null,
                modifier = Modifier.size(100.dp) )

            
            Spacer(modifier = Modifier.width(30.dp))

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