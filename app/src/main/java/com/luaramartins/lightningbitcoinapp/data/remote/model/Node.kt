package com.luaramartins.lightningbitcoinapp.data.remote.model

data class Node(
    val publicKey: String,
    val alias: String,
    val capacity: Long,
    val channels: Int,
    val city: City?,
    val country: Country?,
    val firstSeen: Long,
    val updatedAt: Long
)