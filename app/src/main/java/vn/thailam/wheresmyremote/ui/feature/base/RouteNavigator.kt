package vn.thailam.wheresmyremote.ui.feature.base

import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

sealed class NavigatorState {
    object Idle : NavigatorState()
    data class To(val route: String) : NavigatorState()
    object Up : NavigatorState()
}

interface RouteNavigator {
    val route: StateFlow<StateEventWithContent<NavigatorState>>

    suspend fun navigate(route: NavigatorState)

    fun onRouteHandled()
}

class RouteNavigatorImpl @Inject constructor() : RouteNavigator {
    private val _route = MutableStateFlow<StateEventWithContent<NavigatorState>>(consumed())
    override val route: StateFlow<StateEventWithContent<NavigatorState>> = _route.asStateFlow()

    override suspend fun navigate(route: NavigatorState) {
        _route.value = triggered(route)
    }

    override fun onRouteHandled() {
        _route.value = consumed()
    }
}
