package com.contactica.pingpong.repository

import androidx.lifecycle.LiveData
import com.contactica.pingpong.model.Radio

interface RadioRepository {
    fun getAll():LiveData<List<Radio>>

    fun insert(radio: Radio)

    fun delete(radio: Radio)

    fun getById(id:Int):LiveData<List<Radio>>
}