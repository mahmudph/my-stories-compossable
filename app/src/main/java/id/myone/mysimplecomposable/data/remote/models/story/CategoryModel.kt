package id.myone.mysimplecomposable.data.remote.models.story


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CategoryModel(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)