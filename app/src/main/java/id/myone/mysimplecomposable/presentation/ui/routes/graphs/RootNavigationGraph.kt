/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.routes.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.myone.mysimplecomposable.presentation.ui.screen.DashboardScreen


@Composable
fun RouteNavigationGraph() {
    val navigation = rememberNavController()

    NavHost(
        navController = navigation,
        startDestination = AuthRoute.SplashScreen.route,
        route = Graph.ROOT
    ) {
        authGraph(navigation)
        composable(route = Graph.DASHBOARD) {
            DashboardScreen()
        }
    }
}


object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val DASHBOARD = "dashboard_graph"
    const val DETAILS = "details_graph"
}