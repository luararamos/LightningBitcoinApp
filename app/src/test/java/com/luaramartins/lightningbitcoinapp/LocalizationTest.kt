package com.luaramartins.lightningbitcoinapp

import com.luaramartins.lightningbitcoinapp.common.getLocalizedName
import com.luaramartins.lightningbitcoinapp.data.remote.model.City
import com.luaramartins.lightningbitcoinapp.data.remote.model.Country
import org.junit.Assert.assertEquals
import org.junit.Test

class LocalizationTest {

    @Test
    fun `test City getLocalizedName`() {
        val cityWithBoth = City(portuguese = "Vancôver", english = "Vancouver")
        val cityWithEnglishOnly = City(portuguese = "", english = "Vancouver")
        val cityWithPortugueseOnly = City(portuguese = "Vancôver", english = "")
        val cityWithNone = City("", "")

        assertEquals("Vancôver", cityWithBoth.getLocalizedName())
        assertEquals("Vancouver", cityWithEnglishOnly.getLocalizedName())
        assertEquals("Vancôver", cityWithPortugueseOnly.getLocalizedName())
        assertEquals("", cityWithNone.getLocalizedName())
    }

    @Test
    fun `test Country getLocalizedName`() {
        val countryWithBoth = Country(portuguese = "Canadá", english = "Canada")
        val countryWithEnglishOnly = Country(portuguese = "", english = "Canada")
        val countryWithPortugueseOnly = Country(portuguese = "Canadá", english = "")
        val countryWithNone = Country("", "")

        assertEquals("Canadá", countryWithBoth.getLocalizedName())
        assertEquals("Canada", countryWithEnglishOnly.getLocalizedName())
        assertEquals( "Canadá", countryWithPortugueseOnly.getLocalizedName())
        assertEquals("", countryWithNone.getLocalizedName())
    }
}