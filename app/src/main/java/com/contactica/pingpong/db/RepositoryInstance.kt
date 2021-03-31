package com.contactica.pingpong.db

import com.contactica.pingpong.repository.RadioRepository


object RepositoryInstance {

    private lateinit var instance:RadioRepository

    fun setInstance(instance:RadioRepository) {
            RepositoryInstance.instance = instance
    }

    fun getInstance():RadioRepository {
        return instance
    }
}