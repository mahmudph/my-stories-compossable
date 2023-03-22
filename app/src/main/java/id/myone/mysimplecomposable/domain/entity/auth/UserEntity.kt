/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.entity.auth

data class UserEntity(
    val createdAt: String,
    val email: String,
    val id: Int,
    val name: String,
)