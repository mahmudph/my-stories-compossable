/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.viewmodel.story

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.myone.mysimplecomposable.domain.entity.story.StoryEntity
import id.myone.mysimplecomposable.domain.usecase.story.CreateStoryUseCase
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.presentation.utils.ResultDataState
import kotlinx.coroutines.launch

class CreateStoryViewModel(
    private val createStoryUseCase: CreateStoryUseCase
): ViewModel() {

    val _createStory = MutableLiveData<ResultDataState<StoryEntity>>()
    val createStory = _createStory

    fun createStory(story: Map<String,Any>) {
        viewModelScope.launch {
            _createStory.postValue(ResultDataState.Loading())

            when(val result = createStoryUseCase(story)) {
                is ResultData.Success -> {
                    _createStory.postValue(ResultDataState.Success(result.data!!))
                }
                is ResultData.Error -> {
                    if(result.errorFormField != null) {
                        _createStory.postValue(ResultDataState.FormValidationError(result.errorFormField))
                    } else {
                        _createStory.postValue(ResultDataState.Error(result.message!!))
                    }
                }
            }
        }
    }
}