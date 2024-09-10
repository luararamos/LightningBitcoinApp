package com.luaramartins.lightningbitcoinapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.luaramartins.lightningbitcoinapp.R
import com.luaramartins.lightningbitcoinapp.common.LightningConstants
import com.luaramartins.lightningbitcoinapp.presentation.components.CardNode
import com.luaramartins.lightningbitcoinapp.presentation.components.CardNodeDescription
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_24
import com.luaramartins.lightningbitcoinapp.ui.theme.FONT_32
import com.luaramartins.lightningbitcoinapp.ui.theme.MEDIUM_PADDING
import com.luaramartins.lightningbitcoinapp.ui.theme.SMALL_PADDING
import com.luaramartins.lightningbitcoinapp.ui.theme.SUPER_PADDING
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {

    val viewModel: MainViewModel = getViewModel()
    val stateNode = viewModel.state.value
    var nodeSelect by remember { mutableStateOf<NodeDetails?>(null) }
    var visibility by remember { mutableStateOf(false) }
    var isDisplayDialog by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        viewModel.getNodeData()
    }
    LaunchedEffect(stateNode.error) {
        if (stateNode.error.isNotBlank()) {
            isDisplayDialog = true
        }
    }


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
        if (visibility && nodeSelect != null) {
            CardNodeDescription(node = nodeSelect!!)
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
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = stateNode.isLoading),
        onRefresh = { viewModel.getNodeData() }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {

            if (stateNode.isLoading) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }


            items(items = stateNode.value) { node ->

                CardNode(
                    node = node,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            nodeSelect = node
                            visibility = true
                        }

                )
            }
        }


    }

    fun closeDialog() {
        isDisplayDialog = false
    }

    if (isDisplayDialog) {
        Dialog(onDismissRequest = { closeDialog() }) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15))
                    .size(300.dp)
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = LightningConstants.ERROR.UNKNOWN_ERROR)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = stateNode.error)
                Spacer(modifier = Modifier.size(16.dp))
                Row() {
                    Button(onClick = {
                        closeDialog()
                    }) {
                        Text(text = "Cancelar")
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Button(onClick = {
                        viewModel.getNodeData()
                        closeDialog()
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }

}