package com.example.timetableapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.timetableapp.databinding.FragmentAddBinding
import com.example.timetableapp.databinding.FragmentRemoveBinding


class RemoveFragment : Fragment()
{

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
        val binding: FragmentRemoveBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_remove,
            container,
            false)
        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button

        val myScore = args.score
        val class1Btn = binding.class1
        val class2Btn = binding.class2
        val class3Btn = binding.class3
        val class4Btn = binding.class4
        val class5Btn = binding.class5
        val doneBtn = binding.doneButton



        //Step 2: Call the clickHandlerFunction
        class1Btn.setOnClickListener{view : View ->
            //1. Find the class from chosenClasses and if it exits then remove it

            //2. Remove fromt the list of chosenObjects if removed from the chosenClasses
            viewModel.removeClass(class1Btn.text.toString())
            val successfullyRemoved = viewModel.removalSuccess
            if(!successfullyRemoved)
            {
                Toast.makeText(activity,"Class can't be removed",Toast.LENGTH_SHORT).show()

            }
            viewModel.removalSuccess = true

        }

        //Step 2: Call the clickHandlerFunction
        class2Btn.setOnClickListener{view : View ->
            viewModel.removeClass(class2Btn.text.toString())
            val successfullyRemoved = viewModel.removalSuccess
            if(!successfullyRemoved)
            {
                Toast.makeText(activity,"Class can't be removed",Toast.LENGTH_SHORT).show()
            }
            viewModel.removalSuccess = true
        }

        class3Btn.setOnClickListener{view : View ->
            viewModel.removeClass(class3Btn.text.toString())
            val successfullyRemoved = viewModel.removalSuccess
            if(!successfullyRemoved)
            {
                Toast.makeText(activity,"Class can't be removed",Toast.LENGTH_SHORT).show()
            }
            viewModel.removalSuccess = true
        }

        class4Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.removeClass(class4Btn.text.toString())
            val successfullyRemoved = viewModel.removalSuccess
            if(!successfullyRemoved)
            {
                Toast.makeText(activity,"Class can't be removed",Toast.LENGTH_SHORT).show()
            }
            viewModel.removalSuccess = true
        }

        class5Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.removeClass(class5Btn.text.toString())
            val successfullyRemoved = viewModel.removalSuccess
            if(!successfullyRemoved)
            {
                Toast.makeText(activity,"Class can't be removed",Toast.LENGTH_SHORT).show()
            }
            viewModel.removalSuccess = true
        }

        doneBtn.setOnClickListener{view : View ->
            //Navigate to the timetable
            clickHandlerFunction(view,doneBtn)
        }



        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add, container, false)
    }

    private fun clickHandlerFunction( view:View, btn: Button)
    {
        val btnText = btn.text.toString()
        //for Done button
        if(btnText =="DONE")
        {
            val currentScore = 10
            val action = RemoveFragmentDirections.actionRemoveFragmentToScheduleFragment(currentScore)

            //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
            view.findNavController().navigate(action)
        }



        else
        {
            Log.i("Add Fragment","Click Handler Function has error.Fix it")
        }

    }
}