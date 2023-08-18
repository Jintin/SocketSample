package com.example.socketsample.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PriceRepository @Inject constructor(
    private val apiService: ApiService,
    private val socketService: SocketService,
) {

    fun startCollect(list: List<MarketInfo>): Flow<List<MarketPrice>> {
//        socketService.observeOnConnectionOpenedEvent()
        socketService.sendSubscribe(Subscribe())
        return socketService.observePrice()
            .filter { it.topic == "coinIndex" }
            .map {
                it.data?.values?.associate { value ->
                    value.name to value.price
                }.orEmpty()
            }
            .map { map ->
                list.map {
                    MarketPrice(it.symbol, map[it.symbol] ?: -1.0, it.future)
                }
            }.catch {  }
    }

    suspend fun getMarketInfo(): List<MarketInfo> {
        return try {
            apiService.getMarketInfo().data.sortedBy { it.symbol }
        } catch (_ : Exception) {
            emptyList()
        }
    }

}