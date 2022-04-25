package com.example.rickandmorty.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroInstance {
    companion object{
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val retro:RetrofitInterface = getRetroInstance().create(RetrofitInterface::class.java)
    }
}