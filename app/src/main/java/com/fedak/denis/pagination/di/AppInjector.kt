package com.fedak.denis.pagination.di

import com.fedak.denis.pagination.network.NetworkApi
import com.fedak.denis.pagination.presenter.MainPresenter
import com.fedak.denis.pagination.repository.MainRepository
import com.fedak.denis.pagination.repository.MainRepositoryImp
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val repositoryModule = module {
    single<MainRepository> { MainRepositoryImp(get()) }
}

val presenterModule = module {
    single { MainPresenter(get()) }
}

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttp())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    single<NetworkApi> { get<Retrofit>().create(NetworkApi::class.java) }
}

fun createOkHttp(): OkHttpClient {

    val okhttp = OkHttpClient.Builder()
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    okhttp.addInterceptor(loggingInterceptor)

    return okhttp.build()
}
