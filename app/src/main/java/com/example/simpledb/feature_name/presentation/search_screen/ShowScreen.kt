package com.example.simpledb.feature_name.presentation.search_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ShowScreen(/*navController: NavController*/viewModel: NamesViewModel= hiltViewModel()) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    var searchedNameID = viewModel.nameId.value
    var userInput by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        LazyColumn(modifier = Modifier.padding(5.dp) ){
            items(state.names){ name ->
                NameItem(name = name, modifier = Modifier.fillMaxWidth())
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(value =userInput , onValueChange ={userInput=it} )
            Button(onClick = { viewModel.onEvent(userInput) }) {
                Text(text = "Search")
            }
            Text(text = searchedNameID?.toString() ?: "not Found")

        }
    }


}