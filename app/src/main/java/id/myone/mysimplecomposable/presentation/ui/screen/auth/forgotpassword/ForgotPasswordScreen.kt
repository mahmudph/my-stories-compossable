/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth.forgotpassword


import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import id.myone.mysimplecomposable.presentation.viewmodel.auth.ForgotPasswordViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ForgotPasswordScreenView(
    onNavigatePop: () -> Unit,
    viewModel: ForgotPasswordViewModel = getViewModel()
) {
    var email by remember { mutableStateOf("") }
    val forgotPasswordState by viewModel.forgotPasswordRes.observeAsState()

    ForgotPasswordContent(
        state = forgotPasswordState,
        email = email,
        onEmailFormFieldValueChange = { email = it },
        onNavigatePop = onNavigatePop,
        onClickForgotPassword = {
            viewModel.doForgotPassword(mapOf("email" to email))
        }
    )
}

