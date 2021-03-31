package com.contactica.pingpong.viewmodel

import androidx.lifecycle.ViewModel
import com.contactica.pingpong.db.RepositoryInstance
import com.contactica.pingpong.di.AppModule
import com.contactica.pingpong.di.RoomModule
import com.contactica.pingpong.di.component.DaggerAppComponent
import com.contactica.pingpong.repository.RadioRepository
import javax.inject.Inject

open class BaseViewModel:ViewModel() {

    var repository = RepositoryInstance.getInstance()

}