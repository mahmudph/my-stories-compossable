/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.usecase.auth

import id.myone.mysimplecomposable.domain.entity.auth.UserEntity
import id.myone.mysimplecomposable.domain.repository.AuthRepositoryContract
import id.myone.mysimplecomposable.domain.utils.ResultData

class RegisterUseCase constructor(
    private val repositoryContract: AuthRepositoryContract
) {
    suspend operator fun invoke(payload: Map<String,Any>): ResultData<UserEntity> {
        return repositoryContract.register(payload)
    }
}