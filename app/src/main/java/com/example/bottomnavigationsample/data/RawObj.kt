package com.example.bottomnavigationsample.data

import androidx.annotation.Keep

@Keep
data class RawApiObj(val data: List<MarketInfo>)

@Keep
data class MarketInfo(val symbol: String, val future: Boolean)

@Keep
data class RawSocketObj(val topic: String, val data: Map<String, PriceObj>?)

@Keep
data class PriceObj(val name: String, val price: Double)