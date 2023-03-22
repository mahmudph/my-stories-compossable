package id.myone.mysimplecomposable.domain.entity.story

import id.myone.mysimplecomposable.domain.entity.auth.UserEntity

data class StoryEntity(
    val id: Int,
    val title: String,
    val photo: String,
    val description: String,
    val user: UserEntity,
    val category: CategoryEntity,
    val createdAt: String,
)
