/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import id.myone.mysimplecomposable.presentation.viewmodel.auth.LoginViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    onPopNavigation: () -> Unit,
    onNavigateToForgotScreen: () -> Unit,
    onNavigateToRegisterScreen: () -> Unit,
    viewModel: LoginViewModel = getViewModel()
) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(true) }

    val loginState by viewModel.loginResult.observeAsState()

    LoginContent(
        state = loginState,
        email = email,
        password = password,
        onPopNavigation = onPopNavigation,
        onEmailFormValueChange = { email = it },
        onPasswordFormValueChange = { password = it },
        onChangePasswordVisibility = { showPassword = !showPassword }, showPassword = showPassword,
        onClickLoginButton = {
            viewModel.doUserLogin(mapOf("email" to email, "password" to password))
        },
        onNavigateToForgotScreen = onNavigateToForgotScreen,
        onNavigateToRegisterScreen = onNavigateToRegisterScreen
    )
}

