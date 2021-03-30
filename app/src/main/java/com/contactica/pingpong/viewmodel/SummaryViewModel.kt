package com.contactica.pingpong.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.contactica.pingpong.model.Radio
import com.contactica.pingpong.repository.RadioRepository
import javax.inject.Inject

class SummaryViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    @Inject
    lateinit var radioRepository: RadioRepository

    fun getRadioStation() : LiveData<List<Radio>> {
       return radioRepository.getAll()
    }

}