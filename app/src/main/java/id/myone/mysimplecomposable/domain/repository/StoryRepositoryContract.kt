/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.repository

import id.myone.mysimplecomposable.domain.entity.story.StoryEntity
import id.myone.mysimplecomposable.domain.utils.ResultData

interface StoryRepositoryContract {
    suspend fun getStories(): ResultData<List<StoryEntity>>
    suspend fun showStoryById(storyId: Int): ResultData<StoryEntity>
    suspend fun deleteStoryById(storyId: Int): ResultData<Boolean>
    suspend fun addNewStory(story: Map<String,Any>): ResultData<StoryEntity>
}