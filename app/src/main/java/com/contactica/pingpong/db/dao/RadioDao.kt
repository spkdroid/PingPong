package com.contactica.pingpong.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.contactica.pingpong.model.Radio
import io.reactivex.Completable

@Dao
interface RadioDao {
    @Query("SELECT * FROM radio")
    fun getAll(): LiveData<List<Radio>>

    @Query("SELECT * FROM radio WHERE uid IN (:userIds)")
    fun findById(userIds: Int): LiveData<List<Radio>>

    @Insert
    fun insert(radio: Radio) : Completable

    @Delete
    fun delete(radio: Radio): Completable
}