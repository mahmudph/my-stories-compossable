/**
 * Created by Mahmud on 16/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import id.myone.mysimplecomposable.data.AuthRepositoryImpl
import id.myone.mysimplecomposable.data.StoryRepositoryImpl
import id.myone.mysimplecomposable.data.remote.RemoteAuthDataSource
import id.myone.mysimplecomposable.data.remote.RemoteAuthDataSourceContract
import id.myone.mysimplecomposable.data.remote.RemoteStoryDataSource
import id.myone.mysimplecomposable.data.remote.RemoteStoryDataSourceContract
import id.myone.mysimplecomposable.data.remote.interceptor.AuthInterceptor
import id.myone.mysimplecomposable.data.remote.interceptor.ValidateResponseInterceptor
import id.myone.mysimplecomposable.data.remote.network.ApiConfigBuilder
import id.myone.mysimplecomposable.domain.repository.AuthRepositoryContract
import id.myone.mysimplecomposable.domain.repository.StoryRepositoryContract
import id.myone.mysimplecomposable.domain.usecase.auth.ForgotPasswordUseCase
import id.myone.mysimplecomposable.domain.usecase.auth.LoginUseCase
import id.myone.mysimplecomposable.domain.usecase.auth.RegisterUseCase
import id.myone.mysimplecomposable.domain.usecase.auth.UserProfileUseCase
import id.myone.mysimplecomposable.domain.usecase.story.CreateStoryUseCase
import id.myone.mysimplecomposable.domain.usecase.story.DeleteStoryUseCase
import id.myone.mysimplecomposable.domain.usecase.story.GetDetailStoryUseCase
import id.myone.mysimplecomposable.domain.usecase.story.GetListStoryUseCase
import id.myone.mysimplecomposable.presentation.viewmodel.auth.ForgotPasswordViewModel
import id.myone.mysimplecomposable.presentation.viewmodel.auth.LoginViewModel
import id.myone.mysimplecomposable.presentation.viewmodel.auth.RegisterViewModel
import id.myone.mysimplecomposable.presentation.viewmodel.story.CreateStoryViewModel
import id.myone.mysimplecomposable.presentation.viewmodel.story.ListStoryViewModel
import id.myone.mysimplecomposable.utils.AppStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * create datastore
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("my-simple-composable")

private val authUseCases = module {
    single { LoginUseCase(get(), get()) }
    single { RegisterUseCase(get()) }
    single { UserProfileUseCase(get()) }
    single { ForgotPasswordUseCase(get()) }
}

private val storyUseCases = module {
    single { CreateStoryUseCase(get()) }
    single { DeleteStoryUseCase(get()) }
    single { GetDetailStoryUseCase(get()) }
    single { GetListStoryUseCase(get()) }
}

private val authViewModels = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { ForgotPasswordViewModel(get()) }
}


private val storyViewModels = module {
    single { CreateStoryViewModel(get()) }
    single { ListStoryViewModel(get(), get()) }
}

private val storageModels = module {
    single { androidContext().dataStore }
    single { AppStorage(get()) }
}

private val apiServices = module {

    single { AuthInterceptor(get()) }
    single { ValidateResponseInterceptor() }

    single { ApiConfigBuilder.provideRetrofit(get()) }
    single { ApiConfigBuilder.provideOkHttpClient(get(), get()) }

    single<RemoteStoryDataSourceContract> { RemoteStoryDataSource(get()) }
    single<RemoteAuthDataSourceContract> { RemoteAuthDataSource(get()) }

    single<StoryRepositoryContract> { StoryRepositoryImpl(get()) }
    single<AuthRepositoryContract> { AuthRepositoryImpl(get()) }
}

val koinModules = listOf(
    storageModels,
    authUseCases,
    storyUseCases,
    authViewModels,
    storyViewModels,
    apiServices
)