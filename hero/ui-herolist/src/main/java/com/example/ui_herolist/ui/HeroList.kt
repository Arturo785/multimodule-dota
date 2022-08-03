package com.example.ui_herolist

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.example.components.DefaultScreenUI
import com.example.core.ProgressBarState
import com.example.core.UIComponentState
import com.example.ui_herolist.components.HeroListFilter
import com.example.ui_herolist.components.HeroListItem
import com.example.ui_herolist.components.HeroListToolbar
import com.example.ui_herolist.ui.HeroListEvents
import com.example.ui_herolist.ui.HeroListState

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun HeroList(
    state: HeroListState,
    events: (HeroListEvents) -> Unit,
    imageLoader: ImageLoader,
    navigateToDetailScreen: (Int) -> Unit,
) {
    DefaultScreenUI(
        queue = state.errorQueue,
        onRemoveHeadFromQueue = {
          events.invoke(HeroListEvents.OnRemoveHeadFromQueue)
        },
        progressBarState = state.progressBarState,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                HeroListToolbar(
                    heroName = state.heroName,
                    onHeroNameChanged = { heroName ->
                        events.invoke(HeroListEvents.UpdateHeroName(heroName))
                    },
                    onExecuteSearch = {
                        events.invoke(HeroListEvents.FilterHeros)
                    },
                    onShowFilterDialog = {
                        events.invoke(HeroListEvents.UpdateFilterDialogState(UIComponentState.Show))
                    }
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(state.filteredHeros) { hero ->
                        HeroListItem(
                            hero = hero,
                            onSelectHero = { heroId ->
                                navigateToDetailScreen(heroId)
                            },
                            imageLoader = imageLoader,
                        )
                    }
                }
            }
            if (state.filterDialogState is UIComponentState.Show) {
                HeroListFilter(
                    heroFilter = state.heroFilter,
                    onUpdateHeroFilter = { heroFilter ->
                        events.invoke(HeroListEvents.UpdateHeroFilter(heroFilter))
                    },
                    attributeFilter = state.primaryAttrFilter,
                    onUpdateAttributeFilter = { attribute ->
                        events.invoke(HeroListEvents.UpdateAttributeFilter(attribute))
                    },
                    onCloseDialog = {
                        events.invoke(HeroListEvents.UpdateFilterDialogState(UIComponentState.Hide))
                    }
                )
            }
        }
    }

}








