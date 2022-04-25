package com.example.rickandmorty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.rickandmorty.data.model.CharactersModel
import com.example.rickandmorty.network.RetroInstance
import com.example.rickandmorty.network.RetrofitInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class CharacterGroupingActivityViewModel: ViewModel() {
        private var liveCharacterDataList: MutableLiveData<List<CharactersModel>>

        init {
            liveCharacterDataList = MutableLiveData()
        }

        fun getLiveDataObserver(): LiveData<List<CharactersModel>> {
            return liveCharacterDataList
        }

        fun makeGroupCall(case:Int){
            viewModelScope.launch(Dispatchers.IO) {
                val retroInstance = RetroInstance.getRetroInstance().create(RetrofitInterface::class.java)
                try {
                    when(case){
                        1 -> {
                            val response = retroInstance.getAliveStatus().body()
                            val listResponse = response?.result
                            //Log.d("GroupByAlive",listResponse.toString())
                            liveCharacterDataList.postValue(listResponse)
                        }
                        2 -> {
                            val response = retroInstance.getDeadStatus().body()
                            val listResponse = response?.result
                            //Log.d("GroupByDead",listResponse.toString())
                            liveCharacterDataList.postValue(listResponse)
                        }
                        3 -> {
                            val response = retroInstance.getUnknownStatus().body()
                            val listResponse = response?.result
                            //Log.d("GroupByUnknown",listResponse.toString())
                            liveCharacterDataList.postValue(listResponse)
                        }
                        4 -> {
                            val response = retroInstance.getHumanSpecies().body()
                            val listResponse = response?.result
                            //Log.d("GroupByHuman",listResponse.toString())
                            liveCharacterDataList.postValue(listResponse)
                        }
                        5 -> {
                            val response = retroInstance.getAlienSpecies().body()
                            val listResponse = response?.result
                            //Log.d("GroupByAlien",listResponse.toString())
                            liveCharacterDataList.postValue(listResponse)
                        }
                    }
                }
                catch (e: IOException){
                    Log.d("IOException","IOException")
                }catch (e: HttpException){
                    Log.d("HttpException","HTTPException")
                }
            }
        }

    }
