package com.uckmhnds.pythagoras.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.uckmhnds.pythagoras.R
import com.uckmhnds.pythagoras.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding         = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_favorites, R.id.navigation_recent))
//
//        setupActionBarWithNavController(navController, appBarConfiguration)


        navView.setupWithNavController(navController)

        // Hide bottom nav bar at scientific calc

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.navigation_scientific_calculator) {

                navView.visibility = View.GONE

            } else {

                navView.visibility = View.VISIBLE
            }
        }

    }
}