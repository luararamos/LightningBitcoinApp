package com.luaramartins.lightningbitcoinapp.common

import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails

fun List<Node>.details(): List<NodeDetails> {
    return map {
        NodeDetails(
            publicKey = it.publicKey,
            alias = it.alias,
            channels = it.channels.toString(),
            capacity = it.capacity.toString(),
            firstSeen = it.firstSeen.toString(),
            updatedAt = it.updatedAt.toString(),
            city = "",
            country = "",
        )
    }
}

