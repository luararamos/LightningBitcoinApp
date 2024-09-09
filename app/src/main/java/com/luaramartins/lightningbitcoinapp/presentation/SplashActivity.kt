package com.luaramartins.lightningbitcoinapp.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.luaramartins.lightningbitcoinapp.R
import com.luaramartins.lightningbitcoinapp.ui.theme.MEDIUM_PADDING

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val composition: LottieComposition? by rememberLottieComposition(
                LottieCompositionSpec.RawRes(R.raw.b_mola)
            )

            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations =  LottieConstants.IterateForever
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.colorBackground)),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(MEDIUM_PADDING)
                ) {

                    LottieAnimation(
                        composition = composition,
                        progress = { progress },
                        modifier = Modifier.padding(MEDIUM_PADDING)
                            .size(100.dp)
                    )


                }
            }

        }
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 12000)
    }
}