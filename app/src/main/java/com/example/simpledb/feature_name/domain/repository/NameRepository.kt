package com.example.simpledb.feature_name.domain.repository


import com.example.simpledb.feature_name.domain.model.Name
import kotlinx.coroutines.flow.Flow

interface NameRepository {

    fun getNames(): Flow<List<Name>>



    suspend fun getNameByName(name:String ): Int?


    suspend fun insertName(name: Name)
}