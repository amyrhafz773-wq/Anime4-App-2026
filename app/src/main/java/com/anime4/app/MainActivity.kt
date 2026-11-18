package com.anime4.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Anime4App()
        }
    }
}

@Composable
fun Anime4App() {
    val animeList = listOf(
        "One Piece",
        "Naruto",
        "Bleach",
        "Attack on Titan",
        "Jujutsu Kaisen",
        "Demon Slayer",
        "Death Note"
    )

    var search by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF10101A))
                .padding(16.dp)
        ) {
            Text("ANIME4", fontSize = 32.sp, color = Color(0xFF8B5CF6))

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text("جستجوی انیم
