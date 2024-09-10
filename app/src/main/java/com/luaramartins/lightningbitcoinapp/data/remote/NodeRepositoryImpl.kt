package com.luaramartins.lightningbitcoinapp.data.remote

import android.content.Context
import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import com.luaramartins.lightningbitcoinapp.domain.APIListener
import com.luaramartins.lightningbitcoinapp.domain.repository.NodeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NodeRepositoryImpl(context: Context) : BaseRepository(context), NodeRepository {
    private val remote = RetrofitClient.getService(NodeService::class.java)
    override fun getNode(listener: APIListener<List<Node>>) {
        CoroutineScope(Dispatchers.Main).launch {
            execute({ remote.getNode() }, listener)
        }
    }

}