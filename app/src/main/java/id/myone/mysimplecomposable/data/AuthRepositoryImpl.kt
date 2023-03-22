/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data

import id.myone.mysimplecomposable.commons.FormValidationException
import id.myone.mysimplecomposable.data.remote.RemoteAuthDataSourceContract
import id.myone.mysimplecomposable.domain.repository.AuthRepositoryContract
import id.myone.mysimplecomposable.domain.entity.auth.UserEntity
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.utils.DataMapper

class AuthRepositoryImpl constructor(
    private val remoteDataSource: RemoteAuthDataSourceContract
) : AuthRepositoryContract {

    override suspend fun login(payload: Map<String, Any>): ResultData<String> {
        return try {
            val result = remoteDataSource.doUserLogin(payload)
            ResultData.Success(result.data.token)

        } catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    override suspend fun register(payload: Map<String, Any>): ResultData<UserEntity> {
        return try {
            val result = remoteDataSource.doUserRegister(payload)
            val userEntity = DataMapper.mapUserModelToUserEntity(result.data)
            ResultData.Success(userEntity)

        } catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    override suspend fun forgotPassword(payload: Map<String, Any>): ResultData<String> {
        return try {
            remoteDataSource.doUserResetPassword(payload)
            ResultData.Success("Success to forgot password")

        } catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    override suspend fun getProfile(): ResultData<UserEntity> {
        return try {
            val result = remoteDataSource.doUserProfile()
            val userEntity = DataMapper.mapUserModelToUserEntity(result.data)
            ResultData.Success(userEntity)

        } catch (e: FormValidationException) {
            ResultData.Error(errorFormField = e.errors)
        } catch (e: Exception) {
            ResultData.Error(errorMessage = e.message ?: ERROR_MESSAGE)
        }
    }

    companion object {
        const val ERROR_MESSAGE = "process failure, please try again"
    }

}