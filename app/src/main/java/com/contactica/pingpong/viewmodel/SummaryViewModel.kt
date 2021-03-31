package com.contactica.pingpong.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contactica.pingpong.model.Radio
import com.contactica.pingpong.model.Status
import com.contactica.pingpong.repository.RadioRepository
import javax.inject.Inject

class SummaryViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    var radioStation = MutableLiveData<List<Radio>>()

    fun getRadioList(){
        repository.getAll().observeForever {
            radioStation.postValue(it)
        }
    }
}