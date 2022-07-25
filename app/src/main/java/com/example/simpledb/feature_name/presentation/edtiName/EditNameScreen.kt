package com.example.simpledb.feature_name.presentation.edtiName

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simpledb.feature_name.presentation.util.Screen

@Composable
fun EditNameScreen(
    viewModel: EditNameViewModel = hiltViewModel() ,
    name:String,
    id:Int ,
    navController: NavController

) {
    var newName by remember {
        mutableStateOf("")
    }
    var visible by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text="current name : $name")
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = "Enter a new name :")
            TextField(value = newName, onValueChange = {
                newName=it
            if(newName!=null && newName!="")visible=true })
        }
        Button(onClick = {
            if(newName!=null && newName!=""){
                viewModel.updateName(name=newName,id=id)
                navController.navigate(route = Screen.ShowScreen.passLastNameEntered())
            }




        }) {
            if(visible)Text(text = "Update !")
            else Text(text="Enter the New Name")
        }


    }

}