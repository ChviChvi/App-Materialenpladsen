package com.example.materialepladsen.UIDesign

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.materialepladsen.R


@Composable
fun ReadyScreen(
                onVejIgenButtonClicked: () -> Unit = {},
                onVejIgenOgBetalButtonClicked: () -> Unit = {},
                weighInWeight:Float,
                middleWeight:Float,
                weighToPay: Float
){



    Column() {
        Text(text = stringResource(id = R.string.Readytopickmaterials))

        TextButton(onClick = { onVejIgenButtonClicked() }) {
            Text(text = stringResource(id = R.string.vejigen))

        }

        TextButton(onClick = { onVejIgenOgBetalButtonClicked() }) {
            Text(text = stringResource(id = R.string.vejigenogbetal))

        }

        Text(text = stringResource(id = R.string.dinindvejning)+weighInWeight+ stringResource(id = R.string.Kg) )
        Text(text = stringResource(id = R.string.dinvejning)+middleWeight+stringResource(id = R.string.Kg))
        Text(text = stringResource(id = R.string.Differens)+weighToPay+stringResource(id = R.string.Kg) )

    }
}
