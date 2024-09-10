package com.luaramartins.lightningbitcoinapp

import com.luaramartins.lightningbitcoinapp.common.toBitcoin
import com.luaramartins.lightningbitcoinapp.common.toFormattedDateTime
import org.junit.Assert.assertEquals
import org.junit.Test

class ConversionTest {

    @Test
    fun `test toBitcoin`() {
        assertEquals("0.00000001 BTC", 1L.toBitcoin())
        assertEquals("0.00550000 BTC", 550000L.toBitcoin())
        assertEquals("0.01000000 BTC", 1000000L.toBitcoin())
        assertEquals("1.00000000 BTC", 100_000_000L.toBitcoin())
    }

    @Test
    fun `test toFormattedDateTime`() {
        val timestamp = 1522941222L
        assertEquals("05/04/2018 15:13", timestamp.toFormattedDateTime())
    }
}