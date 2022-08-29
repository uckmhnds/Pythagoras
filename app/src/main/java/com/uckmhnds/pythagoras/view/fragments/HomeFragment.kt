package com.uckmhnds.pythagoras.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.uckmhnds.pythagoras.R
import com.uckmhnds.pythagoras.databinding.FragmentHomeBinding

class HomeFragment:Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get()       = _binding!!
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController                   = Navigation.findNavController(view)

        binding.cvScientificCalculate.setOnClickListener(this)
        binding.cvScientificCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        if (view != null)
        {
            when(view.id){

                R.id.cv_scientific_calculate -> {
                    navController.navigate(R.id.action_navigate_to_scientific_calculator)
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}