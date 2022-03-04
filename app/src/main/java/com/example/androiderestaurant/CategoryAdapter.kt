package com.example.androiderestaurant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Category(val nom: String)

class CategoryAdapter (val CategoryAfficher: Array<Category>, val listener: (Category) -> Unit)
    : RecyclerView.Adapter<CategoryAdapter.ViewHolder>()
{
    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val itemFood = itemView.findViewById<TextView>(R.id.ItemFood)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val maligne = LayoutInflater.from(parent.context).inflate(R.layout.maligne,parent,false)
        return ViewHolder(maligne)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("XXX","onBindViewHolder")
        holder.itemFood.text = CategoryAfficher[position].nom
        holder.itemView.setOnClickListener{ listener(CategoryAfficher[position])}
    }

    override fun getItemCount(): Int = CategoryAfficher.size
}