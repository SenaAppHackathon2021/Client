package com.app.reart.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.app.reart.R
import com.app.reart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    val listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when(destination.id) {
            R.id.homeFragment -> binding.fab.hide()
            R.id.artBoardFragment -> binding.fab.show()
            R.id.materialBoardFragment -> binding.fab.show()
            R.id.myPageFragment -> binding.fab.hide()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Reart)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.artBoardFragment,
                R.id.materialBoardFragment,
                R.id.myPageFragment
            )
        )

        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(listener)
        super.onPause()
    }

    override fun onNavigateUp(): Boolean = navController.navigateUp() || super.onNavigateUp()
}