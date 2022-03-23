package com.example.androiderestaurant

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import model.Items

//data class Category(val nom: String)

class CategoryAdapter(val items: List<Items>, val mListener: (Items) -> Unit)  : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.maligne, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = items[position]
        holder.dishTitle.text = menu.name_fr
        holder.dishPrice.text = menu.prices[0].price
        //holder.dishPrice.text = menu.prices[0].price +"€"
        Picasso.get().load(menu.images[0].ifEmpty { null }).into(holder.imageDish)

        holder.itemView.setOnClickListener {
            mListener(menu)
        }

    }

    override fun getItemCount(): Int = items.size

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageDish: ImageView = itemView.findViewById(R.id.foodImage)
        val dishTitle: TextView = ItemView.findViewById(R.id.itemFood)
        val dishPrice: TextView = ItemView.findViewById(R.id.foodPrice)
    }
}

