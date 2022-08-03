package com.example.hero_interactors

import com.example.hero_datasource.cache.HeroCache
import com.example.hero_datasource.network.HeroService
import com.squareup.sqldelight.db.SqlDriver

// the holder of all our use cases
data class HeroInteractors(
    val getHeros: GetHeros,
    val getHeroFromCache: GetHeroFromCache,
    val filterHeros: FilterHeros,
    // TODO(Add other hero interactors)
) {
    companion object Factory {
        // receives a generic sql driver in order to be able to receive any kind of it and not depend on an implementation
        fun build(sqlDriver: SqlDriver): HeroInteractors {
            val service = HeroService.build()
            val cache = HeroCache.build(sqlDriver)
            return HeroInteractors(
                getHeros = GetHeros(
                    cache,
                    service = service
                ),
                getHeroFromCache = GetHeroFromCache(
                    cache = cache
                ),
                filterHeros = FilterHeros()
            )
        }

        val schema: SqlDriver.Schema = HeroCache.schema

        val dbName: String = HeroCache.dbName
    }
}