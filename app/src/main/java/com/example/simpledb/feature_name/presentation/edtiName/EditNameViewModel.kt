package com.example.simpledb.feature_name.presentation.edtiName

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.repository.NameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNameViewModel@Inject constructor(
    private val repository: NameRepository
): ViewModel() {


    fun updateName(name:String, id:Int){
        viewModelScope.launch {
            try {
                repository.insertName(Name(name=name,id=id))

            }catch (e:Exception){
                Log.e("update","${e.message}")
            }

        }
    }
}