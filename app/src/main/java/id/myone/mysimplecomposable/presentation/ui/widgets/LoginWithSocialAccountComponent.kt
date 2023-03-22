/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@Composable
fun LoginWithSocialAccountComponent(
    modifier: Modifier = Modifier,
    onClickLoginWithGoogle: () -> Unit,
    onClickLoginWithFb: () -> Unit,
    onClickLoginWithApple: () -> Unit,
    OnClickLoginWithTwitter: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.social_media_login_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Normal,
            ),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            SocialMediaBtnLoginComponent(
                painter = R.drawable.google_icon,
                onclick = onClickLoginWithGoogle,
            )
            SocialMediaBtnLoginComponent(
                painter = R.drawable.facebook_icon,
                onclick = onClickLoginWithFb
            )
            SocialMediaBtnLoginComponent(
                painter = R.drawable.apple_icon,
                onclick = onClickLoginWithApple
            )
            SocialMediaBtnLoginComponent(
                painter = R.drawable.twitter_icon,
                onclick = OnClickLoginWithTwitter,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ShowLoginWithSocialAccountComponent() {
    MySimpleComposableTheme {
        LoginWithSocialAccountComponent(
            onClickLoginWithGoogle = {},
            onClickLoginWithApple = {},
            onClickLoginWithFb = {},
            OnClickLoginWithTwitter = {},
        )
    }
}