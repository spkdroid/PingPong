package com.contactica.pingpong.repository

import androidx.lifecycle.LiveData
import com.contactica.pingpong.model.Radio
import io.reactivex.Completable

interface RadioRepository {
    fun getAll():LiveData<List<Radio>>

    fun insert(radio: Radio): Completable

    fun delete(radio: Radio): Completable

    fun getById(id:Int):LiveData<List<Radio>>
}