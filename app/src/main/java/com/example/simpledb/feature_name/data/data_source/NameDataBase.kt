package com.example.simpledb.feature_name.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simpledb.feature_name.domain.model.Name


@Database(
    entities =[Name::class] ,
    version = 1
)
abstract class NameDataBase:RoomDatabase() {

    abstract val nameDao : NameDao
    companion object{
        const val DATABASE_NAME = "Names_db"
    }
}