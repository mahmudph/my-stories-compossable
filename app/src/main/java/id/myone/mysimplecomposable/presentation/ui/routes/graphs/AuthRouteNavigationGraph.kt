/**
 * Created by Mahmud on 10/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.routes.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.myone.mysimplecomposable.presentation.ui.screen.auth.SplashScreen
import id.myone.mysimplecomposable.presentation.ui.screen.auth.forgotpassword.ForgotPasswordScreenView
import id.myone.mysimplecomposable.presentation.ui.screen.auth.login.LoginScreen
import id.myone.mysimplecomposable.presentation.ui.screen.auth.register.RegisterScreen


fun NavGraphBuilder.authGraph(navController: NavController) {

    navigation(
        startDestination = AuthRoute.LoginScreen.route,
        route = Graph.AUTHENTICATION
    ) {

        composable(route = AuthRoute.SplashScreen.route) {
            SplashScreen(onNavigateToRoute = {
                navController.navigate(it)
            })
        }

        composable(route = AuthRoute.LoginScreen.route) {
            LoginScreen(
                onNavigateToRegisterScreen = { navController.navigate(AuthRoute.RegisterScreen.route) },
                onNavigateToForgotScreen = { navController.navigate(AuthRoute.ForgotPasswordScreen.route) },
                onPopNavigation = { navController.popBackStack() }
            )
        }

        composable(route = AuthRoute.RegisterScreen.route) {
            RegisterScreen(
                onNavigatePop = { navController.popBackStack() },
                onNavigateToLoginScreen = {
                    navController.popBackStack()
                    navController.navigate(AuthRoute.LoginScreen.route)
                }
            )
        }

        composable(route = AuthRoute.ForgotPasswordScreen.route) {
            ForgotPasswordScreenView(
                onNavigatePop = { navController.popBackStack() }
            )
        }
    }
}


sealed class AuthRoute(val route: String) {
    object SplashScreen : AuthRoute(route = "boarding")
    object LoginScreen : AuthRoute(route = "login")
    object RegisterScreen : AuthRoute(route = "register")
    object ForgotPasswordScreen : AuthRoute(route = "forgot_password")
}
