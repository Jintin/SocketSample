package com.example.bottomnavigationsample.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottomnavigationsample.data.PriceRepository
import com.example.bottomnavigationsample.data.MarketPrice
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PriceRepository,
) : ViewModel() {
    private val _futureFlow = MutableStateFlow(false)
    val futureFlow: Flow<Boolean> = _futureFlow
    suspend fun priceFlow(): Flow<List<MarketPrice>> {
        val info = repository.getMarketInfo().sortedBy { it.symbol }
        return combine(futureFlow, repository.startCollect(info)) { future, list ->
            list.filter {
                !future || it.future
            }
        }
    }

    fun selectFuture(future: Boolean) {
        viewModelScope.launch {
            _futureFlow.emit(future)
        }
    }
}