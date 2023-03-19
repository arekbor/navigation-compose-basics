package pl.ar97.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import pl.ar97.navigationcompose.ui.screens.DetailScreen
import pl.ar97.navigationcompose.ui.screens.HomeScreen
import pl.ar97.navigationcompose.ui.screens.SettingsScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = NavigationDestination.Home.getDestinationName()){
                composable(NavigationDestination.Home.getDestinationName()){
                    HomeScreen(onClick = {
                        val nav = NavigationDestination.Detail.getDestinationName()
                        val route = if (it == nav) "$nav/Arek" else it
                        navController.navigate(route)
                    })
                }
                composable(NavigationDestination.Detail.getDestinationName()+"/{name}"){
                    val name = it.arguments?.getString("name") ?: ""
                    DetailScreen(name)
                }
                composable(NavigationDestination.Settings.getDestinationName()){
                    SettingsScreen(onClick = {
                        navController.navigate(
                            route = it,
                            navOptions = navOptions {
                            popUpTo(NavigationDestination.Home.getDestinationName()){
                                inclusive = true
                            }
                        })
                    })
                }
            }
        }
    }
}

