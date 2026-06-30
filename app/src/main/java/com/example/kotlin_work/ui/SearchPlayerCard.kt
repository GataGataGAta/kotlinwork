package com.example.kotlin_work.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
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
    onClearSearchClick: () -> Unit,
    isSortByName: Boolean,
    onToggleSortByName: () -> Unit,
    selectedPosition: String,
    onPositionClick: (String) -> Unit
) {
    val positions = listOf(
        "All",
        "Forward",
        "Midfielder",
        "Defender"
    )
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
                    Text(text = "Search Players")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Results: $resultCount")

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Position: $selectedPosition")

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                positions.forEachIndexed { index, position ->
                    if (position == selectedPosition) {
                        Button(
                            onClick = {
                                onPositionClick(position)
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = position)
                        }
                    } else {
                        OutlinedButton(
                            onClick = {
                                onPositionClick(position)
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = position)
                        }
                    }
                    if (index < positions.lastIndex) {
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onClearSearchClick,
                    enabled = searchText.isNotEmpty(),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Clear")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onToggleSortByName,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = if (isSortByName) {
                            "Original order"
                        } else {
                            "Sort by name"
                        }
                    )
                }
            }
        }
    }
}