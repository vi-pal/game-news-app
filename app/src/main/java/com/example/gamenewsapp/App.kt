package com.example.gamenewsapp

import android.app.Application
import com.example.gamenewsapp.di.NetworkModule
import com.example.gamenewsapp.di.RepositoryModule
import com.example.gamenewsapp.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(NetworkModule.module, ViewModelModule.module, RepositoryModule.module)
        }
    }
}