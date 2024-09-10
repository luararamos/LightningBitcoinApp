package com.luaramartins.lightningbitcoinapp.presentation.di


import com.luaramartins.lightningbitcoinapp.presentation.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }

}