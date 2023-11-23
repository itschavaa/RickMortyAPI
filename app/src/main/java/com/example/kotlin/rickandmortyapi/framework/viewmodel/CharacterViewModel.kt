package com.example.kotlin.rickandmortyapi.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.rickandmortyapi.data.model.RickAndMortyObject
import com.example.kotlin.rickandmortyapi.domain.CharacterListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    val rickAndMortyObjectLiveData = MutableLiveData<RickAndMortyObject?>()
    private val pokemonListRequirement = CharacterListRequirement()
    fun getCharacterList(){
        viewModelScope.launch(Dispatchers.IO){
            val result: RickAndMortyObject? = pokemonListRequirement()
            Log.d("Salida", result?.info?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                rickAndMortyObjectLiveData.postValue(result)
            }
        }
    }
}