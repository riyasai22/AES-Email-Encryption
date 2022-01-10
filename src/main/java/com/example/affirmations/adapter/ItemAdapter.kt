package com.example.affirmations.adapter
//adapter binds data to viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
import com.yinglan.shadowimageview.ShadowImageView

//dataset are the list of affirmations
//context is to get string resources from string.xml

//ItemAdapter inherits RecylcerView.Adapter of type ItemAdapter.ItemViewHolder
//ItemViewHolder is a nested class which accepts a view as its parameter from RecyclerView.ViewHolder

class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_title)
        val imageView: ShadowImageView =view.findViewById(R.id.img_affirmation)
    }

    //to link the list_item.xml to the adapter class use LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    //to bind the viewHolder, this is where we write what text should be shown in each position
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.ImageResourceId)
    }

    // gives size of dataset or no. of affirmations
    override fun getItemCount(): Int {
        return dataset.size
    }
}