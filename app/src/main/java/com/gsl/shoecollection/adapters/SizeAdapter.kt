package com.gsl.shoecollection.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gsl.shoecollection.R
import com.gsl.shoecollection.databinding.ViewholderColorBinding
import com.gsl.shoecollection.databinding.ViewholderSizeBinding

class SizeAdapter(val items: MutableList<String>):
    RecyclerView.Adapter<SizeAdapter.ViewHolder>() {

    private var lastSelectedPosition = -1
    private var selectedPosition = -1
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderSizeBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SizeAdapter.ViewHolder, position: Int) {

        holder.binding.sizeText.text = items[position]

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }


        if (selectedPosition == position) {
            holder.binding.sizeLayout.setBackgroundResource(R.drawable.grey_bg_selected)
            holder.binding.sizeText.setTextColor(context.resources.getColor(R.color.purple))
        }else {
            holder.binding.sizeLayout.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.sizeText.setTextColor(context.resources.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewholderSizeBinding):
        RecyclerView.ViewHolder(binding.root){
    }
}