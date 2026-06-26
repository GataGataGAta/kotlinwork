package com.example.kotlin_work.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchPlayerCard(
    searchText: String,
    resultCount: Int,
    onSearchTextChange: (String) -> Unit,
    onClearSearchClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                label = {
                    Text(text = "Search Player")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Players found $resultCount")

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onClearSearchClick,
                enabled = searchText.isNotEmpty()
            ) {
                Text(text = "Clear")
            }

        }
    }
}