/**
 * Created by Mahmud on 11/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme


@Composable
fun AuthHeaderBackgroundComponent(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Image(painter = painterResource(id = R.drawable.image), contentDescription = null)
        IconButton(
            onClick = onBackPress,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xff8B8B8B),
            ),
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 16.dp)
                .clip(MaterialTheme.shapes.large)

        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ShowAuthHeaderBackgroundComponent() {
    MySimpleComposableTheme {
        AuthHeaderBackgroundComponent(
            onBackPress = {}
        )
    }
}