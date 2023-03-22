/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data

import id.myone.mysimplecomposable.commons.FormValidationException
import id.myone.mysimplecomposable.data.remote.RemoteStoryDataSourceContract
import id.myone.mysimplecomposable.domain.repository.StoryRepositoryContract
import id.myone.mysimplecomposable.domain.entity.story.StoryEntity
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.utils.DataMapper

class StoryRepositoryImpl constructor(
    private val remoteDataSource: RemoteStoryDataSourceContract,
): StoryRepositoryContract {
    override suspend fun getStories(): ResultData<List<StoryEntity>> {
        return try {
            val result = remoteDataSource.doGetStoryList()
            val storyListEntity = result.data.map { DataMapper.mapStoryModelToStoryEntity(it) }
            return ResultData.Success(storyListEntity)

        } catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    override suspend fun showStoryById(storyId: Int): ResultData<StoryEntity> {
        return try {
            val result = remoteDataSource.doGetStoryDetailById(storyId)
            val storyEntity = DataMapper.mapStoryModelToStoryEntity(result.data)
            return ResultData.Success(storyEntity)

        }  catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    override suspend fun deleteStoryById(storyId: Int): ResultData<Boolean> {
        return try {
            remoteDataSource.doDeleteStoryById(storyId)
            return ResultData.Success(true)

        }  catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    override suspend fun addNewStory(story: Map<String,Any>): ResultData<StoryEntity> {
        return try {
            val result = remoteDataSource.doCreateNewStory(story)
            val storyEntity = DataMapper.mapStoryModelToStoryEntity(result.data)
            return ResultData.Success(storyEntity)

        }  catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    companion object {
        const val ERROR_MESSAGE = "process failure, please try again"
    }
}