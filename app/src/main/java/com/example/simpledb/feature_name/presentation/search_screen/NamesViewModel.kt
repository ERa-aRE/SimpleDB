package com.example.simpledb.feature_name.presentation.search_screen

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
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NamesViewModel @Inject constructor(
    private val nameUseCases: NameUseCases, application: Application,

    ): AndroidViewModel(application) {
    private val _state = mutableStateOf(NamesState())
    val state :State<NamesState> = _state
    var nameId = mutableStateOf<Int?>(null)
    val nameToDelete= mutableStateOf<Name?>(null)

    ///
    private var getNamesJOb: Job? =null
    init {
        showNames()
    }
    fun onEvent(event:ShowScreenEvent,name:String,id:Int){
        when(event){
            is ShowScreenEvent.searchingName->{
                viewModelScope.launch {
                    try {

                        nameId.value = nameUseCases.getName(name)

                    }catch (e:Exception){
                        Log.d("error","cannot find the name ${e.message}")
                    }

                }

            }
            is ShowScreenEvent.deletingName ->{
                viewModelScope.launch {
                    try {
                        nameToDelete.value=nameUseCases.getNameById(id)
                        if(id==null || id==0 || id==-1 )Toast.makeText(getApplication(),"Id cannot be empty", Toast.LENGTH_SHORT).show()
                        if(nameToDelete.value!=null){
                        nameUseCases.deleteName(nameToDelete.value!!)
                            Toast.makeText(getApplication(),"name deleted successfully", Toast.LENGTH_SHORT).show()}

                    }catch (e:Exception){
                        Log.e("error","cannot delete the name ${e.message}")
                    }
                }
            }
        }


    }


    private fun showNames(){
        getNamesJOb?.cancel()
        getNamesJOb=nameUseCases.getNames().onEach {
            names->
            _state.value = state.value.copy(names=names)
        }.launchIn(viewModelScope)
    }

}