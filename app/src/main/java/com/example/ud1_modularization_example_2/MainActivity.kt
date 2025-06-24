package com.example.ud1_modularization_example_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ud1_modularization_example_2.feature.pokedex.PokedexScreen
import com.example.ud1_modularization_example_2.feature.pokemon_detail.PokemonDetailScreen
import com.example.ud1_modularization_example_2.ui.theme.Ud1modularizationexample2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud1modularizationexample2Theme {
                Scaffold { paddingValues ->
                    PokemonApp(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFDC0A2D))
                            .padding(paddingValues)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pokedex",
        modifier = modifier
    ) {
        composable("pokedex") {
            PokedexScreen(
                onPokemonClick = { pokemonId ->
                    navController.navigate("pokemon_detail/$pokemonId")
                }
            )
        }

        composable("pokemon_detail/{pokemonId}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toIntOrNull() ?: 1
            PokemonDetailScreen(
                pokemonId = pokemonId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
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
    Ud1modularizationexample2Theme {
        Greeting("Android")
    }
}
