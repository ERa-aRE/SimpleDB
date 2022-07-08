package com.example.simpledb.feature_name.presentation.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpledb.feature_name.domain.model.Name

@Composable
fun NameItem(
    name:Name,
    modifier: Modifier
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Text(text=name.name,style = MaterialTheme.typography.caption, maxLines = 1)

        Text(text=name.id.toString())
    }
    

}