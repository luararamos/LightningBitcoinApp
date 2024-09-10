package com.luaramartins.lightningbitcoinapp.presentation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.luaramartins.lightningbitcoinapp.common.details
import com.luaramartins.lightningbitcoinapp.data.remote.model.Node
import com.luaramartins.lightningbitcoinapp.domain.APIListener
import com.luaramartins.lightningbitcoinapp.domain.repository.NodeRepository
import com.luaramartins.lightningbitcoinapp.presentation.detailsview.NodeDetails
import com.luaramartins.lightningbitcoinapp.presentation.state.MainState

class MainViewModel(
    private val nodeRepository: NodeRepository
) : ViewModel() {
    private val _state = mutableStateOf(MainState<NodeDetails>())
    val state: State<MainState<NodeDetails>> = _state


    fun getNodeData() {
        nodeRepository.getNode(object : APIListener<List<Node>> {
            override fun onSuccess(response: List<Node>) {
                _state.value = state.value.copy(
                    value = response.details()
                )
            }

            override fun onError(response: String) {
                _state.value = state.value.copy(
                    error = response
                )
            }

            override fun onLoading(stateLoading: Boolean) {
                _state.value = state.value.copy(
                    isLoading = stateLoading
                )
            }
        })

    }
}