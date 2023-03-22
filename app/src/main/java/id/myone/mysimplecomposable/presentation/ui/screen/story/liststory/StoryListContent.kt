/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.ui.screen.story.liststory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.myone.mysimplecomposable.presentation.ui.widgets.LoadingIndicator
import id.myone.mysimplecomposable.presentation.utils.ResultDataState

@Composable
fun StoryListContent(
    modifier: Modifier = Modifier,
    state: ResultDataState?,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        }

        if (state is ResultDataState.Loading) LoadingIndicator()
    }

}


@Preview(showBackground = true, backgroundColor = 0xffff)
@Composable
fun ShowStoryListContent() {
    StoryListContent(
        state = ResultDataState.Loading,
    )
}