package com.luaramartins.lightningbitcoinapp.domain.repository

import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import com.luaramartins.lightningbitcoinapp.domain.APIListener

interface NodeRepository {
    fun getNode(listener: APIListener<List<Node>>)
}