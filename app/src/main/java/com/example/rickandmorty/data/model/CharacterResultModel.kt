package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResultModel(
    @SerializedName("info") val info: CharacterInfoModel,
    @SerializedName("results") val result: List<CharactersModel>
)