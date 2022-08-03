package com.example.hero_domain

import com.example.core.FilterOrder

// the filters available for the hero using the core options filters
sealed class HeroFilter(val uiValue: String) {

    data class Hero(
        val order: FilterOrder = FilterOrder.Descending
    ) : HeroFilter("Hero")

    data class ProWins(
        val order: FilterOrder = FilterOrder.Descending
    ) : HeroFilter("Pro win-rate")

}