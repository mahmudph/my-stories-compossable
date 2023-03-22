/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.usecase.story

import id.myone.mysimplecomposable.domain.entity.story.StoryEntity
import id.myone.mysimplecomposable.domain.repository.StoryRepositoryContract
import id.myone.mysimplecomposable.domain.utils.ResultData

class GetListStoryUseCase(
    private val storyRepositoryContract: StoryRepositoryContract
) {
    suspend operator fun invoke(): ResultData<List<StoryEntity>>  {
        return storyRepositoryContract.getStories()
    }
}