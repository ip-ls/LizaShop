package com.liza.lizashop.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.liza.lizashop.R
import com.liza.lizashop.presentation.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.GONE


        // read
        val sharedPrefRead: SharedPreferences = getPreferences(MODE_PRIVATE)
        val logined = sharedPrefRead.getBoolean(LoginFragment.SHARED_PREF_LOGIN_ED, false)


        val navHost =
            supportFragmentManager.findFragmentById(R.id.bottom_fragment_container) as NavHostFragment
        val graph = navHost.navController
            .navInflater.inflate(R.navigation.main_graph)


        if (logined) {
            graph.setStartDestination(R.id.bottomNavGraph)
            navHost.navController.graph = graph
        } else {
            graph.setStartDestination(R.id.greetingFragment)
            navHost.navController.graph = graph
        }
    }
}
