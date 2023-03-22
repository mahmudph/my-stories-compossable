/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data.remote.interceptor

import id.myone.mysimplecomposable.BuildConfig
import id.myone.mysimplecomposable.utils.AppStorage
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor constructor(
    private val appStorage: AppStorage
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return runBlocking {
            val request = chain.request()
            val requestBuilder = request.newBuilder()
            val userToken = appStorage.getUserToken.first()

            requestBuilder.addHeader("Authorization", "Bearer $userToken")
            requestBuilder.addHeader("x-api-key", BuildConfig.X_API_KEY)

            chain.proceed(requestBuilder.build())
        }
    }
}