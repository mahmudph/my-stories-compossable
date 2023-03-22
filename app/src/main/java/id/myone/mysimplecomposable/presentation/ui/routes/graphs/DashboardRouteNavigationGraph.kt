/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.routes.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.myone.mysimplecomposable.presentation.ui.screen.favorite.FavoriteScreen
import id.myone.mysimplecomposable.presentation.ui.screen.settings.SettingsScreen
import id.myone.mysimplecomposable.presentation.ui.screen.story.liststory.StoryListScreen
import id.myone.mysimplecomposable.presentation.ui.screen.utils.BottomNavItem

@Composable
fun DashboardNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        route = Graph.DASHBOARD
    ) {

        composable(route = BottomNavItem.Home.route) {
            StoryListScreen(navController = navController)
        }

        composable(route = BottomNavItem.Favorite.route) {
            FavoriteScreen(navController = navController)
        }

        composable( route = BottomNavItem.Setting.route) {
            SettingsScreen()
        }
    }
}