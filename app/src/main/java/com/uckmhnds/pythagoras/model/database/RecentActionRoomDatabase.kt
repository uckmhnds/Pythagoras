package com.uckmhnds.pythagoras.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uckmhnds.pythagoras.model.entities.RecentAction

@Database(entities = [RecentAction::class], version = 1, exportSchema = false)
public abstract class RecentActionRoomDatabase : RoomDatabase() {

    abstract fun recentActionDao(): RecentActionDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: RecentActionRoomDatabase? = null

        fun getDatabase(context: Context): RecentActionRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecentActionRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
