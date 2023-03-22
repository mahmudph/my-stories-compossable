package id.myone.mysimplecomposable.domain.utils

//sealed class ResultData{
//    data class Success<T>(val data: T) : ResultData()
//    data class Error(
//        val errorFormField: Map<String, List<String>>? = null,
//        val errorMessage: String? = null
//    ) : ResultData()
//}


sealed class ResultData<T>(
    val data: T? = null,
    val message: String? = null,
    val errorFormField: Map<String, List<String>>? = null
) {
    class Success<T>(data: T) : ResultData<T>(data)
    class Error<T>(
        errorFormField: Map<String, List<String>>? = null,
        errorMessage: String? = null
    ) : ResultData<T>(
        message = errorMessage,
        errorFormField = errorFormField,
    )
}
