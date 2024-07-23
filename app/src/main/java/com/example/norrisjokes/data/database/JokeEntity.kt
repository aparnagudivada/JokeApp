package com.example.norrisjokes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// This maps to jokes table in the DB
//It represents the joke entity in the Room DB
@Entity(tableName = "jokes")
data class JokeEntity(
    // The unique Id for the joke .It is used as primary key
    @PrimaryKey val id: String,
    // The value of the joke
    val value: String?
)

