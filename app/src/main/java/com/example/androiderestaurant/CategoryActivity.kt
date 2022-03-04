package com.example.androiderestaurant

import android.net.wifi.aware.AwareResources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryActivity : AppCompatActivity() {
    lateinit var myRecycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val extra = intent.getStringExtra("12345")
        setTitle(extra)
        val category :List<Category> = when (extra){
            "Entrées"->{resources.getStringArray(R.array.starters).map {
                Category(it) }}
            "Plats"->{resources.getStringArray(R.array.dishes).map {
                Category(it) }}
            "Desserts"->{resources.getStringArray(R.array.deserts).map {
                Category(it) }}
            else -> {
                emptyList()
            }
        }
        myRecycler = findViewById(R.id.CategoryList)
        myRecycler.layoutManager = LinearLayoutManager(this)
        myRecycler.adapter = CategoryAdapter(category.toTypedArray()){
            Toast.makeText(this,"Vous avez selectionné ${it.nom}", Toast.LENGTH_SHORT).show()
        }


        val content = findViewById<RecyclerView>(R.id.CategoryList)
    }
}
