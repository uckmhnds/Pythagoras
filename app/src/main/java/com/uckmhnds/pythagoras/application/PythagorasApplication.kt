package com.uckmhnds.pythagoras.application

import android.app.Application
import com.uckmhnds.pythagoras.model.database.RecentActionRepository
import com.uckmhnds.pythagoras.model.database.RecentActionRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PythagorasApplication:Application() {    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { RecentActionRoomDatabase.getDatabase(this@PythagorasApplication) }
    val repository by lazy { RecentActionRepository(database.recentActionDao()) }
}