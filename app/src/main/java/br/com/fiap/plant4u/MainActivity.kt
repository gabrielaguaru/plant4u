package br.com.fiap.plant4u

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.plant4u.home.HomeScreen
import br.com.fiap.plant4u.home.HomeScreenViewModel
import br.com.fiap.plant4u.login.LoginScreen
import br.com.fiap.plant4u.login.LoginViewModel
import br.com.fiap.plant4u.main.MainScreen
import br.com.fiap.plant4u.menu.MenuScreen
import br.com.fiap.plant4u.myaccount.MyAccountScreen
import br.com.fiap.plant4u.myaccount.MyAccountViewModel
import br.com.fiap.plant4u.myplants.MyPlantsScreen
import br.com.fiap.plant4u.myplants.MyPlantsScreenViewModel
import br.com.fiap.plant4u.register.RegisterScreen
import br.com.fiap.plant4u.register.RegisterViewModel
import br.com.fiap.plant4u.register_plant.RegisterPlantScreen
import br.com.fiap.plant4u.register_plant.RegisterPlantViewModel
import br.com.fiap.plant4u.ui.theme.Plant4UTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Plant4UTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "register-plant"
                    ) {
                        composable(route = "main") {
                            MainScreen(navController = navController)
                        }
                        composable(route = "login") {
                            LoginScreen(
                                navController,
                                LoginViewModel()
                            )
                        }
                        composable(route = "register") {
                            RegisterScreen(
                                navController,
                                RegisterViewModel()
                            )
                        }
                        composable(route = "home") {
                            HomeScreen(
                                navController,
                                HomeScreenViewModel()
                            )
                        }
                        composable(route = "menu") {
                            MenuScreen(navController)
                        }
                        composable(route = "my-plants") {
                            MyPlantsScreen(
                                navController,
                                MyPlantsScreenViewModel()
                            )
                        }
                        composable(route = "register-plant") {
                            RegisterPlantScreen(
                                navController,
                                RegisterPlantViewModel()
                            )
                        }
                        composable(route = "my-account") {
                            MyAccountScreen(
                                navController,
                                MyAccountViewModel()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Plant4UTheme {
        Greeting("Android")
    }
}