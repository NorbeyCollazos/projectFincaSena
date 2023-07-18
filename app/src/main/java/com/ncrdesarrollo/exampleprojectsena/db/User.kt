package com.ncrdesarrollo.exampleprojectsena.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val lastName: String,
    val phone: String,
    val documentId: String,
    val email: String,
    val password: String
)
