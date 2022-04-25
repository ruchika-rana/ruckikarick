package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharacterInfoModel(
    @SerializedName("count") val count:Int,
    @SerializedName("pages") val pages:Int,
    @SerializedName("next") val next:String?,
    @SerializedName("prev") val prev:String?
)
