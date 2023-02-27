package com.example.exam

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.DetailInterface
import com.example.exam.databinding.RecyclerViewItemBinding

class DashboardAdapter(
    val dashboardDataClass: List<DashboardDataClass>,
    val detailInterface: DetailInterface

):RecyclerView.Adapter<DashboardAdapter.DashboardMainViewHolder>() {


    inner class DashboardMainViewHolder(val itemBinding: RecyclerViewItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        val cardView: CardView = itemView.findViewById(R.id.cardView)
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
        holder.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, RewardsActivity::class.java)
            intent.putExtra("caption", task.caption)
            intent.putExtra("image", task.image)
            intent.putExtra("description", task.description)
            intent.putExtra("task", task)

            holder.itemView.context.startActivity(intent)
        }

        holder.cardView.setOnClickListener {
            detailInterface.getDetail(task.image, task.caption, task.description)
        }

    }

//    class PersonViewHolder(private val binding: ItemPersonBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(person: Person) {
//            binding.apply {
//                Glide.with(itemView)
//                    .load(person.picture.thumbnail)
//                    .circleCrop()
//                    .into(ivPersonImage)
//
//                tvPersonName.text = "${person.name.first} ${person.name.last}"
//
//                tvPersonEmailAddress.text = person.email
//            }
//        }
//    }

    override fun getItemCount(): Int {
        return dashboardDataClass.size
    }






}