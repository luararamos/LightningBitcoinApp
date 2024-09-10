package com.luaramartins.lightningbitcoinapp.data.remote

import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import retrofit2.Response
import retrofit2.http.GET

interface NodeService {
    @GET("connectivity")
    suspend fun getNode(): Response<List<Node>>
}