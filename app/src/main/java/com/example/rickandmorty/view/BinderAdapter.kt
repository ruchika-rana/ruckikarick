package com.example.rickandmorty.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.rickandmorty.R

@BindingAdapter("setImage")
fun ImageView.setImage(image:String?){
    val options = RequestOptions()
    options.placeholder(R.drawable.downloading)
    options.error(R.drawable.error_image)

    Glide.with(this)
        .load(image)
        .apply(options)
        .centerCrop()
        .into(this)
}