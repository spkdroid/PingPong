package com.contactica.pingpong.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.contactica.pingpong.db.RadioDatabase
import com.contactica.pingpong.db.dao.RadioDao
import com.contactica.pingpong.repository.RadioDataSource
import com.contactica.pingpong.repository.RadioRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public class RoomModule(application: Application) {

    private var radioDatabase =
        Room.databaseBuilder(application, RadioDatabase::class.java, "radio-db").build()

    @Singleton
    @Provides
    fun provideDatabase(): RoomDatabase {
        return radioDatabase
    }

    @Singleton
    @Provides
    fun providesDatabaseDao(radioDatabase: RadioDatabase): RadioDao {
        return radioDatabase.radioDao()
    }

    @Singleton
    @Provides
    fun radioRepository(radioDao: RadioDao): RadioRepository {
        return RadioDataSource(radioDao)
    }
}