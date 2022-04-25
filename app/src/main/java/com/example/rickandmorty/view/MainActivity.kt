package com.example.rickandmorty.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.data.model.CharactersModel
import com.example.rickandmorty.data.remote.Repository
import com.example.rickandmorty.databinding.ActivityMainBinding
//import com.example.rickandmorty.network.ApiHelper
import com.example.rickandmorty.viewmodel.CharacterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//import com.example.rickandmorty.viewmodel.MainActivityViewModel
//import com.example.rickandmorty.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity(),onCharacterListClick {
    lateinit var binding: ActivityMainBinding
    lateinit var characterViewModel: CharacterViewModel
    lateinit var characterAdapterClass: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()

        val options = arrayOf("Sort By Name", "Sort By Episodes")
        val arrayAdapt = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)
        binding.spinner.adapter = arrayAdapt
      /*binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (p2 == 0) {
                    characterAdapterClass.characterDataList.sortBy {
                        it.characterName
                        characterAdapterClass.updateCharacterDataList(it)
                        Log.d("sort name",it.characterName.toString())
                    }} else if (p2 == 1) {
                    characterAdapterClass.characterDataList.sortBy {
                        it.characterEpisodesNumber

                        Log.d("sort episode",it.characterEpisodesNumber.toString())
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("not")


        }
    }*/


        binding.mainActivityViewModel = characterViewModel
        binding.lifecycleOwner = this
        characterAdapterClass= CharacterAdapter(this)
        binding.recyclerView.adapter = characterAdapterClass
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.button.setOnClickListener {
            val buttonIntent=Intent(this,GroupByActivity::class.java)
            startActivity(buttonIntent)

        }
    }

    private fun initViewModel(){
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        lifecycleScope.launch(Dispatchers.IO){
            characterViewModel.getData().collectLatest {
                Log.d("MainActivity",it.toString())
                characterAdapterClass.submitData(it)
            }
        }
    }

    override fun onCharacterClick(item: CharactersModel, position: Int) {
        val intent=Intent(this,CharactersDetailActivity::class.java)
        intent.putExtra("name",item.characterName)
        intent.putExtra("species",item.characterSpecies)
        intent.putExtra("image",item.imageCharacter)
        intent.putExtra("location",item.characterLocation?.locationName)
        intent.putExtra("type",item.characterType)
        intent.putExtra("gender",item.characterGender)
        startActivity(intent)




    }
}
