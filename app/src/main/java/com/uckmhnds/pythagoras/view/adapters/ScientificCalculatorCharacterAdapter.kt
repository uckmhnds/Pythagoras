package com.uckmhnds.pythagoras.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.uckmhnds.pythagoras.databinding.ScientificCalculatorTextBinding

class ScientificCalculatorCharacterAdapter
    (
    private val activity: FragmentActivity?,
    private val listItems : Array<String>
)
    : RecyclerView.Adapter<ScientificCalculatorCharacterAdapter.ViewHolder>(){


    class ViewHolder (view: ScientificCalculatorTextBinding): RecyclerView.ViewHolder(view.root){
        val tvText          = view.scientificCalcTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding : ScientificCalculatorTextBinding = ScientificCalculatorTextBinding.inflate(LayoutInflater.from(activity), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item            = listItems[position]
        holder.tvText.text  = item
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}
