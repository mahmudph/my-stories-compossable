/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data.remote

import id.myone.mysimplecomposable.data.remote.models.auth.*
import id.myone.mysimplecomposable.data.remote.network.ApiService


interface RemoteAuthDataSourceContract {
    suspend fun doUserProfile(): ProfileResponseModel
    suspend fun doUserLogin(payload: Map<String, Any>): LoginResponseModel
    suspend fun doUserRegister(payload: Map<String, Any>): RegisterResponseModel
    suspend fun doUserResetPassword(payload: Map<String, Any>): LoginResponseModel
}


class RemoteAuthDataSource constructor(
    private val apiService: ApiService
) : RemoteAuthDataSourceContract {

    override suspend fun doUserLogin(payload: Map<String, Any>): LoginResponseModel {
        val response = apiService.authLogin(payload)
        return response.body()!!
    }

    override suspend fun doUserRegister(payload: Map<String, Any>): RegisterResponseModel {
        val response = apiService.authRegister(payload)
        return response.body()!!
    }

    override suspend fun doUserProfile(): ProfileResponseModel {
        val response = apiService.authUserProfile()
        return response.body()!!
    }

    override suspend fun doUserResetPassword(payload: Map<String, Any>): LoginResponseModel {
        val response = apiService.authForgotPassword(payload)
        return response.body()!!
    }
}