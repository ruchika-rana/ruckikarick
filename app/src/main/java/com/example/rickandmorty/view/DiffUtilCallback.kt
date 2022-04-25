package com.example.rickandmorty.view

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.data.model.CharactersModel

class DiffUtilCallBack : DiffUtil.ItemCallback<CharactersModel>() {
    override fun areItemsTheSame(oldItem: CharactersModel, newItem: CharactersModel): Boolean {
        return oldItem.characterName == newItem.characterName
    }

    override fun areContentsTheSame(oldItem: CharactersModel, newItem: CharactersModel): Boolean {
        return oldItem.characterName == newItem.characterName &&
                oldItem.characterStatus == newItem.characterSpecies
    }

}
