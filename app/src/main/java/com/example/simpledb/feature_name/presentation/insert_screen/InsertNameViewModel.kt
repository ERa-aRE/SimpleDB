package com.example.simpledb.feature_name.presentation.insert_screen

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.use_case.NameUseCases
import com.example.simpledb.feature_name.presentation.search_screen.NamesState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InsertNameViewModel @Inject constructor(
    private val nameUseCases: NameUseCases, application: Application
): AndroidViewModel(application) {
    var _name = mutableStateOf<String>("")
    init {
        _name.value = "Eradaviraf"
    }


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event:InsertNameEvent,name:String){
        when(event){
            is InsertNameEvent.SaveName -> {
                viewModelScope.launch {
                    try {
                        if (name!=null && name!=""){
                        nameUseCases.addName(Name(name=name))
                        _eventFlow.emit(UiEvent.SaveName)
                        delay(500)
                            Toast.makeText(getApplication(),"name added successfully", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            Toast.makeText(getApplication(),"name can not be empty", Toast.LENGTH_SHORT).show()
                        }


                    }catch (e:Exception){
                        Log.e("asserting name","${e.message}")

                    }
                }
            }
        }
    }







    sealed class UiEvent{
        object SaveName:UiEvent()
    }



}