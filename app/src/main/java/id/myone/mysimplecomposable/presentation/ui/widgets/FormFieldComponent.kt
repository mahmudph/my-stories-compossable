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
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    iconColor: Color = Color(0xffCCCCCC),
    prefixIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Email,
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChanged: (String) -> Unit,
    errorMessage: List<String> = emptyList(),
) {

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
            leadingIcon = if (prefixIcon != null) {
                { Icon(prefixIcon, contentDescription = null, tint = iconColor) }
            } else null,
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                autoCorrect = false,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.None,
            ),
            shape = MaterialTheme.shapes.medium
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
private fun ShowFormFieldComponent() {
    MySimpleComposableTheme {
        FormFieldComponent(
            value = "",
            errorMessage = listOf("name is invalid", "email is already exist"),
            keyboardType = KeyboardType.Text,
            placeholder = "Enter Your Name",
            onValueChanged = {

            }
        )
    }
}