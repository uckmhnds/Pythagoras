package com.uckmhnds.pythagoras.model.database

import androidx.annotation.WorkerThread
import com.uckmhnds.pythagoras.model.entities.RecentAction

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class ScientificCalculatorRepository(private val recentActionDao: RecentActionDao) {

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(recentAction: RecentAction) {
        recentActionDao.insert(recentAction)
    }
}