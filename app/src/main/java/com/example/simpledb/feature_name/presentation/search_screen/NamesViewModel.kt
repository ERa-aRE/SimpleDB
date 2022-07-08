package com.example.simpledb.feature_name.presentation.search_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.use_case.NameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NamesViewModel @Inject constructor(
    private val nameUseCases: NameUseCases,

):ViewModel() {
    private val _state = mutableStateOf(NamesState())
    val state :State<NamesState> = _state
    var nameId = mutableStateOf<Int?>(null)
    var userInput :String = "satan"

    ///
    private var getNamesJOb: Job? =null
    init {
        showNames()
    }
    fun OnEvent(name:String){
        viewModelScope.launch {
            try {

                    nameId.value = nameUseCases.getName(name)

         }catch (e:Exception){
                Log.d("error","cannot find the name ${e.message}")
            }

        }

    }


    fun showNames(){
        getNamesJOb?.cancel()
        getNamesJOb=nameUseCases.getNames().onEach {
            names->
            _state.value = state.value.copy(names=names)
        }.launchIn(viewModelScope)
    }

}