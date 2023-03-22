package id.myone.mysimplecomposable.utils

import id.myone.mysimplecomposable.data.remote.models.auth.UserModel
import id.myone.mysimplecomposable.data.remote.models.story.CategoryModel
import id.myone.mysimplecomposable.data.remote.models.story.StoryModel
import id.myone.mysimplecomposable.domain.entity.auth.UserEntity
import id.myone.mysimplecomposable.domain.entity.story.CategoryEntity
import id.myone.mysimplecomposable.domain.entity.story.StoryEntity

object DataMapper {

    fun mapUserModelToUserEntity(userModel: UserModel): UserEntity {
        return UserEntity(
            name = userModel.name,
            id = userModel.id,
            createdAt = userModel.createdAt,
            email = userModel.email
        )
    }

    private fun mapCategoryModelToCategoryEntity(categoryModel: CategoryModel): CategoryEntity {
        return CategoryEntity(
            id = categoryModel.id,
            name = categoryModel.name,
            createdAt = categoryModel.createdAt,
        )
    }

    fun mapStoryModelToStoryEntity(storyModel: StoryModel): StoryEntity {
        return StoryEntity(
            id = storyModel.id,
            title = storyModel.title,
            description = storyModel.description,
            photo = storyModel.photo,
            user = mapUserModelToUserEntity(storyModel.userModel),
            category = mapCategoryModelToCategoryEntity(storyModel.category),
            createdAt = storyModel.createdAt
        )
    }
}