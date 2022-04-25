package com.example.rickandmorty.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.model.CharactersModel
import com.example.rickandmorty.databinding.CharacterListBinding

class CharacterAdapterSecond (
        val characterDataList:ArrayList<CharactersModel>): RecyclerView.Adapter<CharacterAdapterSecond.characterHolder>() {
        inner class characterHolder(val binding: CharacterListBinding):
            RecyclerView.ViewHolder(binding.root) {
            fun dataBinding(characterData: CharactersModel) {
                binding.titleTextView.text = characterData.characterName
                binding.descriptionTextView.text = characterData.characterSpecies
                Glide.with(binding.displayImageView)
                    .load(characterData.imageCharacter)
                    .centerCrop()
                    .into(binding.displayImageView)
            }
        }
        fun updateCharacterDataList(characterData:List<CharactersModel>){
            characterDataList.clear()
            characterDataList.addAll(characterData)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): characterHolder {
            var view = LayoutInflater.from(parent.context)
            val binding = CharacterListBinding.inflate(view,parent,false)
            return characterHolder(binding)
        }

        override fun onBindViewHolder(holder: characterHolder, position: Int) {
            //holder.dataBinding(characterDataList[position])
            holder.dataBinding(characterDataList.get(position))
        }

        override fun getItemCount(): Int {
            return characterDataList.size
        }

    }

