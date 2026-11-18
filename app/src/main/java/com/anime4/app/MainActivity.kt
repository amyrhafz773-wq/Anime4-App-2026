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
            Text(
                text = "ANIME4",
                fontSize = 32.sp,
                color = Color(0xFF8B5CF6)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text("جستجوی انیمه") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "انیمه‌های محبوب",
                color = Color.White,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn {
                items(animeList.filter {
                    it.contains(search, ignoreCase = true)
                }) { anime ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF252538)
                        )
                    ) {
                        Text(
                            text = anime,
                            color = Color.White,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }
}
