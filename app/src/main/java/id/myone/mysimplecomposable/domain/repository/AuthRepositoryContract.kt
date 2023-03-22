/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.repository

import id.myone.mysimplecomposable.domain.entity.auth.UserEntity
import id.myone.mysimplecomposable.domain.utils.ResultData

interface AuthRepositoryContract {
    suspend fun login(payload: Map<String,Any>): ResultData<String>
    suspend fun register(payload: Map<String,Any>) : ResultData<UserEntity>
    suspend fun forgotPassword(payload: Map<String,Any>) : ResultData<String>
    suspend fun getProfile(): ResultData<UserEntity>
}