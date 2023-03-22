/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data.remote.interceptor

import com.google.gson.Gson
import id.myone.mysimplecomposable.commons.FormValidationException
import id.myone.mysimplecomposable.commons.ServerException
import id.myone.mysimplecomposable.data.remote.models.utils.ApiError
import okhttp3.Interceptor
import okhttp3.Response

class ValidateResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (!response.isSuccessful) {

            if (response.code() == 400) {
                val bodyStringData = response.body()?.charStream()
                val responseBody = Gson().fromJson(bodyStringData, ApiError::class.java)

                throw FormValidationException(
                    message = responseBody.message ?: "invalid form request",
                    errors = responseBody.error!!
                )
            }
            throw ServerException("process failure, please try again")
        }
        return response
    }
}