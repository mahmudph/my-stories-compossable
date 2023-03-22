/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 2.dp,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(
                Color.Black.copy(alpha = 0.2f)
            ),
    ) {
        Surface(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(12.dp),
                    ambientColor = Color.White,
                    spotColor = Color.Blue
                )
        ) {
            CircularProgressIndicator(
                modifier = Modifier.padding(8.dp),
                color = color,
                progress = 0.8f,
                strokeWidth = strokeWidth
            )
        }
    }

}


@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun ShowLoadingIndicator() {
    MySimpleComposableTheme {
        LoadingIndicator()
    }
}