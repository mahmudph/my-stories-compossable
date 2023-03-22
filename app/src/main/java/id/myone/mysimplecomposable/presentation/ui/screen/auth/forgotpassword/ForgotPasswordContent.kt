/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth.forgotpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import id.myone.mysimplecomposable.presentation.ui.widgets.ButtonComponent
import id.myone.mysimplecomposable.presentation.ui.widgets.FormFieldComponent
import id.myone.mysimplecomposable.presentation.ui.widgets.HeaderTopBarComponent
import id.myone.mysimplecomposable.presentation.ui.widgets.LoadingIndicator
import id.myone.mysimplecomposable.presentation.utils.ResultDataState

@Composable
fun ForgotPasswordContent(
    state: ResultDataState<String>?,
    modifier: Modifier = Modifier,
    onNavigatePop: () -> Unit,
    onClickForgotPassword: () -> Unit,
    email: String,
    onEmailFormFieldValueChange: (String) -> Unit,
) {

    Scaffold(
        topBar = {
            HeaderTopBarComponent(
                onNavigatePop = onNavigatePop,
            )
        }
    ) { paddingValues ->
        Box(
            modifier = modifier.padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                FormFieldComponent(
                    value = email,
                    placeholder = stringResource(id = R.string.email_placeholder_field),
                    onValueChanged = onEmailFormFieldValueChange
                )
                ButtonComponent(
                    btnName = stringResource(id = R.string.login),
                    onClick = onClickForgotPassword
                )
            }
        }
        if(state is ResultDataState.Loading) LoadingIndicator()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFF)
@Composable
private fun ShowForgotPasswordContent() {
    MySimpleComposableTheme {
        ForgotPasswordContent(
            state = ResultDataState.Loading(),
            email = "",
            onNavigatePop = {},
            onClickForgotPassword = {},
            onEmailFormFieldValueChange = {}
        )
    }
}