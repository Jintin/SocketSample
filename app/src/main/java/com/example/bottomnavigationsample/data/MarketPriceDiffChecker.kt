package com.example.bottomnavigationsample.data

import androidx.recyclerview.widget.DiffUtil

object MarketPriceDiffChecker : DiffUtil.ItemCallback<MarketPrice>() {
    override fun areItemsTheSame(oldItem: MarketPrice, newItem: MarketPrice): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MarketPrice, newItem: MarketPrice): Boolean {
        return oldItem == newItem
    }
}