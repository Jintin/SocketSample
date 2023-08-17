package com.example.bottomnavigationsample.data

import androidx.annotation.Keep

@Keep
data class Subscribe(val op: String = "subscribe", val args: List<String> = listOf("coinIndex"))