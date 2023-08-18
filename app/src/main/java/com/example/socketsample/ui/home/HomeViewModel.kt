package com.example.socketsample.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socketsample.data.MarketPrice
import com.example.socketsample.data.PriceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PriceRepository,
) : ViewModel() {
    private val _futureFlow = MutableStateFlow(false)
    val futureFlow: Flow<Boolean> = _futureFlow

    private val _priceFlow = MutableStateFlow<List<MarketPrice>>(emptyList())
    val priceFlow: Flow<List<MarketPrice>> = _priceFlow

    init {
        viewModelScope.launch {
            val info = repository.getMarketInfo()
            _priceFlow.emitAll(combine(futureFlow, repository.startCollect(info)) { future, list ->
                list.filter {
                    !future || it.future
                }
            })
        }
    }

    fun selectFuture(future: Boolean) {
        viewModelScope.launch {
            _futureFlow.emit(future)
        }
    }
}