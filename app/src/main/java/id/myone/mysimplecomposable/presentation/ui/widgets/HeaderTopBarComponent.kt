/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */


package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderTopBarComponent(
    modifier: Modifier = Modifier,
    onNavigatePop: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = stringResource(R.string.forgot_password),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigatePop) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFFF)
@Composable
private fun ShowHeaderTopBarComponent() {
    MySimpleComposableTheme {
        HeaderTopBarComponent(
            onNavigatePop = {}
        )
    }
}
