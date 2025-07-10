package com.example.gittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridScreen()
        }
    }
}

@Composable
fun GridScreen() {
    val gridSize = 7 * 10  // 5 rows of 7 days (like a weekly heatmap)
    val squares = remember { mutableStateListOf<Boolean>().apply { repeat(gridSize) { add(false) } } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in 0 until 7) {
            Row {
                for (col in 0 until 10) {
                    val index = row * 10 + col
                    val isChecked = squares[index]
                    Box(
                        modifier = Modifier
                            .padding(3.dp)
                            .size(30.dp)
                            .background(if (isChecked) Color.Green else Color.LightGray)
                            .clickable {
                                squares[index] = !squares[index]
                                println("Square $index clicked. New state: ${squares[index]}")
                            }
                    )
                }
            }
        }
    }
}
