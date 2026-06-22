package com.example.kotlin_work

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kotlin_work.navigation.AppNavHost
import com.example.kotlin_work.ui.theme.KotlinworkTheme

@Composable
fun KotlinWorkApp() {
    KotlinworkTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            AppNavHost()
        }
    }
}