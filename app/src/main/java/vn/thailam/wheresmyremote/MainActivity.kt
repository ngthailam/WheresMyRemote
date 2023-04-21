package vn.thailam.wheresmyremote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import vn.thailam.wheresmyremote.ui.feature.additem.AddItemScreen
import vn.thailam.wheresmyremote.ui.feature.addplace.AddPlaceScreen
import vn.thailam.wheresmyremote.ui.feature.home.HomeScreen
import vn.thailam.wheresmyremote.ui.feature.placedetail.PlaceDetailScreen
import vn.thailam.wheresmyremote.ui.theme.WheresMyRemoteTheme
import vn.thailam.wheresmyremote.ui.utils.AppDestinations
import vn.thailam.wheresmyremote.ui.utils.DestinationArg

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WheresMyRemoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(startDestination = AppDestinations.HOME)
                }
            }

        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(AppDestinations.HOME) {
            HomeScreen(navController = navController)
        }
        composable(AppDestinations.ADD_PLACE) { AddPlaceScreen(navController = navController) }
        composable(
            AppDestinations.ADD_ITEM,
            arguments = listOf(navArgument(DestinationArg.PLACE_ID) { type = NavType.IntType })
        ) {
            val placeId: Int? = it.arguments?.getInt(DestinationArg.PLACE_ID)
            AddItemScreen(navController = navController, placeId = placeId)
        }
        composable(
            AppDestinations.PLACE_DETAIL,
            arguments = listOf(navArgument(DestinationArg.PLACE_ID) { type = NavType.IntType })
        ) {
            val placeId: Int = it.arguments?.getInt(DestinationArg.PLACE_ID) ?: 0
            PlaceDetailScreen(navController = navController, placeId = placeId)
        }
    }
}
