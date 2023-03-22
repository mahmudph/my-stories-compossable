/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.domain.usecase.auth

import id.myone.mysimplecomposable.domain.repository.AuthRepositoryContract
import id.myone.mysimplecomposable.domain.utils.ResultData

class ForgotPasswordUseCase constructor(
    private val repositoryContract: AuthRepositoryContract
) {
    suspend operator fun invoke(payload: Map<String, Any>): ResultData<String> {
        return repositoryContract.forgotPassword(payload)
    }
}