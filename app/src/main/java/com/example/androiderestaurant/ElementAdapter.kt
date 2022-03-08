package com.example.androiderestaurant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

data class Recettes (val detail: String)
//TODO EN gros l'idée est de faire la même chose que category en faisant des items
/*
class ElementAdapter (val RecetteDisplay: Array<Category>, val listener: (Category) -> Unit)
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
        holder.itemFood.text = RecetteDisplay[position].nom
        holder.itemView.setOnClickListener{ listener(RecetteDisplay[position])}
    }

    override fun getItemCount(): Int = RecetteDisplay.size
    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }/
}

     */