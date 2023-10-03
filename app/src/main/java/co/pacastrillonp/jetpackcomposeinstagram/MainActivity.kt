package co.pacastrillonp.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.pacastrillonp.jetpackcomposeinstagram.model.Routes
import co.pacastrillonp.jetpackcomposeinstagram.ui.LoginScreen
import co.pacastrillonp.jetpackcomposeinstagram.ui.Screen1
import co.pacastrillonp.jetpackcomposeinstagram.ui.Screen2
import co.pacastrillonp.jetpackcomposeinstagram.ui.Screen3
import co.pacastrillonp.jetpackcomposeinstagram.ui.Screen4
import co.pacastrillonp.jetpackcomposeinstagram.ui.Screen5
import co.pacastrillonp.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        composable(Routes.Screen1.route) { Screen1(navigationController) }
                        composable(Routes.Screen2.route) { Screen2(navigationController) }
                        composable(Routes.Screen3.route) { Screen3(navigationController) }
                        composable(Routes.Screen4.route, arguments = listOf(navArgument("age") {
                            type = NavType.IntType
                        })) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Screen5.route, arguments = listOf(
                                navArgument("name") { defaultValue = "pepe" }
                            )
                        ) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getString("name")
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeInstagramTheme {
        LoginScreen()
    }
}