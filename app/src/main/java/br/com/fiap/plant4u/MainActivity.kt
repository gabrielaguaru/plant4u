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
                        startDestination = "main"
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
                        composable(route = "home/{name}/{id}") {
                            val name = it.arguments?.getString("name")
                            val id = it.arguments?.getString("id")?.toLong()
                            HomeScreen(
                                navController,
                                HomeScreenViewModel(),
                                name!!,
                                id!!
                            )
                        }
                        composable(route = "menu/{name}/{id}") {
                            val name = it.arguments?.getString("name")
                            val id = it.arguments?.getString("id")?.toLong()
                            MenuScreen(navController, name!!, id!!)
                        }
                        composable(route = "my-plants/{name}/{id}") {
                            val name = it.arguments?.getString("name")
                            val id = it.arguments?.getString("id")?.toLong()
                            MyPlantsScreen(
                                navController,
                                MyPlantsScreenViewModel(),
                                name!!,
                                id!!
                            )
                        }
                        composable(route = "register-plant/{name}/{id}") {
                            val name = it.arguments?.getString("name")
                            val id = it.arguments?.getString("id")?.toLong()
                            RegisterPlantScreen(
                                navController,
                                RegisterPlantViewModel(),
                                name!!,
                                id!!
                            )
                        }
                        composable(route = "my-account/{name}/{id}") {
                            val name = it.arguments?.getString("name")
                            val id = it.arguments?.getString("id")?.toLong()
                            MyAccountScreen(
                                navController,
                                MyAccountViewModel(),
                                name!!,
                                id!!
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