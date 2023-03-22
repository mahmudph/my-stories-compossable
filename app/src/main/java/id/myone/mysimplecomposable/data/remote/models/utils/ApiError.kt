package id.myone.mysimplecomposable.data.remote.models.utils

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ApiError(
    @SerializedName("data")
    val data: Any,
    @SerializedName("error")
    val error: Map<String,List<String>>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String,
    @SerializedName("ApiError")
    val timestamp: String
)