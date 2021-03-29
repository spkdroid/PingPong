package com.contactica.pingpong.di.component

import android.app.Application
import com.contactica.pingpong.MainActivity
import com.contactica.pingpong.db.RadioDatabase
import com.contactica.pingpong.db.dao.RadioDao
import com.contactica.pingpong.di.AppModule
import com.contactica.pingpong.di.RoomModule
import com.contactica.pingpong.repository.RadioRepository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(dependencies = [], modules = [AppModule::class, RoomModule::class])
public interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun radioDao(): RadioDao

    fun radioDatabase(): RadioDatabase

    fun radioRepository(): RadioRepository

    fun application(): Application
}