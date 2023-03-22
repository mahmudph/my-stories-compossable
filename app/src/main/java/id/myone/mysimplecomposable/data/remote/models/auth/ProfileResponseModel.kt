package id.myone.mysimplecomposable.data.remote.models.auth


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProfileResponseModel(
    @SerializedName("data")
    val `data`: UserModel,
    @SerializedName("error")
    val error: Map<String,List<String>>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String,
    @SerializedName("timestamp")
    val timestamp: String
)