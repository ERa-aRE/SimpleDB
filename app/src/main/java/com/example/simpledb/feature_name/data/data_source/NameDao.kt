package com.example.simpledb.feature_name.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simpledb.feature_name.domain.model.Name
import kotlinx.coroutines.flow.Flow


@Dao
interface NameDao {
    //for getting names from database on the top of second screen
    @Query("SELECT * FROM name")
    fun getNames():Flow<List<Name>>

    //for searching for a name
    @Query("SELECT id FROM name WHERE name= :name")
    suspend fun getNameByName(name:String ): Int?

    //for inserting names into the db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(name: Name)

}