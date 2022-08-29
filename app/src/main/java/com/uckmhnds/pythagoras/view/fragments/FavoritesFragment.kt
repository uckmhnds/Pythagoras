package com.uckmhnds.pythagoras.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uckmhnds.pythagoras.databinding.FragmentFavoritesBinding

class FavoritesFragment: Fragment(), View.OnClickListener {

    private var _binding: FragmentFavoritesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get()                       = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding             = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View       = binding.root

        return root

    }

    override fun onClick(v: View?) {
        Log.i("Typed", "You typed")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}