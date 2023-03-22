/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth.register

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import id.myone.mysimplecomposable.presentation.viewmodel.auth.RegisterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterScreen(
    onNavigatePop: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    viewModel: RegisterViewModel = getViewModel()
) {

    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }

    val registerState by viewModel.registerResult.observeAsState()

    RegisterContent(
        state = registerState,
        email = email,
        password = password,
        mobileNumber = mobileNumber,
        passwordVisibility = showPassword,
        onNavigatePop = onNavigatePop,
        onEmailFormFieldChange = { email = it },
        onMobileNumberFormFieldChange = { mobileNumber = it },
        onPasswordFormFieldChange = { password = it },
        onChangePasswordVisibility = { showPassword = !showPassword },
        onNavigateToLoginScreen = onNavigateToLoginScreen,
        onCreateAccount = {
            viewModel.doUserRegister(
                mapOf("email" to email, "mobileNumber" to mobileNumber, "password" to password)
            )
        }
    )
}


