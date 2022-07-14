package com.example.simpledb.feature_name.domain.use_case

import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.repository.NameRepository

class GetNameById(
    private val repository: NameRepository
) {
    suspend operator fun invoke(id:Int): Name?{
        return repository.getNameById(id)

    }
}