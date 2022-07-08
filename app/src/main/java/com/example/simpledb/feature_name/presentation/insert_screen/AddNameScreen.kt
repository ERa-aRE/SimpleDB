package com.example.simpledb.feature_name.presentation.insert_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddNameScreen(/*nav*/viewModel: InsertNameViewModel = hiltViewModel()) {

    var nameChange by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    , verticalArrangement = Arrangement.Center

    ) {
        TextField(value = nameChange, onValueChange = { nameChange = it }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))






        Button(modifier = Modifier.align(alignment = CenterHorizontally),onClick = {
            viewModel._name.value = nameChange
            viewModel.onEvent(InsertNameEvent.SaveName)
        }) {
            Icon(imageVector = Icons.Default.Save, contentDescription = "save button")

        }
    }
}

