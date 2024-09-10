package com.luaramartins.lightningbitcoinapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.luaramartins.lightningbitcoinapp.R
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import com.luaramartins.lightningbitcoinapp.ui.theme.CORNER_RADIUS_16
import com.luaramartins.lightningbitcoinapp.ui.theme.ELEVATION_16
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_14
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_16
import com.luaramartins.lightningbitcoinapp.ui.theme.MEDIUM_PADDING

@Composable
fun CardNodeDescription(node: NodeDetails) {

    val composition: LottieComposition? by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.bitcoin_animation)
    )
    var isPlaying by remember { mutableStateOf(true) }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )

    LaunchedEffect(key1 = progress) {
        if (progress == 0f) {
            isPlaying = true

        }
        if (progress == 1f) {
            isPlaying = false
        }

    }

    LaunchedEffect(key1 = node) {
        isPlaying = true
    }


    Card(
        modifier = Modifier
            .padding(horizontal = MEDIUM_PADDING, vertical = MEDIUM_PADDING)
            .shadow(
                elevation = ELEVATION_16,
                spotColor = Color.Black,
                shape = RoundedCornerShape(CORNER_RADIUS_16)
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.colorBackgroundCardPrimary))
                .padding(MEDIUM_PADDING)
        ) {
            val (
                imgBitcoin,
                publicKey,
                alias,
                channels,
                capacity,
                firstSeen,
                updatedAt,
                city,
                inputPublicKey,
                inputAlias,
                inputChannels,
                inputCapacity,
                inputFirstSeen,
                inputUpdatedAt,
                inputCity,
                inputCountry
            ) = createRefs()

            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier
                    .constrainAs(imgBitcoin) {
                        top.linkTo(parent.top, 0.dp)
                        start.linkTo(parent.start, 0.dp)
                        bottom.linkTo(parent.bottom, 0.dp)
                    }
                    .size(64.dp)
            )

            Text(
                text = stringResource(id = R.string.public_key),
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_16,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = publicKey) {
                        top.linkTo(parent.top, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )
            Text(
                text = stringResource(id = R.string.alias),
                color = colorResource(id = R.color.colorTextPrimary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = alias) {
                        top.linkTo(publicKey.bottom, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )
            Text(
                text = stringResource(id = R.string.channels),
                color = colorResource(id = R.color.colorTextPrimary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = channels) {
                        top.linkTo(alias.bottom, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )

            Text(
                text = stringResource(id = R.string.capacity),
                color = colorResource(id = R.color.colorTextPrimary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = capacity) {
                        top.linkTo(channels.bottom, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )
            Text(
                text = stringResource(id = R.string.firstSeen),
                color = colorResource(id = R.color.colorTextPrimary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = firstSeen) {
                        top.linkTo(capacity.bottom, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )
            Text(
                text = stringResource(id = R.string.updatedAt),
                color = colorResource(id = R.color.colorTextPrimary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = updatedAt) {
                        top.linkTo(firstSeen.bottom, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )

            Text(
                text = stringResource(id = R.string.city),
                color = colorResource(id = R.color.colorTextPrimary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = city) {
                        top.linkTo(updatedAt.bottom, MEDIUM_PADDING)
                        start.linkTo(imgBitcoin.end, MEDIUM_PADDING)
                    }
            )

            Text(
                text = node.publicKey.take(10) + "...",
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_16,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputPublicKey) {
                        top.linkTo(parent.top, MEDIUM_PADDING)
                        end.linkTo(parent.end, 16.dp)
                    }
            )
            Text(
                text = node.alias,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputAlias) {
                        top.linkTo(inputPublicKey.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    }
            )

            Text(
                text = node.channels,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputChannels) {
                        top.linkTo(inputAlias.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    },

                )
            Text(
                text = node.capacity,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputCapacity) {
                        top.linkTo(inputChannels.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    },
            )
            Text(
                text = node.firstSeen,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputFirstSeen) {
                        top.linkTo(inputCapacity.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    },
            )

            Text(
                text = node.updatedAt,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputUpdatedAt) {
                        top.linkTo(inputFirstSeen.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    },
            )
            Text(
                text = node.city,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputCity) {
                        top.linkTo(inputUpdatedAt.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    },
            )
            Text(
                text = node.country,
                color = colorResource(id = R.color.colorTextSecondary),
                fontSize = FONT_14,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(ref = inputCountry) {
                        top.linkTo(inputCity.bottom, MEDIUM_PADDING)
                        end.linkTo(parent.end, MEDIUM_PADDING)
                    },
            )

        }
    }


}