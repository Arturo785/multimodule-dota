package com.example.hero_interactors

import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.hero_datasource.cache.HeroCache
import com.example.hero_datasource.network.HeroService
import com.example.hero_domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHeros(
    private val cache: HeroCache,
    private val service: HeroService,
) {

    fun execute(): Flow<DataState<List<Hero>>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val heros: List<Hero> = try { // catch network exceptions
                service.getHeroStats()
            } catch (e: Exception) {
                e.printStackTrace() // log to crashlytics?
                emit(
                    DataState.Response<List<Hero>>(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = e.message ?: "Unknown error"
                        )
                    )
                )
                listOf()
            }
            // insert data into cache
            cache.insert(heros)

            val cachedHeroes = cache.selectAll()

            // we emmit the cached ones because of the single source of data principle
            emit(DataState.Data(cachedHeroes))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                DataState.Response<List<Hero>>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown error"
                    )
                )
            )
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}