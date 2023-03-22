/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialMediaBtnLoginComponent(
    modifier: Modifier = Modifier,
    @DrawableRes painter: Int,
    onclick: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .height(65.dp)
            .width(65.dp)
            .shadow(
                elevation = 16.dp,
                ambientColor = Color(0xff000000),
                spotColor =  Color(0xff000000),
                shape = MaterialTheme.shapes.medium
            ),
        onClick = onclick,
        shape = MaterialTheme.shapes.small,
        shadowElevation = 10.dp,
    ) {
        Icon(
            painter = painterResource(id = painter),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
            tint = Color.Unspecified,
        )
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
private fun ShowSocialMediaBtnLoginComponent() {
    MySimpleComposableTheme {
        SocialMediaBtnLoginComponent(
            painter = R.drawable.google_icon,
            onclick = {

            }
        )
    }
}