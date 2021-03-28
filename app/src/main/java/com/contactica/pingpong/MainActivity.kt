package com.contactica.pingpong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
}