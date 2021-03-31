package com.contactica.pingpong.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contactica.pingpong.model.Radio
import com.contactica.pingpong.db.RepositoryInstance
import com.contactica.pingpong.model.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class AddRadioViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

     var status = MutableLiveData<Status>().apply { postValue(Status.INIT) }

    fun addRadio(radioName: String, radioUrl: String) {
        val uuid = Date().time.toInt()

        if (radioName.isEmpty() || radioUrl.isEmpty()) {
            status.apply {
                postValue(Status.FIELD_ERROR)
            }
        } else {
            repository.insert(Radio(uuid, radioName, radioUrl)).subscribeOn(Schedulers.io())
                .observeOn(
                    AndroidSchedulers.mainThread()
                ).doOnComplete {
                    status.apply {
                        postValue(Status.SUCCESS)
                    }
                }.doOnError {
                    status.apply {
                        postValue(Status.FAILURE)
                    }
                }.subscribe()
        }
    }


}