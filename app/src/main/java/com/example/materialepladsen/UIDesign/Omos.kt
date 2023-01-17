package com.example.materialepladsen.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.materialepladsen.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Omos(navController: NavController) {
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
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Link1),
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
                    .width(350.dp),
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
                    .width(350.dp),
                text = stringResource(id = R.string.Link3),
                style = MaterialTheme.typography.body2,
                lineHeight = 15.sp
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .width(350.dp),
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
        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .width(350.dp),
                text = stringResource(id = R.string.Link5),
                style = MaterialTheme.typography.body2,
                lineHeight = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    MaterialepladsenTheme {
        val navController = rememberNavController()
        Omos(navController = navController)
    }}
