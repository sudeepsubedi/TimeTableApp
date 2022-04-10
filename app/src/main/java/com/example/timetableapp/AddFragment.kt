package com.example.timetableapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.timetableapp.databinding.FragmentAddBinding



class AddFragment: Fragment() {
    var name:String = ""
    val args:AddFragmentArgs by navArgs()

    var counter:Int = 0;

    //link to the viewModel
    private val viewModel:ItemViewModel by activityViewModels()

    init
    {
        Log.i("AddFragement", "Add Fragment is called")
    }

    //lateinit var binding:FragmentAddBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding:FragmentAddBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add,
            container,
            false)
        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button

        setHasOptionsMenu(true)

        val myScore = args.score
        val class1Btn = binding.class1
        val class2Btn = binding.class2
        val class3Btn = binding.class3
        val class4Btn = binding.class4
        val class5Btn = binding.class5
        val doneBtn = binding.doneButton
        val removeBtn = binding.removeButton



        //Step 2: Call the clickHandlerFunction
        class1Btn.setOnClickListener{view : View ->

            viewModel.chosenClasses.add(class1Btn.text.toString())
            viewModel.addToChosenObjects(class1Btn.text.toString())

        }

        //Step 2: Call the clickHandlerFunction
        class2Btn.setOnClickListener{view : View ->
                //add classes to the listOfChosenClasses
                viewModel.chosenClasses.add(class2Btn.text.toString())
                viewModel.addToChosenObjects(class2Btn.text.toString())
        }

        class3Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.chosenClasses.add(class3Btn.text.toString())
            viewModel.addToChosenObjects(class3Btn.text.toString())
        }

        class4Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.chosenClasses.add(class4Btn.text.toString())
            viewModel.addToChosenObjects(class4Btn.text.toString())
            if(!viewModel.addSuccess)
            {
                Toast.makeText(activity, "Time conflict with another class", Toast.LENGTH_SHORT).show()
            }
            viewModel.addSuccess = true
        }

        class5Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.chosenClasses.add(class5Btn.text.toString())
            viewModel.addToChosenObjects(class5Btn.text.toString())

            if(!viewModel.addSuccess)
            {
                Toast.makeText(activity, "Time conflict with another class", Toast.LENGTH_SHORT).show()
            }
            viewModel.addSuccess = true
        }

        doneBtn.setOnClickListener{view : View ->
                //Navigate to the timetable
                clickHandlerFunction(view,doneBtn)
        }

        removeBtn.setOnClickListener{view : View ->
            //Navigate to the timetable
            clickHandlerFunction(view,removeBtn)
        }




        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }



    private fun clickHandlerFunction( view:View, btn:TextView)
    {
        val btnText = btn.text.toString()
        //for Done button
        if(btnText =="DONE")
        {
            val currentScore = 10
            val action = AddFragmentDirections.actionAddFragmentToScheduleFragment(currentScore)

            //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
            view.findNavController().navigate(action)
        }

        //for Edit button
        else if(btnText == "EDIT")
        {
            val action = AddFragmentDirections.actionAddFragmentToRemoveFragment()
            view.findNavController().navigate(action)
        }

        else if(btnText == "Class Info")
        {
            val action = AddFragmentDirections.actionAddFragmentToInfoFragment()
            view.findNavController().navigate(action)
        }

        else
        {
            Log.i("Add Fragment","Click Handler Function has error.Fix it")
        }

    }
}