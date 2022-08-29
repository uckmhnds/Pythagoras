package com.uckmhnds.pythagoras.model.database

import androidx.room.*
import com.uckmhnds.pythagoras.model.entities.RecentAction
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentActionDao {

    @Query("SELECT * FROM recent_action_table ORDER BY id ASC")
    fun getRecentActionOrdered(): Flow<List<RecentAction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recentAction: RecentAction)

    @Query("DELETE FROM recent_action_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(recentAction: RecentAction)

}