package com.example.simpledb.feature_name.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.simpledb.feature_name.presentation.edtiName.EditNameScreen
import com.example.simpledb.feature_name.presentation.insert_screen.AddNameScreen
import com.example.simpledb.feature_name.presentation.search_screen.ShowScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = Screen.AddNameScreen.route){
        composable(route = Screen.AddNameScreen.route){
            AddNameScreen(navController=navController)
        }
        composable(route = Screen.ShowScreen.route ,
            arguments = listOf(
            navArgument("lastNameEntered"){
                type = NavType.StringType
                defaultValue = "NothingFromLastNavigationAction!"
                nullable =true
            }

        )){entry ->
            ShowScreen(navController=navController,lastNameEntered =entry.arguments?.getString("lastNameEntered"))
        }
        composable(route = Screen.EditScreen.route,
        arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
            },
            navArgument("id"){
                type= NavType.IntType
            }
        )
        ){entry->
            EditNameScreen(navController = navController,
                name = entry.arguments?.getString("name") ?:"J" ,
                id = entry.arguments?.getInt("id") ?:0 , )
        }

    }
}