package com.example.core

/**
 * A generic class for hiding/showing some ui component.
 */
sealed class UIComponentState {

    object Show : UIComponentState()

    object Hide : UIComponentState()
}