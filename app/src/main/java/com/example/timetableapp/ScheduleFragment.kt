package com.example.timetableapp


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI

import com.example.timetableapp.databinding.FragmentScheduleBinding
import kotlinx.android.synthetic.main.fragment_schedule.*


class ScheduleFragment : Fragment() {

    //reference to the ItemViewModel
    private  val  viewModel: ItemViewModel by activityViewModels()
    lateinit var binding: FragmentScheduleBinding
    private var viewModelCounter:Int = 0;
    val args:ScheduleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ShceduleFragment","Schedule Fragment is called")
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentScheduleBinding>(inflater,
            R.layout.fragment_schedule,container,false)

        val descriptionButton = binding.descriptionBtn
        //update this fragment's content
        val size = viewModel.chosenClassObjects.size
        if(size > 0)
        {
            for(item in viewModel.chosenClassObjects)
            {
                displayInfo(item)

            }
        }

        val mon = binding.mon2
        val wed = binding.wed3
        val thur = binding.thu3
        val fri = binding.fri1

        mon.setOnClickListener { view:View->
            val classCSCI = mon.text.toString().substring(0,9)
            viewModel.selectedClass = classCSCI
            val text = viewModel.selectedClass
            Toast.makeText(activity,"$classCSCI",Toast.LENGTH_SHORT).show()
        }

        wed.setOnClickListener { view:View->
            val classCSCI = wed.text.toString().substring(0,9)
            viewModel.selectedClass = classCSCI
        }

        thur.setOnClickListener { view:View->
            val classCSCI = thur.text.toString().substring(0,9)
            viewModel.selectedClass = classCSCI
        }

        fri.setOnClickListener { view:View->
            val classCSCI = fri.text.toString().substring(0,9)
            viewModel.selectedClass = classCSCI
        }



        descriptionButton.setOnClickListener{view : View ->
            //Navigate to the description page
            clickHandlerFunction(view,descriptionBtn)
        }

        //onClickHandler for the items on ScheduleFragment

        Log.i("ScheduleFragment","Size is: $size")
        return binding.root

    }

    //This function navigates to the InformationFragment
    private fun clickHandlerFunction( view:View, btn: Button)
    {
        val currentScore = 10
//        val action = RemoveFragmentDirections.actionRemoveFragmentToScheduleFragment(currentScore)
        val action =ScheduleFragmentDirections.actionScheduleFragmentToInformationFragment()
        view.findNavController().navigate(action)

    }


    private fun displayInfo(item:MyClass)
    {
        var startTime:Int = item.startTime.toInt()
        var endTime:Int = item.endTime.toInt()
        var day:String = item.day.toLowerCase()
        //val btnMon1 = binding.wed1
        lateinit var btn: TextView

        if(day == "monday")
        {

            if(startTime < 1200)
            {
                //btn 1
                btn = binding.mon1
            }

            else if(startTime>=1200 && endTime< 1600)
            {
                //btn2
                btn = binding.mon2
            }

            else if(startTime>=1600 && endTime <2100)
            {
                //btn3
                btn = binding.mon3
            }

            else
            {
                btn = binding.mon4
            }

        }

        else if(day == "tuesday")
        {

            if(startTime < 1200)
            {
                //btn 1
                btn = binding.tue1
            }

            else if(startTime>=1200 && endTime< 1600)
            {
                //btn2
                btn = binding.tue2
            }

            else if(startTime>=1600 && endTime <2100)
            {
                //btn3
                btn = binding.tue3
            }

            else
            {
                btn = binding.tue4
            }

        }

        else if(day == "wednesday")
        {

            if(startTime < 1200)
            {
                //btn 1
                btn = binding.wed1
            }

            else if(startTime>=1200 && endTime< 1600)
            {
                //btn2
                btn = binding.wed2
            }

            else if(startTime>=1600 && endTime <2100)
            {
                //btn3
                btn = binding.wed3
            }

            else
            {
                btn = binding.wed4
            }

        }

        else if(day == "thursday")
        {

            if(startTime < 1200)
            {
                //btn 1
                btn = binding.thu1
            }

            else if(startTime>=1200 && endTime< 1600)
            {
                //btn2
                btn = binding.thu2
            }

            else if(startTime>=1600 && endTime <2100)
            {
                //btn3
                btn = binding.thu3
            }

            else
            {
                btn = binding.thu4
            }

        }

        else //if(day == "friday")
        {

            if(startTime < 1200)
            {
                //btn 1
                btn = binding.fri1
            }

            else if(startTime>=1200 && endTime< 1600)
            {
                //btn2
                btn = binding.fri2
            }

            else
            {
                //btn3
                btn = binding.fri3
            }


        }

        btn.text =  item.csciName  + "\n\n" + item.startTime + "-" + item.endTime
        btn.setBackgroundResource(R.drawable.grid_inside)
    }



    /**
     * Method for handling button click handlers
     */
//    private fun clickHandlerFunction( view:View, btn:TextView)
//    {
//
//        val addedClassName = viewModel.className
//        val action = ScheduleFragmentDirections.actionScheduleFragmentToInfoFragment()
//
//
//        //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
//        view.findNavController().navigate(action)
//    }

}