package id.myone.mysimplecomposable.presentation.ui.screen.utils

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import id.myone.mysimplecomposable.R

sealed class BottomNavItem(
    @StringRes val label: Int,
    val route: String,
    val icon: ImageVector
) {
    object Home: BottomNavItem(
        label = R.string.home,
        route = "home",
        icon = Icons.Default.Home,
    )

    object Favorite: BottomNavItem(
        label = R.string.favorite,
        route = "favorite",
        icon = Icons.Default.Favorite,
    )
    object Setting: BottomNavItem(
        label = R.string.settings,
        route = "settings",
        icon = Icons.Default.Settings,
    )
}


val dashboardBottomNavList = listOf(
    BottomNavItem.Home,
    BottomNavItem.Favorite,
    BottomNavItem.Setting
)