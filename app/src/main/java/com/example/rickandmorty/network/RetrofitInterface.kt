package com.example.rickandmorty.network

//import com.example.rickandmorty.data.model.ApiResultModel
import com.example.rickandmorty.data.model.CharacterResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("character")
    suspend fun getAPI(@Query("page")query:Int):CharacterResultModel

    @GET("character/?status=alive")
    suspend fun getAliveStatus():Response<CharacterResultModel>

    @GET("character/?status=dead")
    suspend fun getDeadStatus():Response<CharacterResultModel>

    @GET("character/?status=unknown")
    suspend fun getUnknownStatus():Response<CharacterResultModel>

    @GET("character/?species=human")
    suspend fun getHumanSpecies():Response<CharacterResultModel>

    @GET("character/?species=alien")
    suspend fun getAlienSpecies():Response<CharacterResultModel>
}