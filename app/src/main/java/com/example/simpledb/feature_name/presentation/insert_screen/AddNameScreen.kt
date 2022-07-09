package com.example.simpledb.feature_name.presentation.insert_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simpledb.feature_name.presentation.util.Screen

@Composable
fun AddNameScreen(navController:NavController,viewModel: InsertNameViewModel = hiltViewModel()) {

    var nameChange by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    , verticalArrangement = Arrangement.Center

    ) {
        TextField(value = nameChange, onValueChange = { nameChange = it },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(top = 18.dp))



        Button(modifier = Modifier.align(alignment = CenterHorizontally),onClick = {
            viewModel._name.value = nameChange
            viewModel.onEvent(InsertNameEvent.SaveName)
        }) {
            Icon(imageVector = Icons.Default.Save, contentDescription = "save button")

        }
        Button(modifier = Modifier.align(alignment = End),onClick = {
            navController.navigate(Screen.ShowScreen.route)

        }) {
            Icon(imageVector = Icons.Default.NavigateNext, contentDescription = "Next Page")

        }
    }
}

