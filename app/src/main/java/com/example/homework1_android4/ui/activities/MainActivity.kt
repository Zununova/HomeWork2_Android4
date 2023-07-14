package com.example.homework1_android4.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework1_android4.R
import com.example.homework1_android4.databinding.ActivityMainBinding
import com.example.homework1_android4.utils.PreferenceHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var navController: NavController

    override fun onStart() {
        super.onStart()
        initialize()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }

    private fun initialize() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
        val check = preferenceHelper.saveBoolean
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        if (check == false) {
            val navGraph = navController.navInflater.inflate(R.navigation.main_graph)
            navGraph.setStartDestination(R.id.registerFragment)
            navController.graph = navGraph

        }
    }
}