package com.example.timetableapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.timetableapp.databinding.FragmentInfoBinding



class InfoFragment : Fragment()
{
   lateinit var binding:FragmentInfoBinding
    //link to the viewModel
    private val viewModel:ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding= DataBindingUtil.inflate<FragmentInfoBinding>(inflater,
            R.layout.fragment_info,container,false)

        viewModel.setClassInfo()

        val tv1 = binding.textView1
        val tv2 = binding.textView2
        val tv3 = binding.textView3
        //val tv4 = binding. textView4
        //val tv4 = binding.textView5
//        tv1.text = viewModel.classOneInfo
//        tv2.text = viewModel.classTwoInfo
//        tv3.text = viewModel.classThreeInfo
        //tv4.text = viewModel.classFourInfo
        //tv5.text = viewModel.classFiveInfo
        return binding.root
    }


}