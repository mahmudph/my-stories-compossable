/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.story.liststory

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import id.myone.mysimplecomposable.presentation.utils.ResultDataState


@Composable
fun StoryListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    StoryListContent(
        modifier = modifier,
        state = ResultDataState.Loading,
    )
}