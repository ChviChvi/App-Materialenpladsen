package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.StateOfStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StartScreen(
                state: StateOfStart,
                userFound:Boolean,
                setFailState:() -> Unit = {},
                navigateFunction :() -> Unit = {},

){

    Start(state = state,
        userFound =userFound,
        setFailState,
        navigateToWaitingScreen = navigateFunction,

    )
}

@Composable
fun Start(
    state: StateOfStart,
    userFound:Boolean,
    setFailState:() -> Unit = {},
    navigateToWaitingScreen :() -> Unit = {},

){


    Column (
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){


        if (state== StateOfStart.FejlStart)
        {Text(text = stringResource(id = R.string.ForbindelseFejlStart),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline
        )}

        else
        {Text(text = stringResource(id = R.string.VægtStart),
            modifier= Modifier.padding(30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)}


        TextButton(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkRed)
                ),
            modifier = Modifier
                .padding(top = 50.dp)
                .width(100.dp)
                .height(40.dp),
            onClick = {


                if (userFound){
                  navigateToWaitingScreen()
                }
                else {setFailState()}
            })
        {
            Text(text = stringResource(id = R.string.Start))
        }

    }

}

@Composable
fun WaitingScreen(
    navigateFunction :() -> Unit = {},
    weighInFunction:() -> Unit = {},

){
    val scope = rememberCoroutineScope()


    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,){
        Text(text = stringResource(id = R.string.vent),
            modifier= Modifier.padding(30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loadingimage),
            contentDescription = null,

        )

        LaunchedEffect(Unit){
            scope.launch {delay(1000); navigateFunction();weighInFunction() }
        }





    }
}