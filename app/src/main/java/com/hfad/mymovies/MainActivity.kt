package com.hfad.mymovies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hfad.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as Application).appComponentFactory.inject(this)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView = binding.bottomNavigationView

        val navController = Navigation.findNavController(this, R.id.nav_host)
        NavigationUI.setupWithNavController(navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            hideBottomAppBar(destination, navView)
        }
    }

    private fun hideBottomAppBar(destination: NavDestination, navView: BottomNavigationView) {
        when (destination.id) {
            R.id.main_fragment, R.id.favourite_fragment, R.id.search_fragment -> navView.visibility = View.VISIBLE
            else -> navView.visibility = View.GONE
        }
    }
}