/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.viewmodel.story

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import id.myone.mysimplecomposable.domain.entity.story.StoryEntity
import id.myone.mysimplecomposable.domain.usecase.story.DeleteStoryUseCase
import id.myone.mysimplecomposable.domain.usecase.story.GetListStoryUseCase
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.presentation.utils.ResultDataState
import kotlinx.coroutines.launch

class ListStoryViewModel(
    private val getListStoryUseCase: GetListStoryUseCase,
    private val deleteStoryUseCase: DeleteStoryUseCase
) : ViewModel() {

    val _listStoryEntity = MutableLiveData<ResultDataState<List<StoryEntity>>>()
    val listStoryEnity = _listStoryEntity

    fun loadListStoryData() {

        viewModelScope.launch {

            _listStoryEntity.postValue(ResultDataState.Loading())

            when (val result = getListStoryUseCase()) {
                is ResultData.Success -> {
                    _listStoryEntity.postValue(ResultDataState.Success(result.data!!))
                }
                is ResultData.Error -> {
                    if (result.message != null) {
                        _listStoryEntity.postValue(ResultDataState.Error(result.message))
                    } else {
                        _listStoryEntity.postValue(ResultDataState.FormValidationError(result.errorFormField!!))
                    }
                }
            }
        }
    }

    fun deleteStory(storyId: Int) = liveData<ResultDataState<String>> {
        viewModelScope.launch {

            emit(ResultDataState.Loading())

            when (val result = deleteStoryUseCase(storyId)) {
                is ResultData.Error -> emit(ResultDataState.Error(result.message!!))
                is ResultData.Success -> {

                    _listStoryEntity.value?.data?.let { storyList ->
                        val listStory = storyList.filter { it.id != storyId }
                        _listStoryEntity.postValue(ResultDataState.Success(listStory))

                        emit(ResultDataState.Success("Success to delete story data"))
                    }
                }
            }
        }
    }
}