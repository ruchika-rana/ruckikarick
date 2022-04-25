package com.example.rickandmorty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
//import com.example.rickandmorty.data.model.CharacterDetailsModel
import com.example.rickandmorty.data.model.CharactersModel
import com.example.rickandmorty.data.remote.Repository
import com.example.rickandmorty.network.RetroInstance
import com.example.rickandmorty.network.RetrofitInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CharacterViewModel():ViewModel() {
    lateinit var retrofitInterface: RetrofitInterface
    init {
        retrofitInterface = RetroInstance.getRetroInstance().create(RetrofitInterface::class.java)
    }

    fun getData(): Flow<PagingData<CharactersModel>>{
        return Pager(config= PagingConfig(20,maxSize = 200),
        pagingSourceFactory = {Repository(retrofitInterface)}).flow.cachedIn(viewModelScope)
    }
}