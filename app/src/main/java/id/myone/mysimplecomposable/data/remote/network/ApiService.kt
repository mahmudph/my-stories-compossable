/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.data.remote.network

import id.myone.mysimplecomposable.data.remote.models.auth.*
import id.myone.mysimplecomposable.data.remote.models.story.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("/api/auth/login")
    suspend fun authLogin(@Body payload: Map<String,Any>): Response<LoginResponseModel>

    @POST("/api/auth/register")
    suspend fun authRegister(@Body payload: Map<String, Any>): Response<RegisterResponseModel>

    @POST("/api/auth/forgot-password")
    suspend fun authForgotPassword(@Body payload: Map<String, Any>):  Response<LoginResponseModel>

    @GET("/api/auth/user")
    suspend fun authUserProfile(): Response<ProfileResponseModel>


    @GET("/api/stories")
    suspend fun getStoriesListData(): Response<ListStoryResponseModel>

    @GET("/api/stories/:id")
    suspend fun getStoryDetail(@Path("id") storyId: Int): Response<DetailStoryResponseModel>

    @GET("/api/categories")
    suspend fun getCategory(): Response<CategoryResponseModel>

    @POST("/api/stories")
    suspend fun createNewStory(@Body story: Map<String,Any>): Response<CreateStoryResponseModel>

    @DELETE("/api/stories/:id")
    suspend fun deleteStory(@Path("id") storyId: Int): Response<DeleteStoryResponseModel>

}