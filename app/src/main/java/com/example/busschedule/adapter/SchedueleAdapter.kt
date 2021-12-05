package com.example.busschedule.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.busschedule.databinding.ActivityMainBinding
import com.example.busschedule.databinding.BusStopItemBinding
import com.example.busschedule.db.Schedule
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter.ofLocalizedTime
import java.util.*
import kotlin.time.times

class SchedueleAdapter(private  val  onItemClick : (Schedule) -> Unit ) : ListAdapter<Schedule , SchedueleAdapter.ScheduleViewHolder>(DiffCallBack) {



    class ScheduleViewHolder (val binding: BusStopItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(name :Schedule){
            binding.stopNameTextView.text = name.stopName
            binding.arrivalTimeTextView.text = SimpleDateFormat("h:mm a").format(Date(name.arrivalTime.toLong() *1000))

        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val itemBinding = BusStopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
         holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            onItemClick(getItem(position))
        }

    }


    object DiffCallBack: DiffUtil.ItemCallback<Schedule>(){
        override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem == newItem
        }
        override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem.id == newItem.id
        }
    }


}

