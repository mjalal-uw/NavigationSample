package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.SecondScreen
import com.example.navigationsample.ui.theme.NavigationSampleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable(route = "firstscreen") {
            FirstScreen(navigateToSecondScreen = { name -> navController.navigate(route = "secondscreen/$name") })

        }
        composable(route = "secondscreen/{name}") {
            SecondScreen(
                navigateToFirstScreen = { navController.navigate("firstscreen") },
                navigateToThirdScreen = { navController.navigate(route = "thirdscreen") },
                name = it.arguments?.getString("name") ?: "no name"
            )
        }
        composable(route = "thirdscreen") {
            ThirdScreen(
                navigateToFirstScreen = { navController.navigate("firstscreen") }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyApp()
}