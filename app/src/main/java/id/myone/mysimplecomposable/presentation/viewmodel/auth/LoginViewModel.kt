/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.viewmodel.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.myone.mysimplecomposable.domain.usecase.auth.LoginUseCase
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.presentation.utils.ResultDataState
import kotlinx.coroutines.launch

class LoginViewModel constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private var _loginResult = MutableLiveData<ResultDataState<String>>()
    val loginResult = _loginResult


    fun doUserLogin(payload: Map<String, Any>) {
        viewModelScope.launch {

            _loginResult.postValue(ResultDataState.Loading())

            when (val result = loginUseCase(payload)) {
                is ResultData.Success -> {
                    _loginResult.postValue(ResultDataState.Success("login is successfully"))
                }

                is ResultData.Error -> {

                    if (result.errorFormField != null) {
                        _loginResult.postValue(
                            ResultDataState.FormValidationError(errorFormField = result.errorFormField)
                        )
                    } else {
                        _loginResult.postValue(
                            ResultDataState.Error(errorMessage = result.message!!)
                        )
                    }
                }
            }
        }
    }
}