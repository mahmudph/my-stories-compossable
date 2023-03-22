/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth.register

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.domain.entity.auth.UserEntity
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import id.myone.mysimplecomposable.presentation.ui.widgets.*
import id.myone.mysimplecomposable.presentation.utils.ResultDataState

@Composable
fun RegisterContent(
    state: ResultDataState<UserEntity>?,
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    mobileNumber: String,
    passwordVisibility: Boolean = true,
    onNavigatePop: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    onEmailFormFieldChange: (String) -> Unit,
    onMobileNumberFormFieldChange: (String) -> Unit,
    onPasswordFormFieldChange: (String) -> Unit,
    onChangePasswordVisibility: () -> Unit,
    onCreateAccount: () -> Unit,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AuthHeaderBackgroundComponent(
                    onBackPress = onNavigatePop,
                )
                AuthHeaderComponent(
                    title = R.string.create_account,
                    description = R.string.register_screen_desc,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(23.dp))
                FormFieldComponent(
                    value = email,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    placeholder = stringResource(id = R.string.email_placeholder_field),
                    onValueChanged = onEmailFormFieldChange,
                    prefixIcon = Icons.Default.Email
                )
                FormFieldComponent(
                    value = mobileNumber,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    placeholder = stringResource(id = R.string.mobile_number_placeholder_filed),
                    onValueChanged = onMobileNumberFormFieldChange,
                    prefixIcon = Icons.Default.Phone
                )
                PasswordFormFieldComponent(
                    value = password,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    placeholder = stringResource(id = R.string.password_placeholder_filed),
                    onValueChanged = onPasswordFormFieldChange,
                    shouldShowPassword = passwordVisibility,
                    onClickablePasswordVisibility = onChangePasswordVisibility
                )
                ButtonComponent(
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    btnName = stringResource(id = R.string.create_account),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    onClick = onCreateAccount,
                )

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
                        append(stringResource(id = R.string.alrady_have_an_account))
                        withStyle(
                            SpanStyle(color = Color(0xffBC8363))
                        ) {
                            append(" " + stringResource(id = R.string.login_now))
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .padding(horizontal = 16.dp),
                    tag = stringResource(id = R.string.login_now),
                    onClick = onNavigateToLoginScreen
                )
            }
            if (state is ResultDataState.Loading) LoadingIndicator()
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFF)
@Composable
private fun ShowRegisterScreen() {
    MySimpleComposableTheme {
        RegisterContent(
            state = ResultDataState.Loading(),
            email = "",
            password = "",
            mobileNumber = "",
            passwordVisibility = true,
            onNavigatePop = {},
            onChangePasswordVisibility = {},
            onEmailFormFieldChange = {},
            onMobileNumberFormFieldChange = {},
            onPasswordFormFieldChange = {},
            onCreateAccount = {},
            onNavigateToLoginScreen = {}
        )
    }
}