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
import androidx.navigation.NavController


@Composable
fun ShowScreen(viewModel: NamesViewModel= hiltViewModel(),lastNameEntered:String?,navController: NavController) {
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
                /**we might have a problem here*/
                name.id?.let {
                    if(name.name!=""){
                        NameItem(name = name,
                            modifier = Modifier.fillMaxWidth(),
                            sendName = name.name,
                            sendId = it,
                            navController = navController)
                    }

                }
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
               //after confining the deleting range of the app , now the user should be able to update an exciting name in the database
               // so the next feature would be updating an exciting user (changing its name)
                // first i should make a new screen , then i will make the names clickable , then
                // by clicking on each name 1.navigate 2.send the exciting id to the next page
                // then user will change the name and i will insert the name (unlike the insert name page)
                // with a new name and the exciting id


            }
             Text(text = "Last named Entered not long ago is : ${lastNameEntered}")





        }
    }


}