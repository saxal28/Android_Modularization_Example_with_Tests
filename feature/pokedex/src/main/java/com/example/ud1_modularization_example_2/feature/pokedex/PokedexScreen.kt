package com.example.ud1_modularization_example_2.feature.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    viewModel: PokedexViewModel = hiltViewModel(),
    onPokemonClick: (Int) -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PokedexScreenContent(
        modifier = modifier,
        uiState = uiState,
        onSearchQueryChanged = viewModel::onSearchQueryChanged,
        onRetry = viewModel::loadPokemonList,
        onPokemonClick = onPokemonClick
    )
}

@Composable
fun PokedexScreenContent(
    modifier: Modifier = Modifier,
    uiState: PokedexUiState,
    onSearchQueryChanged: (String) -> Unit,
    onRetry: () -> Unit,
    onPokemonClick: (Int) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFDC0A2D))
            .padding(4.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "Pokeball",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Pokédex",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp
            )
        }

        // Search and Filter Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search Bar
            Box(
                modifier = Modifier
                    .weight(1f)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(16.dp),
                        ambientColor = Color.Black.copy(alpha = 0.25f),
                        spotColor = Color.Black.copy(alpha = 0.25f)
                    )
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    BasicTextField(
                        value = uiState.searchQuery,
                        onValueChange = onSearchQueryChanged,
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        decorationBox = { innerTextField ->
                            if (uiState.searchQuery.isEmpty()) {
                                Text(
                                    text = "Search",
                                    color = Color.Gray,
                                    fontSize = 10.sp,
                                    lineHeight = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }

            // Sort Button
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(16.dp),
                        ambientColor = Color.Black.copy(alpha = 0.25f),
                        spotColor = Color.Black.copy(alpha = 0.25f)
                    )
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(8.dp)
                    .clickable { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tag_icon),
                    contentDescription = "Sort",
                    tint = Color.Black,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        // Pokemon List
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(8.dp),
                        ambientColor = Color.Black.copy(alpha = 0.25f),
                        spotColor = Color.Black.copy(alpha = 0.25f)
                    )
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 24.dp)
            ) {
                when {
                    uiState.isLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    uiState.error != null -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(text = uiState.error)
                                Button(onClick = onRetry) {
                                    Text("Retry")
                                }
                            }
                        }
                    }

                    else -> {
                        val filteredPokemon = if (uiState.searchQuery.isBlank()) {
                            uiState.pokemonList
                        } else {
                            uiState.pokemonList.filter {
                                it.name.contains(uiState.searchQuery, ignoreCase = true)
                            }
                        }

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(filteredPokemon) { pokemon ->
                                PokemonCard(pokemon = pokemon, onPokemonClick = onPokemonClick)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonCard(
    pokemon: PokemonListItem,
    modifier: Modifier = Modifier,
    onPokemonClick: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            )
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { onPokemonClick(pokemon.id ?: 0) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Number
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "#${pokemon.id.toString().padStart(3, '0')}",
                    color = Color.Gray,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Pokemon Image
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = pokemon.image,
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit,
                    fallback = painterResource(R.drawable.placeholder),
                    placeholder = painterResource(R.drawable.placeholder)
                )
            }

            // Name
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFFF0F0F0),
                        RoundedCornerShape(bottomStart = 7.dp, bottomEnd = 7.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = pokemon.name.replaceFirstChar { it.uppercase() },
                    color = Color.Black,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexScreenPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFDC0A2D))
                .padding(4.dp)
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.pokeball),
                    contentDescription = "Pokeball",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Pokédex",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp
                )
            }

            // Search and Filter Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Search Bar
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .shadow(
                            elevation = 3.dp,
                            shape = RoundedCornerShape(16.dp),
                            ambientColor = Color.Black.copy(alpha = 0.25f),
                            spotColor = Color.Black.copy(alpha = 0.25f)
                        )
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = "Search",
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Search",
                            color = Color.Gray,
                            fontSize = 10.sp,
                            lineHeight = 16.sp
                        )
                    }
                }

                // Sort Button
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 3.dp,
                            shape = RoundedCornerShape(16.dp),
                            ambientColor = Color.Black.copy(alpha = 0.25f),
                            spotColor = Color.Black.copy(alpha = 0.25f)
                        )
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(8.dp)
                        .clickable { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.tag_icon),
                        contentDescription = "Sort",
                        tint = Color.Black,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Pokemon List
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(
                            elevation = 3.dp,
                            shape = RoundedCornerShape(8.dp),
                            ambientColor = Color.Black.copy(alpha = 0.25f),
                            spotColor = Color.Black.copy(alpha = 0.25f)
                        )
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 24.dp)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(9) { index ->
                            val pokemonData = listOf(
                                "Bulbasaur" to "001",
                                "Charmander" to "004",
                                "Squirtle" to "007",
                                "Butterfree" to "012",
                                "Pikachu" to "025",
                                "Gastly" to "092",
                                "Ditto" to "132",
                                "Mew" to "152",
                                "Aron" to "304"
                            )

                            val (pokemonName, pokemonId) = pokemonData[index]

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f)
                                    .shadow(
                                        elevation = 3.dp,
                                        shape = RoundedCornerShape(8.dp),
                                        ambientColor = Color.Black.copy(alpha = 0.2f),
                                        spotColor = Color.Black.copy(alpha = 0.2f)
                                    )
                                    .background(Color.White, RoundedCornerShape(8.dp))
                                    .clickable { }
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // Number
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 8.dp, vertical = 4.dp),
                                        contentAlignment = Alignment.TopEnd
                                    ) {
                                        Text(
                                            text = "#$pokemonId",
                                            color = Color.Gray,
                                            fontSize = 8.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    // Pokemon Image
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        AsyncImage(
                                            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonId.toInt()}.png",
                                            contentDescription = pokemonName,
                                            modifier = Modifier.size(60.dp),
                                            contentScale = ContentScale.Fit
                                        )
                                    }

                                    // Name
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                Color(0xFFF0F0F0),
                                                RoundedCornerShape(
                                                    bottomStart = 7.dp,
                                                    bottomEnd = 7.dp
                                                )
                                            )
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text(
                                            text = pokemonName,
                                            color = Color.Black,
                                            fontSize = 8.sp,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    MaterialTheme {
        PokemonCard(
            pokemon = PokemonListItem(
                name = "Bulbasaur",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            ),
            onPokemonClick = {}
        )
    }
}
