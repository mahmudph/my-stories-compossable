/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.myone.mysimplecomposable.R
import id.myone.mysimplecomposable.presentation.ui.routes.graphs.AuthRoute
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToRoute: (String) -> Unit
) {
    /**
     * delay for 3 seconds for illustrate progress loading
     * then navigate to the login screen
     */
    LaunchedEffect(true) {
        delay(3000)
        onNavigateToRoute(AuthRoute.LoginScreen.route)
    }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowSplashScreen() {
    MySimpleComposableTheme {
        SplashScreen(onNavigateToRoute = {

        })
    }
}