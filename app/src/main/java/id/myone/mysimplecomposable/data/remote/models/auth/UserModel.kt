package id.myone.mysimplecomposable.data.remote.models.auth


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UserModel(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)