package com.example.androiderestaurant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.example.androiderestaurant.databinding.FragmentImageBinding

class ImageFragment(val url:String?) :Fragment() {

    private lateinit var binding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(url).placeholder(R.drawable.logodishes).into(binding.imageDishes)
    }












   /* private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(ARG_PARAM)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_image, container, false)
        url = url.takeIf { it != "" }
        Picasso.get().load(url).placeholder(R.drawable.dishes).into(view.findViewById(R.id.imageDishes) as ImageView)
        Log.d("CFOCV00", "$url" )
        return view
    }

    companion object {
        fun newInstance(url: String) =
            ImageFragment().apply {
                Log.d("CFOCV01", "$url" )
                arguments = Bundle().apply {
                    putString(ARG_PARAM, url)
                }
            }
    }*/
}