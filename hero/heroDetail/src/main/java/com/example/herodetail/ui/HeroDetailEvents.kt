package com.example.herodetail.ui

sealed class HeroDetailEvents {

    data class GetHeroFromCache(
        val id: Int,
    ) : HeroDetailEvents()

    object OnRemoveHeadFromQueue : HeroDetailEvents()
}