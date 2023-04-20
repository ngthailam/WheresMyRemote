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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vn.thailam.wheresmyremote.ui.feature.addplace.AddPlaceScreen
import vn.thailam.wheresmyremote.ui.feature.home.HomeScreen
import vn.thailam.wheresmyremote.ui.theme.WheresMyRemoteTheme
import vn.thailam.wheresmyremote.ui.utils.AppDestinations

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
        composable(AppDestinations.ADD_PLACE) { AddPlaceScreen() }
    }
}
