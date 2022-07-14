package com.example.simpledb.feature_name.domain.use_case

import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.repository.NameRepository

class DeleteName(
    private val repository: NameRepository,
) {
    suspend operator fun invoke(name: Name){
        repository.deleteName(name)
    }

}