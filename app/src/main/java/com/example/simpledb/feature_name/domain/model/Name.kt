package com.example.simpledb.feature_name.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Name(
    val name: String,
    @PrimaryKey (autoGenerate = true) val id:Int? = null
)
