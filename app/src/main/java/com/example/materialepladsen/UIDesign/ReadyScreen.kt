package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.materialepladsen.R


@Composable
fun ReadyScreen(
                onVejIgenButtonClicked: () -> Unit = {},
                onVejIgenOgBetalButtonClicked: () -> Unit = {},
                weighInWeight:Float,
                middleWeight:Float,
                weighToPay: Float,
                navigateToBetaling:() -> Unit = {}
){



    Column(
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = stringResource(id = R.string.Readytopickmaterials),
            modifier= Modifier.padding(top = 30.dp, bottom = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        TextButton(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkRed),
            ),
            modifier = Modifier
                .padding(top = 30.dp)
                .width(150.dp)
                .height(40.dp),
            onClick = { onVejIgenButtonClicked() }) {
            Text(text = stringResource(id = R.string.vejigen),
            fontWeight = FontWeight.Bold
            )

        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.DarkRed),
            ),
            modifier = Modifier
                .padding(top = 30.dp)
                .width(150.dp)
                .height(40.dp),
            onClick = {
            onVejIgenOgBetalButtonClicked()
            navigateToBetaling()
        }) {
            Text(text = stringResource(id = R.string.vejigenogbetal),
                fontWeight = FontWeight.Bold)

        }

        Text(text = stringResource(id = R.string.dinindvejning)+"\n"+weighInWeight+ stringResource(id = R.string.Kg),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline )

        Text(text = stringResource(id = R.string.dinvejning)+"\n"+middleWeight+stringResource(id = R.string.Kg),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline)

        Text(text = stringResource(id = R.string.Differens)+"\n"+weighToPay+stringResource(id = R.string.Kg),
            modifier= Modifier.padding(top = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.overline )

    }
}
