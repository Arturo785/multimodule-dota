package com.codingwithmitch.dotainfo.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument


// Defines the navigation of all the screens in the app with already defined values
sealed class Screen(val route: String, val arguments: List<NamedNavArgument>) {

    object HeroList : Screen(
        route = "heroList",
        arguments = emptyList()
    )

    object HeroDetail : Screen(
        route = "heroDetail",
        arguments = listOf(navArgument("heroId") {
            type = NavType.IntType
        })
    )
}