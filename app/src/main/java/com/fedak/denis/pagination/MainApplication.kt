package com.fedak.denis.pagination

import android.app.Application
import com.fedak.denis.pagination.di.networkModule
import com.fedak.denis.pagination.di.presenterModule
import com.fedak.denis.pagination.di.repositoryModule
import org.koin.android.ext.android.startKoin


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(repositoryModule, presenterModule, networkModule))
    }
}
