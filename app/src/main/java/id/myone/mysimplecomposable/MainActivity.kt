package id.myone.mysimplecomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.myone.mysimplecomposable.presentation.ui.routes.graphs.RouteNavigationGraph
import id.myone.mysimplecomposable.presentation.ui.theme.MySimpleComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySimpleComposableTheme {
                RouteNavigationGraph()
            }
        }
    }
}
