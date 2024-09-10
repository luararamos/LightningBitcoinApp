package com.luaramartins.lightningbitcoinapp.common

import com.luaramartins.lightningbitcoinapp.data.remote.model.City
import com.luaramartins.lightningbitcoinapp.data.remote.model.Country
import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun List<Node>.details(): List<NodeDetails> {
    return map {
        NodeDetails(
            publicKey = it.publicKey,
            alias = it.alias,
            channels = it.channels.toString(),
            capacity = it.capacity.toBitcoin(),
            firstSeen = it.firstSeen.toFormattedDateTime(),
            updatedAt = it.updatedAt.toFormattedDateTime(),
            city = it.city?.getLocalizedName() ?: "",
            country = it.country?.getLocalizedName() ?: "",
        )
    }
}

fun Long.toBitcoin(): String {
    val btc = this / 100_000_000.0
    return String.format(Locale.US, "%.8f BTC", btc)
}

fun Long.toFormattedDateTime(): String {
    val date = Date(this * 1000)
    val format = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    format.timeZone = TimeZone.getTimeZone("UTC")
    return format.format(date)
}

fun City.getLocalizedName(): String {
    if (this == null) {
        return ""
    }
    return when {
        this.portuguese?.isNotBlank() == true -> this.portuguese
        this.english?.isNotBlank() == true-> this.english
        else -> ""
    }
}

fun Country.getLocalizedName(): String {
    if (this == null) {
        return ""
    }
    return when {
        this.portuguese?.isNotBlank() == true -> this.portuguese
        this.english?.isNotBlank() == true-> this.english
        else -> ""
    }
}
