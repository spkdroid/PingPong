package com.contactica.pingpong.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.contactica.pingpong.model.Radio
import com.contactica.pingpong.db.RepositoryInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class AddRadioViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    fun addRadio(radioName: String, radioUrl: String) {
        val uuid = Date().time.toInt()
        repository.insert(Radio(uuid, radioName, radioUrl)).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe()
    }


}