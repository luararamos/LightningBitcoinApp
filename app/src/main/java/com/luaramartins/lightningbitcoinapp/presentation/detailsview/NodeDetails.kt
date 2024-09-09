package com.luaramartins.lightningbitcoinapp.presentation.detailsview

data class NodeDetails (
    val publicKey: String,
    val alias: String,
    val channels: String,
    val capacity: String,
    val firstSeen: String,
    val updatedAt: String,
    val city: String,
    val country: String,
)