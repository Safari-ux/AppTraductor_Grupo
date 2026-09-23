package com.example.apptraductor_grupo.navigation

sealed class NavigationEvent {

    data class NavigateTo(
        val route: Screen,
        val popUpToRoute: Screen? = null,
        val inclusive: Boolean = false,
        val singleTop: Boolean = false
    )

object PopBackStack : NavigationEvent()

object NavigateUp : NavigationEvent()
}