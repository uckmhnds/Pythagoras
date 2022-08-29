package com.uckmhnds.pythagoras.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.uckmhnds.pythagoras.databinding.RecentCardBinding
import com.uckmhnds.pythagoras.model.entities.RecentAction

class RecentActionAdapter    (
    private val activity: FragmentActivity?,
    private val recentActions : List<RecentAction>
): RecyclerView.Adapter<RecentActionAdapter.ViewHolder>() {

    var onCardClick: ((RecentAction) -> Unit)? = null
    var onDeleteClick: ((RecentAction) -> Unit)? = null

    inner class ViewHolder (view: RecentCardBinding): RecyclerView.ViewHolder(view.root){

        val tvRecentCardAction      = view.tvRecentCardAction
        val ivRecentAction          = view.ivRecentAction
        val tvRecentCardDate        = view.tvRecentCardDate
        val tvRecentCardTime        = view.tvRecentCardTime
        val tvRecentCardActionDtl   = view.tvRecentCardActionDetail
        val vTemp                   = view.vTemp
        val ivDelete                = view.ivDelete

        // Set onClickListeners

        init {

            view.cv.setOnClickListener { onCardClick?.invoke(recentActions[adapterPosition]) }

            view.ivDelete.setOnClickListener { onDeleteClick?.invoke(recentActions[adapterPosition]) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding : RecentCardBinding = RecentCardBinding.inflate(LayoutInflater.from(activity), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recentAction                    = recentActions[position]


        holder.ivRecentAction.setImageResource(recentAction.icon)

        holder.tvRecentCardAction.text      = recentAction.action
        holder.tvRecentCardActionDtl.text   = recentAction.actionDetail
        holder.tvRecentCardDate.text        = recentAction.date
        holder.tvRecentCardTime.text        = recentAction.time

        if (recentAction.expand)
        {

            holder.tvRecentCardActionDtl.visibility = View.VISIBLE
            holder.vTemp.visibility                 = View.VISIBLE
            holder.ivDelete.visibility              = View.VISIBLE

        }
        else{

            holder.tvRecentCardActionDtl.visibility = View.GONE
            holder.vTemp.visibility                 = View.GONE
            holder.ivDelete.visibility              = View.GONE

        }


    }

    override fun getItemCount(): Int {
        return recentActions.size
    }

}


