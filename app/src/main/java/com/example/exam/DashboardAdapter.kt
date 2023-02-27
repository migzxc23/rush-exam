package com.example.exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.RecyclerViewItemBinding

class DashboardAdapter(val dashboardDataClass: List<DashboardDataClass>):RecyclerView.Adapter<DashboardAdapter.DashboardMainViewHolder>() {


    inner class DashboardMainViewHolder(val itemBinding: RecyclerViewItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun itemBind(dashDataClass: DashboardDataClass){
            itemBinding.bottomText.text = dashDataClass.caption
            itemBinding.imageView.setImageResource(dashDataClass.image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardMainViewHolder {
        return DashboardMainViewHolder(RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DashboardMainViewHolder, position: Int) {
        val task = dashboardDataClass[position]
        holder.itemBind(task)
    }

    override fun getItemCount(): Int {
        return dashboardDataClass.size
    }



}