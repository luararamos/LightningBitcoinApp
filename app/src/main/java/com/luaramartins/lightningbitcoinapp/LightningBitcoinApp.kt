package com.luaramartins.lightningbitcoinapp

import android.app.Application
import com.luaramartins.lightningbitcoinapp.domain.di.repositoryModule
import com.luaramartins.lightningbitcoinapp.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class LightningBitcoinApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@LightningBitcoinApp)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }
}