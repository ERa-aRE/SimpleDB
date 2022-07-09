package com.example.simpledb.feature_name.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpledb.feature_name.presentation.insert_screen.AddNameScreen
import com.example.simpledb.feature_name.presentation.search_screen.ShowScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = Screen.AddNameScreen.route){
        composable(route = Screen.AddNameScreen.route){
            AddNameScreen(navController=navController)
        }
        composable(route = Screen.ShowScreen.route){
            ShowScreen()
        }

    }
}