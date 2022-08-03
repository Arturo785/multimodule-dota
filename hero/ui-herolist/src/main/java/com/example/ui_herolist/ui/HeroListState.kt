package com.example.ui_herolist.ui

import com.example.core.FilterOrder
import com.example.core.ProgressBarState
import com.example.core.Queue
import com.example.core.UIComponent
import com.example.core.UIComponentState
import com.example.hero_domain.Hero
import com.example.hero_domain.HeroAttribute
import com.example.hero_domain.HeroFilter

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val filteredHeros: List<Hero> = listOf(),
    val heroName: String = "",
    val heroFilter: HeroFilter = HeroFilter.Hero(FilterOrder.Descending),
    val primaryAttrFilter: HeroAttribute = HeroAttribute.Unknown,
    val filterDialogState: UIComponentState = UIComponentState.Hide, // show/hide the filter dialog
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)