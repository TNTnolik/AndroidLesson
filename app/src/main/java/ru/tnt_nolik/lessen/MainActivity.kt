package ru.tnt_nolik.lessen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.tnt_nolik.lessen.ui.HomeScreen.HomeScreen
import ru.tnt_nolik.lessen.ui.SecondScreen.SecondScreen
import ru.tnt_nolik.lessen.ui.theme.LessenTheme
import ru.tnt_nolik.lessen.util.Routes

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            
            LessenTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = { navController.navigate(Routes.SECOND) }) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Second"
                            )
                        }
                    }
                ) {
                    NavHost(navController = navController, startDestination = Routes.HOME){
                        composable(Routes.HOME){ HomeScreen() }
                        composable(Routes.SECOND){ SecondScreen() }
                    }
                }
            }
        }
    }
}
