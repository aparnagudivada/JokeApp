package com.example.norrisjokes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// It defines the JokeDatabase class which is room database to store jokes
@Database(entities = [JokeEntity::class], version = 1, exportSchema = false)
abstract class JokeDatabase : RoomDatabase() {
    // Gives access to JokeDao for jokes table to interact with database
    abstract fun jokeDao(): JokeDao

    companion object {
        @Volatile

        // A variabale for the singleton instance of the database
        private var INSTANCE: JokeDatabase? = null


        // Singleton instance of the JokeDatabase if the instance is not created then it creates a new instance
        fun getDatabase(context: Context): JokeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokeDatabase::class.java,
                    "joke_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}