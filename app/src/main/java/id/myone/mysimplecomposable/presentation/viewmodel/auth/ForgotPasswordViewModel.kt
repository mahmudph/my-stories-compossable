/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.viewmodel.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.myone.mysimplecomposable.domain.usecase.auth.ForgotPasswordUseCase
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.presentation.utils.ResultDataState
import kotlinx.coroutines.launch

class ForgotPasswordViewModel constructor(
    private val forgotPasswordUseCase: ForgotPasswordUseCase
) : ViewModel() {

    private val _forgotPasswordRes = MutableLiveData<ResultDataState<String>>()
    val forgotPasswordRes = _forgotPasswordRes

    fun doForgotPassword(payload: Map<String, Any>) {
        viewModelScope.launch {
            _forgotPasswordRes.postValue(ResultDataState.Loading())

            when (val result = forgotPasswordUseCase(payload)) {
                is ResultData.Success -> {
                    _forgotPasswordRes.postValue(ResultDataState.Success("Forgot password success"))
                }
                is ResultData.Error -> {
                    if (result.errorFormField != null) {
                        _forgotPasswordRes.postValue(ResultDataState.FormValidationError(result.errorFormField))
                    } else {
                        _forgotPasswordRes.postValue(ResultDataState.Error(result.message!!))
                    }
                }
            }
        }
    }
}