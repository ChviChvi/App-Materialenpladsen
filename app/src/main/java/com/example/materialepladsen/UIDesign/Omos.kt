package com.example.materialepladsen.ui.theme

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.materialepladsen.SERVER.Network.Models.ResponseModel
import com.example.materialepladsen.SERVER.Network.Network1.ApiService
import com.example.materialepladsen.R
import com.example.materialepladsen.SERVER.Network.http.requestOrderNew
import com.example.materialepladsen.SERVER.Network.http.requestOrderPayment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import io.ktor.client.statement.*
import org.json.JSONObject


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation",
    "CoroutineCreationDuringComposition"
)
@Composable
fun Omos(navController: NavController,apiService: ApiService) {

    val context = LocalContext.current
    val Link1 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.materialepladsen.dk/trailerudlejning")) }
    val Link2 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.materialepladsen.dk/vejning")) }
    val Link3 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.materialepladsen.dk/aftalevejning")) }

    //TEST
    var hasRun = false

    CoroutineScope(Dispatchers.Main).launch {
        if (!hasRun) {
            hasRun = true
            val read = requestOrderNew("12542", "CC11345")
            println(read.execute().readText())

            val jsonObject = JSONObject(read.execute().readText())
            val orderNumber = jsonObject.getInt("OrderNumber").toString()

            println("did this work?")
            val read1 = requestOrderPayment("12542", "CC11345",orderNumber)
            println(read1.execute().readText())
        }
    }

    //TEST

    LazyColumn(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)

    ){

        item {
            Divider(color = Color.Black, thickness = 1.2.dp)
        }

        //Text Field 1
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Main_title1),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 3.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Under_title1),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }
        item{
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_text1),
                style=MaterialTheme.typography.body1,
                lineHeight = 15.sp
            )
        }

        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_text2),
                style=MaterialTheme.typography.body1,
                lineHeight = 15.sp
            )
        }

        item{
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Text Field 2
        item{
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_title2),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Main_text3),
                style = MaterialTheme.typography.body1,
                lineHeight = 15.sp
            )
        }
//        item {
//            Text(
//                modifier = Modifier
//                    .padding(start = 10.dp, top = 8.dp)
//                    .width(350.dp),
//                text = stringResource(id = R.string.Link1),
//                style = MaterialTheme.typography.body2,
//                lineHeight = 15.sp
//            )
//        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Text Field 3
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Main_title3),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        item{
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_text4),
                style=MaterialTheme.typography.body1,
                lineHeight = 15.sp
            )
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Text Field 4
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Main_title4),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        item{
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_text5),
                style=MaterialTheme.typography.body1,
                lineHeight = 15.sp
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .width(350.dp)
                    .clickable( enabled = true,
                        onClick = { context.startActivity(Link1) }),
                text = stringResource(id = R.string.Link2),
                style = MaterialTheme.typography.body2,
                lineHeight = 15.sp
            )
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Text Field 5
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Main_title5),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        item{
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_text6),
                style=MaterialTheme.typography.body1,
                lineHeight = 15.sp
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .width(350.dp)
                    .clickable( enabled = true,
                        onClick = { context.startActivity(Link2) }),
                text = stringResource(id = R.string.Link3),
                style = MaterialTheme.typography.body2,
                lineHeight = 15.sp
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .width(350.dp).clickable( enabled = true,
                        onClick = { context.startActivity(Link3) }),
                text = stringResource(id = R.string.Link4),
                style = MaterialTheme.typography.body2,
                lineHeight = 15.sp
            )
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Text Field 3
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Main_title6),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        item{
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(350.dp),
                text= stringResource(id = R.string.Main_text7),
                style=MaterialTheme.typography.body1,
                lineHeight = 15.sp)
        }
//        item {
//            Text(
//                modifier = Modifier
//                    .padding(start = 10.dp, top = 8.dp)
//                    .width(350.dp).clickable( enabled = true,
//                        onClick = { context.startActivity() }),
//                text = stringResource(id = R.string.Link5),
//                style = MaterialTheme.typography.body2,
//                lineHeight = 15.sp
//            )
//        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun ComposablePreview() {
//    MaterialepladsenTheme {
//        val navController = rememberNavController()
//        Omos(navController = navController, apiService = ApiService)
//    }}
