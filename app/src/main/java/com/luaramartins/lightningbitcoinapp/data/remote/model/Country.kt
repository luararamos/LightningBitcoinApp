package com.luaramartins.lightningbitcoinapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("en") val english: String,
    @SerializedName("pt-BR") val portuguese: String,

)