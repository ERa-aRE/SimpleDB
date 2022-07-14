package com.example.simpledb.feature_name.presentation.search_screen

sealed class ShowScreenEvent{
    object searchingName:ShowScreenEvent()
    object deletingName:ShowScreenEvent()
}
