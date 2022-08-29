package com.uckmhnds.pythagoras.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_action_table")

data class RecentAction(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val action:String,

    val actionDetail:String,

    val date: String,

    val time: String,

    val icon: Int,

    var expand: Boolean

    )
