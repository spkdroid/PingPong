package com.contactica.pingpong.repository

import androidx.lifecycle.LiveData
import com.contactica.pingpong.db.dao.RadioDao
import com.contactica.pingpong.model.Radio
import io.reactivex.Completable
import javax.inject.Inject


class RadioDataSource @Inject constructor(var radioDao: RadioDao) : RadioRepository {

    override fun getAll(): LiveData<List<Radio>> {
        return radioDao.getAll()
    }

    override fun insert(radio: Radio): Completable {
        return radioDao.insert(radio)
    }

    override fun delete(radio: Radio): Completable {
        return radioDao.delete(radio)
    }

    override fun getById(id: Int): LiveData<List<Radio>> {
        return radioDao.findById(id)
    }


}