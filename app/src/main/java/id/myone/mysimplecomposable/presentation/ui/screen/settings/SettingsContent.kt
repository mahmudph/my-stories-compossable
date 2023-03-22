/**
 * Created by Mahmud on 21/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.settings


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@Composable
fun SettingsContent(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFF)
@Composable
private fun ShowSettingsContent() {
    MySimpleComposableTheme {
        SettingsContent()
    }
}