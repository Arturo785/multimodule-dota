package com.example.ui_herolist.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import com.example.hero_datasource_test.network.data.HeroDataValid
import com.example.hero_datasource_test.util.serializeHeroData
import com.example.ui_herolist.HeroList
import com.example.ui_herolist.coil.FakeImageLoader
import com.example.ui_herolist.ui.HeroListState
import org.junit.Rule
import org.junit.Test

/**
 * Demo isolation test for HeroList screen.
 */
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HeroListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val imageLoader: ImageLoader = FakeImageLoader.build(context)
    private val heroData = serializeHeroData(HeroDataValid.data)

    @Test
    fun areHerosShown() {
        composeTestRule.setContent {
            val state = remember {
                HeroListState(
                    heros = heroData,
                    filteredHeros = heroData,
                )
            }
            HeroList(
                state = state,
                events = {},
                navigateToDetailScreen = {},
                imageLoader = imageLoader,
            )
        }
        composeTestRule.onNodeWithText("Anti-Mage").assertIsDisplayed()
        composeTestRule.onNodeWithText("Axe").assertIsDisplayed()
        composeTestRule.onNodeWithText("Bane").assertIsDisplayed()
    }

}