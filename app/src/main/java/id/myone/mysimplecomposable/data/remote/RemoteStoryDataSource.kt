/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data.remote

import id.myone.mysimplecomposable.data.remote.models.story.CreateStoryResponseModel
import id.myone.mysimplecomposable.data.remote.models.story.DeleteStoryResponseModel
import id.myone.mysimplecomposable.data.remote.models.story.DetailStoryResponseModel
import id.myone.mysimplecomposable.data.remote.models.story.ListStoryResponseModel
import id.myone.mysimplecomposable.data.remote.network.ApiService

interface RemoteStoryDataSourceContract {
    suspend fun doGetStoryList(): ListStoryResponseModel
    suspend fun doGetStoryDetailById(storyId: Int): DetailStoryResponseModel
    suspend fun doCreateNewStory(story: Map<String,Any>): CreateStoryResponseModel
    suspend fun doDeleteStoryById(storyId: Int): DeleteStoryResponseModel
}

class RemoteStoryDataSource constructor(
    private val apiService: ApiService,
): RemoteStoryDataSourceContract {
    override suspend fun doGetStoryList(): ListStoryResponseModel {
        val response = apiService.getStoriesListData()
        return response.body()!!
    }

    override suspend fun doGetStoryDetailById(storyId: Int): DetailStoryResponseModel {
        val response = apiService.getStoryDetail(storyId)
        return response.body()!!
    }

    override suspend fun doCreateNewStory(story: Map<String,Any>): CreateStoryResponseModel {
        val response = apiService.createNewStory(story)
        return response.body()!!
    }

    override suspend fun doDeleteStoryById(storyId: Int): DeleteStoryResponseModel {
        val response = apiService.deleteStory(storyId)
        return response.body()!!
    }
}