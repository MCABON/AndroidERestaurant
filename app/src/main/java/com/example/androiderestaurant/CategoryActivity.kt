package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androiderestaurant.databinding.ActivityCategoryBinding
import com.google.gson.Gson
import model.Data
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    //lateinit var myRecycler: RecyclerView
    private lateinit var binding : ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val title = intent.getStringExtra(HomeActivity.CATEGORY_KEY) ?: ""
        binding.CategoryTitle.text = title
        binding.CategoryList.layoutManager = LinearLayoutManager(this)
        binding.CategoryList.adapter = CategoryAdapter(arrayListOf()){}

        //setContentView(R.layout.activity_category)

        /*val extra = intent.getStringExtra("12345")
        val category: List<Category> = when (extra) {
            "Entrées" -> {
                resources.getStringArray(R.array.starters).map {
                    Category(it)
                }
            }
            "Plats" -> {
                resources.getStringArray(R.array.dishes).map {
                    Category(it)
                }
            }
            "Desserts" -> {
                resources.getStringArray(R.array.deserts).map {
                    Category(it)
                }
            }
            else -> {
                emptyList()
            }
        }
        myRecycler = findViewById(R.id.CategoryList)
        myRecycler.layoutManager = LinearLayoutManager(this)
        myRecycler.adapter = CategoryAdapter(category.toTypedArray()) {
            startElement(it.nom)
        }
        val content = findViewById<RecyclerView>(R.id.CategoryList)
        */

        binding.CategoryList.layoutManager = LinearLayoutManager(this)
        binding.CategoryList.adapter = CategoryAdapter(arrayListOf()) {}


        loadItems(title)
    }

    private fun loadItems(category : String) {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val obj = JSONObject()
        obj.put("id_shop", "1")
        val queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, obj,
            { response ->

                Log.d("Response", "$response")
                Log.d("MenuActivity", "Api call success")
                val menu = Gson().fromJson(response.toString(), Data::class.java)
                val items = menu.data.firstOrNull { it.name_fr == category }?.items ?: arrayListOf()

                binding.CategoryList.adapter = CategoryAdapter(items){
                    val newIntent = Intent(this, ElementActivity::class.java)
                    newIntent.putExtra(DETAILS_KEY,it)
                    startActivity(newIntent)
                }
            },
            { error ->

                Log.d("Home_Activity", "Api call failed")
            }
        )
        queue.add(jsonObjectRequest)
    }

    //queue.add(stringRequest)
    /*fun sendMessage(button: Button) {
        val message = button.text.toString()
        startElement(message)
    }

    private fun startElement(message: String) {
            val intent = Intent(this, ElementActivity::class.java).apply {
                putExtra("12345", message)
            }
        startActivity(intent)
    }*/
    companion object {
        const val TITLE_KEY = "title"
        const val DETAILS_KEY = "details"
    }
}
