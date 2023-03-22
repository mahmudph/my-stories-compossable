/**
 * Created by Mahmud on 11/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme


@Composable
fun AuthHeaderComponent(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes description: Int,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
       Text(
           text = stringResource(id = title),
           textAlign = TextAlign.Left,
           style = MaterialTheme.typography.headlineMedium,
       )
        Spacer(modifier = Modifier.height(23.dp))
        Text(
            text = stringResource(id = description),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color(0xff8B8B8B)
            ),
        )
        
    }
}


@Preview(showBackground = true)
@Composable
private fun ShowAuthHeaderComponent() {
    MySimpleComposableTheme {
        AuthHeaderComponent(
            title = R.string.login,
            description = R.string.login_screen_desc,
        )
    }
}