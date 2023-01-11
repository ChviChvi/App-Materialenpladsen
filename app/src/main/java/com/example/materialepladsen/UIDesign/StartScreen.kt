package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.materialepladsen.R

@Composable
fun StartScreen(
                state: String,
                userFound:Boolean,
                navigateFunction :() -> Unit = {},
                setFailState:() -> Unit = {},
                weighInFunction:() -> Unit = {},
){


    Column {

       if (state=="FejlStart")
       {Text(text = stringResource(id = R.string.FejlStart))}

        if (state=="Start")
        {Text(text = stringResource(id = R.string.Start))}


        TextButton(
            onClick = {

                if (userFound){
                    navigateFunction()
                    weighInFunction()
                    //navController.navigate("Ready Screen")

                }
                else {setFailState()}
            })
        {
            Text(text = "Start")
        }

    }
}