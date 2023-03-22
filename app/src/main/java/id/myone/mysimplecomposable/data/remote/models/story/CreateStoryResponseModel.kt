package id.myone.mysimplecomposable.data.remote.models.story


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CreateStoryResponseModel(
    @SerializedName("error")
    val error: Map<String,List<String>>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("data")
    val data: StoryModel
)