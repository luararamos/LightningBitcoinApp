package com.luaramartins.lightningbitcoinapp.domain.di

import com.luaramartins.lightningbitcoinapp.data.remote.NodeRepositoryImpl
import com.luaramartins.lightningbitcoinapp.domain.repository.NodeRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<NodeRepository> { NodeRepositoryImpl(androidContext()) }
}