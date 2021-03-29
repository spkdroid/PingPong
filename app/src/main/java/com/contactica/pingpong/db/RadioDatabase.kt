package com.contactica.pingpong.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.contactica.pingpong.db.dao.RadioDao
import com.contactica.pingpong.model.Radio


@Database(entities = [Radio::class], version = 1)
abstract class RadioDatabase : RoomDatabase() {
    abstract fun radioDao(): RadioDao
}