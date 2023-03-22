/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.presentation.utils

sealed class ResultDataState<T>(
    val data: T? = null,
    val message: String? = null,
    val formValidationError: Map<String, List<String>>? = null
) {
    class Loading<T> : ResultDataState<T>()
    class Success<T>(data: T) : ResultDataState<T>(data)
    class Error<T>(errorMessage: String) : ResultDataState<T>(message = errorMessage)
    class FormValidationError<T>(errorFormField: Map<String, List<String>>) : ResultDataState<T>(
        formValidationError = errorFormField,
    )
}