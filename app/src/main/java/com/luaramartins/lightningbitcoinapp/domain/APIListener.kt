package com.luaramartins.lightningbitcoinapp.domain

interface APIListener <T>  {
    fun onSuccess(response: T)
    fun onError(response: String)
    fun onLoading(stateLoading: Boolean)
}