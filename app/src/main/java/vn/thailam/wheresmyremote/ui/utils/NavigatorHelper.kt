package vn.thailam.wheresmyremote.ui.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import de.palm.composestateevents.EventEffect
import vn.thailam.wheresmyremote.ui.feature.base.NavigatorState
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigator

fun NavController.toPlaceDetail(placeId: Int?) {
    if (placeId == null || placeId == 0) {
        return
    }
    navigate(
        route = AppDestinations.replaceArg(
            AppDestinations.PLACE_DETAIL,
            Pair(DestinationArg.PLACE_ID, placeId)
        )
    )
}

fun NavController.toAddItem(placeId: Int? = null) {
    navigate(
        route = AppDestinations.replaceArg(
            AppDestinations.ADD_ITEM,
            Pair(DestinationArg.PLACE_ID, placeId)
        )
    )
}

fun NavController.handleNavigatorState(navigatorState: NavigatorState) {
    when (navigatorState) {
        is NavigatorState.Idle -> Unit
        is NavigatorState.To -> navigate(navigatorState.route)
        NavigatorState.Up -> popBackStack()
    }
}

@Composable
fun AutoRouteNavigator(
    routeNavigator: RouteNavigator,
    navController: NavController,
) {
    val route = routeNavigator.route.collectAsStateWithLifecycle()

    EventEffect(event = route.value, onConsumed = routeNavigator::onRouteHandled) {
        navController.handleNavigatorState(it)
    }
}
