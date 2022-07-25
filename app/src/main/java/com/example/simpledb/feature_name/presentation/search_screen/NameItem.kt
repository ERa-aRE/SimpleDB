package com.example.simpledb.feature_name.presentation.search_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.presentation.util.Screen

@Composable
fun NameItem(
    name:Name,
    modifier: Modifier,
    navController: NavController,
    sendName:String,
    sendId:Int
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .clickable { navController.navigate(route = Screen.EditScreen.passNameAndId(name=sendName, id = sendId)) }
        ) {
        Text(text=name.name,style = MaterialTheme.typography.caption, maxLines = 1)

        Text(text=name.id.toString())
    }
    

}