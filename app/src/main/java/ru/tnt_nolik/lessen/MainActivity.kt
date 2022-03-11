package ru.tnt_nolik.lessen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.tnt_nolik.lessen.ui.HomeScreen.HomeScreen
import ru.tnt_nolik.lessen.ui.SecondScreen.SecondScreen
import ru.tnt_nolik.lessen.ui.theme.LessenTheme
import ru.tnt_nolik.lessen.util.Screens

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            val items = listOf(
                Screens.Home,
                Screens.Second
            )
            
            LessenTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigation{
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            items.forEach{ screen ->
                                BottomNavigationItem(
                                    icon = {Icon(Icons.Filled.Favorite, contentDescription = null)},
                                    label = { Text(text = stringResource(id = screen.resourceId))},
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route){
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true

                                            restoreState = true
                                        }
                                    }
                                )
                            }

                        }
                    }
                ) {
                    NavHost(navController = navController, startDestination = Screens.Home.route){
                        composable(Screens.Home.route){ HomeScreen() }
                        composable(Screens.Second.route){ SecondScreen() }
                    }
                }
            }
        }
    }
}
