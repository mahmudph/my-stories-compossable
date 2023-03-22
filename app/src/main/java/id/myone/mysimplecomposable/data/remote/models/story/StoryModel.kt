package id.myone.mysimplecomposable.data.remote.models.story

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import id.myone.mysimplecomposable.data.remote.models.auth.UserModel

@Keep
data class StoryModel(
    @SerializedName("category")
    val category: CategoryModel,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user")
    val userModel: UserModel,
    @SerializedName("user_id")
    val userId: Int
)