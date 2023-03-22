/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.viewmodel.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.myone.mysimplecomposable.domain.entity.auth.UserEntity
import id.myone.mysimplecomposable.domain.usecase.auth.RegisterUseCase
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.presentation.utils.ResultDataState
import kotlinx.coroutines.launch

class RegisterViewModel constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private var _registerResult = MutableLiveData<ResultDataState<UserEntity>>()
    val registerResult = _registerResult

    fun doUserRegister(payload: Map<String, Any>) {
        viewModelScope.launch {
            _registerResult.postValue(ResultDataState.Loading())

            when (val result = registerUseCase(payload)) {
                is ResultData.Success -> {
                    _registerResult.postValue(ResultDataState.Success(result.data as UserEntity))
                }
                is ResultData.Error -> {
                    if (result.errorFormField != null) {
                        _registerResult.postValue(ResultDataState.FormValidationError(result.errorFormField))
                    } else {
                        _registerResult.postValue(ResultDataState.Error(result.message!!))
                    }
                }
            }
        }
    }
}