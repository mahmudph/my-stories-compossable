/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.myone.mysimplecomposable.presentation.ui.routes.graphs.DashboardNavGraph
import id.myone.mysimplecomposable.presentation.ui.screen.utils.dashboardBottomNavList
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme
import id.myone.mysimplecomposable.presentation.ui.widgets.BottomNavComponent

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavComponent(
                bottomNavList = dashboardBottomNavList,
                onNavigateTeRoute = { navController.navigate(it) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            DashboardNavGraph(navController = navController)
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFF)
@Composable
private fun ShowDashboardScreen() {
    MySimpleComposableTheme {
        DashboardScreen()
    }
}

