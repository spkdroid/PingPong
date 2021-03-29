package com.contactica.pingpong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.contactica.pingpong.di.AppModule
import com.contactica.pingpong.di.RoomModule
import com.contactica.pingpong.di.component.DaggerAppComponent
import com.contactica.pingpong.repository.RadioRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var radioRepository: RadioRepository

    lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        DaggerAppComponent.builder().appModule(AppModule(application))
            .roomModule(RoomModule(application)).build().inject(this)
    }
}