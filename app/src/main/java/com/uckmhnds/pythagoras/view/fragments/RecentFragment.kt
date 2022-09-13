package com.uckmhnds.pythagoras.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uckmhnds.pythagoras.R
import com.uckmhnds.pythagoras.application.PythagorasApplication
import com.uckmhnds.pythagoras.databinding.FragmentRecentBinding
import com.uckmhnds.pythagoras.model.entities.RecentAction
import com.uckmhnds.pythagoras.view.adapters.RecentActionAdapter
import com.uckmhnds.pythagoras.viewmodel.RecentViewModel
import com.uckmhnds.pythagoras.viewmodel.RecentViewModelFactory
import java.util.*

class RecentFragment: Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRecentBinding

    private lateinit var recyclerview: RecyclerView

    private lateinit var adapter: RecentActionAdapter

    private val recentViewModel: RecentViewModel by viewModels {
        RecentViewModelFactory((requireActivity().application as PythagorasApplication).repository)
    }

    private lateinit var calendar: Calendar

    private var icon: Int       = R.drawable.plot_icon

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding                 = FragmentRecentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.btnRecentInsert.setOnClickListener(this)
        binding.btnRecentDelete.setOnClickListener(this)

        recyclerview                    = binding.rvRecent

        recyclerview.layoutManager      = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recentViewModel.recentActions.observe(viewLifecycleOwner){

            adapter                         = RecentActionAdapter(activity, it)
            recyclerview.adapter            = adapter

            adapter.onCardClick             = { item ->

                val expand                  = !item.expand

                item.expand                 = expand

                // Update the item
                recentViewModel.insert(item)

            }

            adapter.onDeleteClick           = { item ->

                // Update the item
                recentViewModel.delete(item)

            }
        }

    }

    override fun onClick(v: View?) {


        if (v!=null){

            when(v.id){

                R.id.btn_recent_insert -> {

                    val anAction                = RecentAction(0, "test", "this a test", getDate(), getTime(), icon, false)

                    insetToDB(anAction)

                }

                R.id.btn_recent_delete -> {

                    deleteDB()

                }
            }

        }

    }

    private fun insetToDB(recentAction: RecentAction){

        recentViewModel.insert(recentAction)

    }

    private fun removeFromDB(recentAction: RecentAction){

        recentViewModel.delete(recentAction)

    }

    private fun deleteDB(){

        recentViewModel.deleteAll()

    }

    private fun getDate(): String{

        calendar                    = Calendar.getInstance()

        val year                    = calendar.get(Calendar.YEAR)
        val month                   = calendar.get(Calendar.MONTH)
        val day                     = calendar.get(Calendar.DAY_OF_MONTH)

        return "${day}/${month}/${year}"
    }

    private fun getTime(): String{

        calendar                    = Calendar.getInstance()

        val hour                    = calendar.get(Calendar.HOUR_OF_DAY)
        val minute                  = calendar.get(Calendar.MINUTE)
        val second                  = calendar.get(Calendar.SECOND)

        var hourString              = ""
        var minuteString            = ""
        var secondString            = ""

        hourString = if (hour < 10){
            "0${hour}"
        } else{
            "$hour"
        }
        minuteString = if (minute < 10){
            "0${minute}"
        } else{
            "$minute"
        }
        secondString = if (second < 10){
            "0${second}"
        } else{
            "$second"
        }

        return "$hourString:$minuteString:$secondString"

    }


}
