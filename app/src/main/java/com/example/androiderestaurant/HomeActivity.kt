package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "L'activité est détruite")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val button1 = findViewById<Button>(R.id.starters)
        button1.setOnClickListener { startCategory(getString(R.string.home_starters)) }
        //button1.setOnClickListener { Toast.makeText(this,"You clicked Entrée", Toast.LENGTH_SHORT).show()}
        val button2 = findViewById<Button>(R.id.dishes)
        button2.setOnClickListener { startCategory(getString(R.string.home_dishes)) }
        val button3 = findViewById<Button>(R.id.deserts)
        button3.setOnClickListener {
            startCategory(getString(R.string.home_deserts))
        }
    }

    fun sendMessage(button: Button) {
        val message = button.text.toString()
        startCategory(message)
    }

    private fun startCategory(message: String) {
        val intent = Intent(this, CategoryActivity::class.java).apply {
            putExtra(CATEGORY_KEY, message)
        }
        startActivity(intent)
    }
    companion object{
        const val CATEGORY_KEY = "category"
    }
}