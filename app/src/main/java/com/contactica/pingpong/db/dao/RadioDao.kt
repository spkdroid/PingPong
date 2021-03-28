package com.contactica.pingpong.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.contactica.pingpong.model.Radio

@Dao
interface RadioDao {
    @Query("SELECT * FROM radio")
    fun getAll(): List<Radio>

    @Query("SELECT * FROM radio WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Radio>

    @Delete
    fun delete(radio: Radio)
}