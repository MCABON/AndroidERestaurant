package com.example.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(activity: AppCompatActivity, private val image :List<String>) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return image.size
    }

    override fun createFragment(position: Int): Fragment {
        return  ImageFragment(image[position].ifEmpty { null })
    }
}