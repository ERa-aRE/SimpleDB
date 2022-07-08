package com.example.simpledb.feature_name.presentation.insert_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.use_case.NameUseCases
import com.example.simpledb.feature_name.presentation.search_screen.NamesState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InsertNameViewModel @Inject constructor(
    private val nameUseCases: NameUseCases
):ViewModel() {
    var _name = mutableStateOf<String>("")
    init {
        _name.value = "Eradaviraf"
    }


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event:InsertNameEvent){
        when(event){
            is InsertNameEvent.SaveName -> {
                viewModelScope.launch {
                    try {
                        nameUseCases.addName(Name(
                            name = _name.value
                        ))
                        _eventFlow.emit(UiEvent.SaveName)


                    }catch (e:Exception){
                        Log.e("mainfuck","what the hell")

                    }
                }
            }
        }
    }







    sealed class UiEvent{
        object SaveName:UiEvent()
    }



}