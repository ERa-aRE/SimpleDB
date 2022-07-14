package com.example.simpledb.feature_name.domain.use_case

data class NameUseCases(
    val getNames: GetNames,
    val getName:GetName ,
    val addName: AddName,
    val getNameById: GetNameById,
    val deleteName: DeleteName,

)