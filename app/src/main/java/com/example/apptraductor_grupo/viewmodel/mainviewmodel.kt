package com.example.apptraductor_grupo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apptraductor_grupo.navigation.NavigationEvent
import com.example.apptraductor_grupo.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val navigationEvents = MutableSharedFlow<NavigationEvent>()

    val navigationEvents: SharedFlow<NavigationEvent> = navigationEvents.asSharedFlow()

    fun navigateTo(screen: Screen) {
        CoroutineScope(Dispatchers.Main).launch {
            navigationEvents.emit(
                NavigationEvent.NavigateTo(
                    route = screen
                )
            )
        }
    }

    fun navigateBack() {
        CoroutineScope(Dispatchers.Main).launch {
            navigationEvents.emit(NavigationEvent.PopBackStack)
        }
    }

    fun navigateUp() {
        CoroutineScope(Dispatchers.Main).launch {
            navigationEvents.emit(NavigationEvent.NavigateUp)
        }
    }
}