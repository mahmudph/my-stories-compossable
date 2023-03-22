/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.usecase.auth

import id.myone.mysimplecomposable.domain.repository.AuthRepositoryContract
import id.myone.mysimplecomposable.domain.utils.ResultData
import id.myone.mysimplecomposable.utils.AppStorage

class LoginUseCase constructor(
    private val appStorage: AppStorage,
    private val repositoryContract: AuthRepositoryContract
) {
    suspend operator fun invoke(payload: Map<String, Any>): ResultData<String> {
        val result = repositoryContract.login(payload)
        if (result is ResultData.Success) {
            /**
             * when login is success then we want to store data token in local storage
             */
            appStorage.storeUserToken( result.data!!)
        }

        return result
    }
}