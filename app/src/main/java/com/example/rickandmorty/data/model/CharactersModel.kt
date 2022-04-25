package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharactersModel(
    @SerializedName("name") val characterName:String?,
    @SerializedName("status") val characterStatus:String?,
    @SerializedName("species") val characterSpecies:String?,
    @SerializedName("type") val characterType:String?,
    @SerializedName("gender") val characterGender:String?,
    @SerializedName("location") val characterLocation: CharacterLocationModel?,
    @SerializedName("image") val imageCharacter:String?,
    @SerializedName("episode") val characterEpisodesList:ArrayList<String>,
    val characterEpisodesNumber:Int= characterEpisodesList.size
)
