package com.gsl.shoecollection.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.gsl.shoecollection.databinding.ViewholderRecommendedBinding
import com.gsl.shoecollection.model.ItemsModel

class PopularAdapter(val items: MutableList<ItemsModel>):
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private var context: Context ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderRecommendedBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
        holder.binding.titleText.text = items[position].title
        holder.binding.priceText.text = "$"+items[position].price.toString()
        holder.binding.ratingText.text = items[position].rating.toString()

        val requestOptions = RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .apply(requestOptions)
            .into(holder.binding.pic)

       /* holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, )
        }*/
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewholderRecommendedBinding): RecyclerView.ViewHolder(binding.root)
}