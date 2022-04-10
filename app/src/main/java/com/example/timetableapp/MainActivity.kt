package com.example.timetableapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.timetableapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

//import com.example.timetableapp.MyClass as MyClass1

class MainActivity : AppCompatActivity()
{
    private lateinit var viewModel: ItemViewModel
    private lateinit var binding: ActivityMainBinding
    var classList:MutableList<MyClass> = mutableListOf<MyClass>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        viewModel.addClasses()
        viewModel.printClassInfo()
        viewModel.setClassInfo()

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    /**
     * This is for adding the back button
     */
    override fun onSupportNavigateUp():Boolean{
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()

    }




}