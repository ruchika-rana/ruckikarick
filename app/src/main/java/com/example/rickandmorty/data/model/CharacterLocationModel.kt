package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharacterLocationModel(
    @SerializedName("name") val locationName:String?,
    @SerializedName("url") val locationUrl:String?
)
