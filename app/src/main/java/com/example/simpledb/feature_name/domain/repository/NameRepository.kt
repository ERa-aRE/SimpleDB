package com.example.simpledb.feature_name.domain.repository


import com.example.simpledb.feature_name.domain.model.Name
import kotlinx.coroutines.flow.Flow

interface NameRepository {

    fun getNames(): Flow<List<Name>>



    suspend fun getNameByName(name:String ): Int?


    suspend fun insertName(name: Name)

    ///
    suspend fun getNameById(id:Int) : Name?

    suspend fun deleteName(name: Name)
    //
    suspend fun getTheLastId():Int
}