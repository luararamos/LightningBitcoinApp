package com.luaramartins.lightningbitcoinapp

import com.luaramartins.lightningbitcoinapp.common.details
import com.luaramartins.lightningbitcoinapp.data.remote.model.City
import com.luaramartins.lightningbitcoinapp.data.remote.model.Country
import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DetailsTest {

    @Test
    fun `test details conversion`() {
        val nodes = listOf(
            Node(
                publicKey = "03864ef025fde8fb587d989186ce6a4a186895ee44a926bfc370e2c366597a3f8f",
                alias = "ACINQ",
                channels = 2908,
                capacity = 36010516297,
                firstSeen = 1522941222,
                updatedAt = 1661274935,
                city = City(portuguese = "Vancôver", english = "Vancouver"),
                country = Country(portuguese = "Canadá", english = "Canada"),

                )
        )

        val expected = listOf(
            NodeDetails(
                publicKey = "03864ef025fde8fb587d989186ce6a4a186895ee44a926bfc370e2c366597a3f8f",
                alias = "ACINQ",
                channels = "2908",
                capacity = "360.10516297 BTC",
                firstSeen = "05/04/2018 15:13",
                updatedAt = "23/08/2022 17:15",
                city = "Vancôver",
                country = "Canadá"
            )
        )

        assertEquals(expected, nodes.details())
    }
}