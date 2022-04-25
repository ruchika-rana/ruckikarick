package com.example.rickandmorty.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.model.CharactersModel
import com.example.rickandmorty.databinding.CharacterListBinding


class CharacterAdapter(
    var clickListener:onCharacterListClick
):PagingDataAdapter<CharactersModel,CharacterAdapter.characterViewHolder>(DiffUtilCallBack()) {
    inner class characterViewHolder(var binding: CharacterListBinding):
            RecyclerView.ViewHolder(binding.root){
                fun dataBinding(characterData:CharactersModel,action:onCharacterListClick){
                    Log.d("AdapterRU",characterData.imageCharacter.toString())
                    binding.titleTextView.text = characterData.characterName
                    binding.descriptionTextView.text = characterData.characterSpecies
                    Glide.with(binding.displayImageView)
                        .load(characterData.imageCharacter)
                        .centerCrop()
                        .into(binding.displayImageView)
                    binding.root.setOnClickListener {
                        action.onCharacterClick(characterData,absoluteAdapterPosition)
                    }
                }
            }
    /*fun updateCharacterDataList(characterData:PagingData<CharactersModel>)
    {
        val data = characterData as List<CharactersModel>
        characterDataList.clear()
        characterDataList.addAll(data)
        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): characterViewHolder {
        var view = LayoutInflater.from(parent.context)
        val binding = CharacterListBinding.inflate(view,parent,false)
        return characterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: characterViewHolder, position: Int) {
        //holder.dataBinding(characterDataList[position])
        holder.dataBinding(getItem(position)!!,clickListener)
    }


}
interface onCharacterListClick{
    fun onCharacterClick(item:CharactersModel,position: Int)
}


