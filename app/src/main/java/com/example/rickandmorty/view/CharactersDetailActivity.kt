package com.example.rickandmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.rickandmorty.DataBinderMapperImpl
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityCharactersDetailBinding

class CharactersDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityCharactersDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_characters_detail)
        val intent=intent
        binding.detailTitleTextView.text=intent.getStringExtra("name")
        binding.detailDescriptionTextView.text=intent.getStringExtra("species")
        binding.detailLocationTextView.text=intent.getStringExtra("location")
        binding.detailTypeTextView.text=intent.getStringExtra("type")
        binding.detailGenderTextView.text=intent.getStringExtra("gender")
        binding.detailImageView.setImage(intent.getStringExtra("image").toString())

    }
}