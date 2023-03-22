/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import id.myone.mysimplecomposable.presentation.ui.screen.utils.BottomNavItem
import id.myone.mysimplecomposable.presentation.ui.screen.utils.dashboardBottomNavList
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

@Composable
fun BottomNavComponent(
    modifier: Modifier = Modifier,
    bottomNavList: List<BottomNavItem> = emptyList(),
    onNavigateTeRoute: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(modifier = modifier) {
        bottomNavList.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = {
                    selectedItem = index
                    onNavigateTeRoute(item.route)
                },
                icon = { Icon(imageVector = item.icon, contentDescription = null) },
                label = { Text(stringResource(id = item.label)) }
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xffff)
@Composable
private fun ShowBottomNavComponent() {
    MySimpleComposableTheme {
        BottomNavComponent(
            bottomNavList = dashboardBottomNavList,
            onNavigateTeRoute = {

            }
        )
    }
}