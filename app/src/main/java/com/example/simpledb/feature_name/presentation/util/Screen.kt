package com.example.simpledb.feature_name.presentation.util

sealed class Screen (val route:String){
    object AddNameScreen :Screen("add_name_screen")
    object ShowScreen : Screen("show_screen?lastNameEntered={lastNameEntered}"){
        fun passLastNameEntered(lastNameEntered:String="NothingFromLastNavigationAction!"):String{
            return "show_screen?lastNameEntered=$lastNameEntered"


        }
    }
    object EditScreen :Screen("edit_screen/{name}/{id}"){
        fun passNameAndId(name:String,id:Int):String{
            return "edit_screen/$name/$id"
        }
    }



}
