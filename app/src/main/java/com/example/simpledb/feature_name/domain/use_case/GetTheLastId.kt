package com.example.simpledb.feature_name.domain.use_case

import com.example.simpledb.feature_name.domain.repository.NameRepository

class GetTheLastId (
    private val repository: NameRepository
        ){
    suspend operator fun invoke():Int{
        return repository.getTheLastId()
    }
}