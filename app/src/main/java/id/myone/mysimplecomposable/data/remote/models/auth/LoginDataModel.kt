package id.myone.mysimplecomposable.data.remote.models.auth


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class LoginDataModel(
    @SerializedName("token")
    val token: String
)