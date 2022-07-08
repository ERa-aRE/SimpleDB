package com.example.simpledb.feature_name.data.repository

import com.example.simpledb.feature_name.data.data_source.NameDao
import com.example.simpledb.feature_name.domain.model.Name
import com.example.simpledb.feature_name.domain.repository.NameRepository
import kotlinx.coroutines.flow.Flow

class NameRepositoryImpl(
    private val dao: NameDao,

) : NameRepository {
    override fun getNames(): Flow<List<Name>> {
        return dao.getNames()
    }

    override suspend fun getNameByName(name: String): Int? {
        return dao.getNameByName(name = name)
    }

    override suspend fun insertName(name: Name) {
        return dao.insertName(name = name)
    }
}