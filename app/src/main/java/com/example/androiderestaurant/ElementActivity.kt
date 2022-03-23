package com.example.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextClock
import android.widget.TextView
import com.example.androiderestaurant.databinding.ActivityElementBinding
import model.Items
import androidx.viewpager2.widget.ViewPager2

class ElementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityElementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityElementBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val intent=intent
        val item = intent.getSerializableExtra(CategoryActivity.DETAILS_KEY) as Items
        binding.elementTitle.text = item.name_fr
        binding.elementDetails.text = item.ingredients.joinToString(", ", transform = { it.name_fr })
        binding.elementPrice.text = item.prices[0].price + "€"
        binding.viewSlider.adapter=FragmentAdapter(this,item.images)


        //Log.i("image", item.images.toString())
        /*setContentView(R.layout.activity_element)
        val textView = findViewById<TextView>(R.id.ElementDetails).apply{}
        val extra = intent.getStringExtra("12345")
        Log.d("ElementActivity",extra ?: "ko")
        when (extra){
            "Soupe miso" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_miso))
            }
            "Salade de chou" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_chou))
            }
            "Sashimi" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_sashimi))
            }
            "Sushi" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_sushi))
            }
            "Poke Bowl" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_poke))
            }
            "Chirachi" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_chirachi))
            }
            "Dumburi" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_dumburi))
            }
            "Mochi" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_mochi))
            }
            "Litchi" -> {
                findViewById<TextView>(R.id.ElementTitle).text=extra
                findViewById<TextView>(R.id.ElementDetails).text=(resources.getString(R.string.details_litchi))
            }
            else -> {
                null
            }
        }

    }*/
    }
}
