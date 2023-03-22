/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import id.myone.mysimplecomposable.presentation.ui.widgets.*
import id.myone.mysimplecomposable.presentation.utils.ResultDataState


@Composable
fun LoginContent(
    state: ResultDataState<String>?,
    email: String,
    password: String,
    showPassword: Boolean = true,
    onPopNavigation: () -> Unit,
    onEmailFormValueChange: (String) -> Unit,
    onPasswordFormValueChange: (String) -> Unit,
    onClickLoginButton: () -> Unit,
    onChangePasswordVisibility: () -> Unit,
    onNavigateToForgotScreen: () -> Unit,
    onNavigateToRegisterScreen: () -> Unit,

    ) {

    val snackBarHostState = remember { SnackbarHostState() }

    var emailFormFieldError: List<String> = emptyList()
    var passwordFormFieldError: List<String> = emptyList()

    if (state is ResultDataState.FormValidationError) {
        val formFieldError = state.formValidationError
        emailFormFieldError = formFieldError!!["email"] ?: emptyList()
        passwordFormFieldError = formFieldError["password"] ?: emptyList()
    }

    if (state is ResultDataState.Error) {
        LaunchedEffect(snackBarHostState) {
            snackBarHostState.showSnackbar(state.message!!)
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AuthHeaderBackgroundComponent(
                    onBackPress = onPopNavigation,
                )
                AuthHeaderComponent(
                    title = R.string.login,
                    description = R.string.login_screen_desc,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(23.dp))
                FormFieldComponent(
                    value = email,
                    placeholder = stringResource(
                        id = R.string.email_placeholder_field
                    ),
                    onValueChanged = onEmailFormValueChange,
                    prefixIcon = Icons.Default.Email,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    errorMessage = emailFormFieldError
                )
                PasswordFormFieldComponent(
                    value = password,
                    onClickablePasswordVisibility = onChangePasswordVisibility,
                    placeholder = stringResource(
                        id = R.string.password_placeholder_filed
                    ),
                    onValueChanged = onPasswordFormValueChange,
                    shouldShowPassword = showPassword,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    errorMessage = passwordFormFieldError,
                )

                ButtonComponent(
                    btnName = stringResource(id = R.string.login),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    onClick = onClickLoginButton,
                )
                TextButton(
                    onClick = onNavigateToForgotScreen,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        stringResource(id = R.string.forgot_password_btn),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))

                LoginWithSocialAccountComponent(
                    onClickLoginWithGoogle = {},
                    onClickLoginWithApple = {},
                    onClickLoginWithFb = {},
                    OnClickLoginWithTwitter = {},
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
                Spacer(modifier = Modifier.height(20.dp))
                RichTextComponent(
                    text = buildAnnotatedString {
                        append(stringResource(id = R.string.do_not_have_account))
                        withStyle(
                            SpanStyle(color = Color(0xffBC8363))
                        ) {
                            append(" " + stringResource(id = R.string.create_account))
                        }
                    }, modifier = Modifier
                        .padding(bottom = 20.dp)
                        .padding(horizontal = 16.dp),
                    tag = stringResource(id = R.string.create_account),
                    onClick = onNavigateToRegisterScreen
                )
            }
            if (state is ResultDataState.Loading) LoadingIndicator()
        }
    }
}


@Preview
@Composable
private fun ShowLoginContent() {
    MySimpleComposableTheme {
        LoginContent(
            email = "joko@gmail.com",
            password = "",
            onPopNavigation = {},
            onClickLoginButton = {},
            onEmailFormValueChange = {},
            onPasswordFormValueChange = {},
            onChangePasswordVisibility = {},
            onNavigateToForgotScreen = {},
            onNavigateToRegisterScreen = {},
            state = ResultDataState.Loading()
        )
    }
}