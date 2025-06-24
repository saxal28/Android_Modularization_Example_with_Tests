package com.example.ud1_modularization_example_2.feature.pokemon_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail

@Composable
fun PokemonDetailScreen(
    pokemonId: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(pokemonId) {
        viewModel.loadPokemonDetail(pokemonId)
    }

    when {
        uiState.isLoading -> {
            LoadingScreen(onBackClick = onBackClick)
        }

        uiState.error != null -> {
            ErrorScreen(
                error = uiState.error!!,
                onBackClick = onBackClick
            )
        }

        uiState.pokemon != null -> {
            PokemonDetailContent(
                pokemon = uiState.pokemon!!,
                onBackClick = onBackClick,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun LoadingScreen(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF74CB48))
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}

@Composable
private fun ErrorScreen(error: String, onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF74CB48))
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Text(
            text = "Error: $error",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun PokemonDetailContent(
    pokemon: PokemonDetail,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val primaryTypeColor = getPokemonTypeColor(pokemon.types.firstOrNull()?.type?.name ?: "normal")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(primaryTypeColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Header Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = pokemon.name.replaceFirstChar { it.uppercase() },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "#${pokemon.id.toString().padStart(3, '0')}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Pokemon Image Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = pokemon.sprites.frontDefault,
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Detail Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 56.dp)
                ) {
                    // Pokemon Types
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        pokemon.types.forEach { type ->
                            TypeChip(
                                typeName = type.type.name,
                                backgroundColor = getPokemonTypeColor(type.type.name)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // About Section
                    Text(
                        text = "About",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryTypeColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Attributes Row
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        ) {
                            // Weight
                            AttributeItem(
                                value = "${pokemon.weight / 10.0} kg",
                                label = "Weight",
                                modifier = Modifier.weight(1f)
                            )

                            // Divider
                            Box(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(56.dp)
                                    .background(Color(0xFFE0E0E0))
                            )

                            // Height
                            AttributeItem(
                                value = "${pokemon.height / 10.0} m",
                                label = "Height",
                                modifier = Modifier.weight(1f)
                            )

                            // Divider
                            Box(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(56.dp)
                                    .background(Color(0xFFE0E0E0))
                            )

                            // Abilities
                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    pokemon.abilities.take(2).forEach { ability ->
                                        Text(
                                            text = ability.ability.name.replaceFirstChar { it.uppercase() },
                                            fontSize = 10.sp,
                                            color = Color(0xFF1D1D1D),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }

                                Text(
                                    text = "Moves",
                                    fontSize = 8.sp,
                                    color = Color(0xFF666666),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Description
                    Text(
                        text = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
                        fontSize = 10.sp,
                        color = Color(0xFF1D1D1D),
                        textAlign = TextAlign.Justify,
                        lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Base Stats Section
                    Text(
                        text = "Base Stats",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryTypeColor
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Stats
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            // Stat Labels
                            Column(
                                modifier = Modifier.padding(end = 4.dp)
                            ) {
                                StatLabel("HP", primaryTypeColor)
                                StatLabel("ATK", primaryTypeColor)
                                StatLabel("DEF", primaryTypeColor)
                                StatLabel("SATK", primaryTypeColor)
                                StatLabel("SDEF", primaryTypeColor)
                                StatLabel("SPD", primaryTypeColor)
                            }

                            // Divider
                            Box(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(96.dp)
                                    .background(Color(0xFFE0E0E0))
                            )

                            // Stat Values
                            Column(
                                modifier = Modifier.padding(start = 4.dp)
                            ) {
                                pokemon.stats.forEach { stat ->
                                    StatValue(
                                        value = stat.baseStat.toString().padStart(3, '0')
                                    )
                                }
                            }

                            // Stat Bars
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 8.dp)
                            ) {
                                pokemon.stats.forEach { stat ->
                                    StatBar(
                                        value = stat.baseStat,
                                        maxValue = 200,
                                        color = primaryTypeColor
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

@Composable
private fun TypeChip(
    typeName: String,
    backgroundColor: Color,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = Modifier
    ) {
        Text(
            text = typeName.replaceFirstChar { it.uppercase() },
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}

@Composable
private fun AttributeItem(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 10.sp,
            color = Color(0xFF1D1D1D),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = label,
            fontSize = 8.sp,
            color = Color(0xFF666666),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun StatLabel(
    label: String,
    color: Color,
) {
    Text(
        text = label,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        textAlign = TextAlign.End,
        modifier = Modifier
            .width(40.dp)
            .height(16.dp)
    )
}

@Composable
private fun StatValue(
    value: String,
) {
    Text(
        text = value,
        fontSize = 10.sp,
        color = Color(0xFF1D1D1D),
        modifier = Modifier
            .width(30.dp)
            .height(16.dp)
    )
}

@Composable
private fun StatBar(
    value: Int,
    maxValue: Int,
    color: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .padding(vertical = 6.dp)
    ) {
        // Background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(2.dp)
                )
        )

        // Progress
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = (value.toFloat() / maxValue).coerceAtMost(1f))
                .fillMaxSize()
                .background(
                    color = color,
                    shape = RoundedCornerShape(2.dp)
                )
        )
    }
}

private fun getPokemonTypeColor(typeName: String): Color {
    return when (typeName.lowercase()) {
        "grass" -> Color(0xFF74CB48)
        "poison" -> Color(0xFFA43E9E)
        "fire" -> Color(0xFFF57C00)
        "water" -> Color(0xFF42A5F5)
        "electric" -> Color(0xFFFFD54F)
        "psychic" -> Color(0xFFAB47BC)
        "ice" -> Color(0xFF81D4FA)
        "dragon" -> Color(0xFF7B68EE)
        "dark" -> Color(0xFF8D6E63)
        "fairy" -> Color(0xFFF48FB1)
        "normal" -> Color(0xFF9E9E9E)
        "fighting" -> Color(0xFFD32F2F)
        "flying" -> Color(0xFF90CAF9)
        "ground" -> Color(0xFFDCE775)
        "rock" -> Color(0xFFBCAAA4)
        "bug" -> Color(0xFF8BC34A)
        "ghost" -> Color(0xFF9575CD)
        "steel" -> Color(0xFF90A4AE)
        else -> Color(0xFF9E9E9E)
    }
}