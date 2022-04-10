package com.example.timetableapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.timetableapp.databinding.FragmentInfoBinding
import com.example.timetableapp.databinding.FragmentInformationBinding


class InformationFragment : Fragment() {
    lateinit var binding: FragmentInformationBinding
    //link to the viewModel
    private val viewModel:ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate<FragmentInformationBinding>(inflater,
            R.layout.fragment_information,container,false)

        //Need to setup the information for all the classes
        viewModel.setClassInfo()
        val tv = binding.textviewDetail
        //Get which class was actuallySelected from the viewModel and update accordingly
        val selectedClass = viewModel.selectedClass
        if(selectedClass == "CSCI 6101")
        {
            tv.text = viewModel.class6101.toString()
        }

        else if(selectedClass == "CSCI 6212")
        {
            tv.text = viewModel.class6212.toString()
        }

        else if(selectedClass == "CSCI 6221")
        {
            tv.text = viewModel.class6221.toString()
        }

        else if(selectedClass == "CSCI 6231")
        {
            val textInfo = viewModel.class6231.toString()
            tv.text = textInfo
            Log.i("Class info", "$textInfo")
        }

        else if(selectedClass == "CSCI 6232")
        {
            tv.text = viewModel.class6232.toString()
        }

        else
        {
            tv.text = ""
        }

        //To control the action of the back button
        val backButton = binding.buttonBack
        backButton.setOnClickListener{view:View->
            clickHandlerFunction(view,backButton)
        }

        //reset the selectedClass
        viewModel.selectedClass = ""

        return binding.root
    }

    //This function navigates to the InformationFragment
    private fun clickHandlerFunction( view:View, btn: Button)
    {
        val currentScore = 10
//        val action = RemoveFragmentDirections.actionRemoveFragmentToScheduleFragment(currentScore)
        val action =InformationFragmentDirections.actionInformationFragmentToScheduleFragment()
        view.findNavController().navigate(action)

    }


}