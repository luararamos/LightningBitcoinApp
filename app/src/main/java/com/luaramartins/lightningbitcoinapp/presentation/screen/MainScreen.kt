package com.luaramartins.lightningbitcoinapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.luaramartins.lightningbitcoinapp.R
import com.luaramartins.lightningbitcoinapp.presentation.components.CardNode
import com.luaramartins.lightningbitcoinapp.presentation.components.CardNodeDescription
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_24
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_32
import com.luaramartins.lightningbitcoinapp.ui.theme.MEDIUM_PADDING
import com.luaramartins.lightningbitcoinapp.ui.theme.SMALL_PADDING
import com.luaramartins.lightningbitcoinapp.ui.theme.SUPER_PADDING

@Composable
fun MainScreen() {

    val nodeMock = NodeDetails(
        publicKey = "03864ef025fde8fb587d989186ce6a4a186895ee44a926bfc370e2c366597a3f8f",
        alias = "ACINQ",
        channels = "2908",
        capacity = "36010516297",
        firstSeen = "1522941222",
        updatedAt = "1661274935",
        city = "Vancôver",
        country = "EUA",

        )

    val listNodesMock = listOf(nodeMock, nodeMock, nodeMock, nodeMock, nodeMock)

    var visibility by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = MEDIUM_PADDING, vertical = SUPER_PADDING),
            text = stringResource(id = R.string.app_name),
            color = colorResource(id = R.color.colorTextWhite),
            fontSize = FONT_32,
            fontWeight = FontWeight.Bold,
        )
        if (visibility) {
            CardNodeDescription(node = nodeMock)
        } else {
            Spacer(modifier = Modifier.height(18.dp))
        }

        Text(
            modifier = Modifier
                .padding(horizontal = MEDIUM_PADDING, vertical = SMALL_PADDING),
            text = stringResource(id = R.string.list_nodes),
            color = colorResource(id = R.color.colorTextWhite),
            fontSize = FONT_24,
            fontWeight = FontWeight.Bold,
        )

    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items = listNodesMock) { node ->
            CardNode(
                node = node,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        visibility = true
                    }

            )
        }

    }

}