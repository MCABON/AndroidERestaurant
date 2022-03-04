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
    class ViewHolder(val element : View) : RecyclerView.ViewHolder(element)
    {
        fun bind(category: Category, listener: (Category) -> Unit) = with(itemView)
        {
            Log.i("XXX","bind")
            itemView.findViewById<TextView>(R.id.ItemFood).text = category.nom
            setOnClickListener{ listener(category)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val maligne = LayoutInflater.from(parent.context).inflate(R.layout.maligne,parent,false)
        return ViewHolder(maligne)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("XXX","onBindViewHolder")
        holder.bind(CategoryAfficher[position],listener)
    }

    override fun getItemCount(): Int = CategoryAfficher.size
}