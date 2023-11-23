package com.example.kotlin.rickandmortyapi.framework.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.rickandmortyapi.data.model.CharacterBase
import com.example.kotlin.rickandmortyapi.databinding.ActivityCharacterDetailBinding
import com.example.kotlin.rickandmortyapi.framework.adapters.CharacterAdapter
import com.example.kotlin.rickandmortyapi.framework.viewmodel.CharacterDetailViewModel
import com.example.kotlin.rickandmortyapi.framework.viewmodel.CharacterViewModel
import com.example.kotlin.rickandmortyapi.utils.Constants

class CharacterDetailActivity : Activity() {
    private lateinit var binding: ActivityCharacterDetailBinding
    private var characterUrl:String? = null
    private lateinit var viewModel: CharacterDetailViewModel
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:CharacterBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manageIntent()
        initializeBinding()
    }

    private fun initializeBinding(){
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun manageIntent(){
        if(intent != null){
            characterUrl = intent.getStringExtra(Constants.URL_POKEMON)
            Log.d("Salida",characterUrl.toString())
        }
    }
}