package com.example.herodetail.ui

import com.example.core.ProgressBarState
import com.example.core.Queue
import com.example.core.UIComponent
import com.example.hero_domain.Hero


data class HeroDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val hero: Hero? = null,
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)