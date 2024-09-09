package com.luaramartins.lightningbitcoinapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.luaramartins.lightningbitcoinapp.R
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import com.luaramartins.lightningbitcoinapp.ui.theme.CORNER_RADIUS_16
import com.luaramartins.lightningbitcoinapp.ui.theme.ELEVATION_16
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_14
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_16
import com.luaramartins.lightningbitcoinapp.ui.theme.MEDIUM_PADDING
import com.luaramartins.lightningbitcoinapp.ui.theme.SMALL_PADDING

@Composable
fun CardNode(
    node: NodeDetails,
    modifier: Modifier = Modifier,

    ) {
    Card(
        modifier = modifier
            .padding(horizontal = MEDIUM_PADDING, vertical = SMALL_PADDING)
            .shadow(
                elevation = ELEVATION_16,
                spotColor = Color.Black,
                shape = RoundedCornerShape(CORNER_RADIUS_16)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.colorBackgroundCardSecond))
                .padding(MEDIUM_PADDING)

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = stringResource(id = R.string.alias),
                    color = colorResource(id = R.color.colorTextSecondary),
                    fontSize = FONT_16,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = node.alias,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = colorResource(id = R.color.colorTextWhite),
                    fontSize = FONT_14,
                    fontWeight = FontWeight.Bold

                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = stringResource(id = R.string.channels),
                    color = colorResource(id = R.color.colorTextSecondary),
                    fontSize = FONT_16,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = node.channels,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = colorResource(id = R.color.colorTextWhite),
                    fontSize = FONT_14,
                    fontWeight = FontWeight.Bold

                )
            }
        }

    }
}