/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    btnName: String,
    onClick: () -> Unit,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        )
    ) {
        Text(
            btnName,
            style = MaterialTheme.typography.displayMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}


@Preview
@Composable
private fun ShowButtonComponent() {
    MySimpleComposableTheme {
        ButtonComponent(btnName = "Start", onClick = {})
    }
}