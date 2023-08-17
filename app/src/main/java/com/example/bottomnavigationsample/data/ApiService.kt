package com.example.bottomnavigationsample.data

import retrofit2.http.GET

interface ApiService {

    @GET("futures/api/inquire/initial/market")
    suspend fun getMarketInfo() : RawApiObj
}