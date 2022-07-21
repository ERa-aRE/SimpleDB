package com.example.simpledb.feature_name.presentation.search_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ShowScreen(viewModel: NamesViewModel= hiltViewModel()) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    var searchedNameID = viewModel.nameId.value
    var userInput by remember { mutableStateOf("") }
    var userIdSInput by remember {
        mutableStateOf("")
    }
    var userIdInput by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
    verticalArrangement = Arrangement.SpaceEvenly) {
        LazyColumn(modifier = Modifier
            .padding(5.dp)
            .weight(1f)){
            items(state.names){ name ->
                NameItem(name = name, modifier = Modifier.fillMaxWidth())
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            verticalArrangement = Arrangement.SpaceAround) {
            TextField(value =userInput , onValueChange ={userInput=it}, modifier = Modifier.align(CenterHorizontally) )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { viewModel.onEvent(ShowScreenEvent.searchingName,userInput,userIdInput) }) {
                    Text(text = "Search")
                }
                Text(text = searchedNameID?.toString() ?: "nothing !")

            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                TextField(value =userIdSInput,
                    onValueChange ={userIdSInput=it
                                   userIdInput=userIdSInput.toInt()} ,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Default) ,

                )

                Button(onClick = { viewModel.onEvent(ShowScreenEvent.deletingName,userInput,userIdInput)
                                    userIdInput=0
                                    userIdSInput=""}) {
                    Text(text = "Delete")
                }
                //TODO "Next feature would be : user cannot input an id that is > than the current max id of the db"


            }


        }
    }


}