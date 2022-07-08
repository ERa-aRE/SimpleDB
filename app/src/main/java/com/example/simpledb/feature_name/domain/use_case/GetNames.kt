package com.example.simpledb.feature_name.domain.use_case

import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.repository.NameRepository
import kotlinx.coroutines.flow.Flow

class GetNames(
    private val repository: NameRepository
) {
    operator fun invoke(): Flow<List<Name>> {

        return repository.getNames()
    }
}