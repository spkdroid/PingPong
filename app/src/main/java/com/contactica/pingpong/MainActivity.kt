package com.contactica.pingpong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.contactica.pingpong.di.AppModule
import com.contactica.pingpong.di.RoomModule
import com.contactica.pingpong.di.component.DaggerAppComponent
import com.contactica.pingpong.db.RepositoryInstance
import com.contactica.pingpong.repository.RadioRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    lateinit var navHost: NavHostFragment

    @Inject
    lateinit var radioRepository: RadioRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        DaggerAppComponent.builder().appModule(AppModule(application))
                .roomModule(RoomModule(application)).build().inject(this)
        // share repository instance across the View Model classes
        RepositoryInstance.setInstance(radioRepository)
    }
}