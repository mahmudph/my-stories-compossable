/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data.remote.network

import id.myone.mysimplecomposable.BuildConfig
import id.myone.mysimplecomposable.data.remote.interceptor.AuthInterceptor
import id.myone.mysimplecomposable.data.remote.interceptor.ValidateResponseInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfigBuilder {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BUILD_TYPE)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(
        interceptor: AuthInterceptor,
        validateResponseInterceptor: ValidateResponseInterceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .addInterceptor(validateResponseInterceptor)
            .build()
    }
}