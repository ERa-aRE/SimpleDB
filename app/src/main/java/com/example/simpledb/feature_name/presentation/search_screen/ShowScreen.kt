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
fun ShowScreen(viewModel: NamesViewModel= hiltViewModel(),lastNameEntered:String?) {
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
                //TODO "Next feature would be :
               // user cannot input an id that is > than the current max id of the db , i wanted to
            // do it by passing the last entered name and getting its id but that is not good because if the
            // user enters nothing , that would be a problem , so i searched and i thought to my self
            // is there any kind of function in sqlLite that can get the last element of a table or not ? ,
            // and good news , it seems that there are some function that can be used for this purpose"
            // but i am still passing that name for the sake of learning how to pass a thing from one composable to
            // another one,


            }
             Text(text = "Last named Entered not long ago is : ${lastNameEntered}")





        }
    }


}