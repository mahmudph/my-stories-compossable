/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFormFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    iconColor: Color = Color(0xff8B8B8B),
    prefixIcon: ImageVector = Icons.Default.Lock,
    shouldShowPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Email,
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChanged: (String) -> Unit,
    onClickablePasswordVisibility: () -> Unit,
    errorMessage: List<String> = emptyList(),

) {

    val passwordVisibilityIcon = if (shouldShowPassword) {
        R.drawable.ic_baseline_visibility_off_24
    } else R.drawable.ic_baseline_visibility_24

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            maxLines = 1,
            singleLine = true,
            placeholder = {
                Text(placeholder, style = MaterialTheme.typography.labelMedium)
            },

            colors = TextFieldDefaults.textFieldColors(
                errorIndicatorColor = MaterialTheme.colorScheme.error,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            ),
            leadingIcon = {
                Icon(
                    prefixIcon,
                    contentDescription = null,
                    tint = Color(0xffCCCCCC)
                )
            },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                autoCorrect = false,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.None,
            ),
            shape = MaterialTheme.shapes.medium,
            trailingIcon = {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.padding(1.dp),
                    onClick = onClickablePasswordVisibility
                ) {
                    Icon(
                        painter = painterResource(id = passwordVisibilityIcon),
                        contentDescription = null,
                        tint = iconColor
                    )
                }
            }
        )

        if (errorMessage.isNotEmpty()) Column {
            for (item in errorMessage) {
                Text(
                    item.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.error
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ShowPasswordFormFieldComponent() {
    MySimpleComposableTheme {
        PasswordFormFieldComponent(
            value = "",
            keyboardType = KeyboardType.Text,
            placeholder = "Enter Your password",
            onValueChanged = {

            },
            onClickablePasswordVisibility = {

            }
        )
    }
}