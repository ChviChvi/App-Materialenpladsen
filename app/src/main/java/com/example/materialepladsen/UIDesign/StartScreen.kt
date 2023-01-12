package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.materialepladsen.R
import com.example.materialepladsen.viewmodel.StateOfStart

@Composable
fun StartScreen(
                state: StateOfStart,
                userFound:Boolean,
                navigateFunction :() -> Unit = {},
                setFailState:() -> Unit = {},
                weighInFunction:() -> Unit = {},
){


    Column {

       if (state== StateOfStart.FejlStart)
       {Text(text = stringResource(id = R.string.ForbindelseFejlStart))}

        if (state==StateOfStart.Start)
        {Text(text = stringResource(id = R.string.VægtStart))}


        TextButton(
            onClick = {

                if (userFound){
                    navigateFunction()
                    weighInFunction()


                }
                else {setFailState()}
            })
        {
            Text(text = stringResource(id = R.string.Start))
        }

    }
}