package com.example.kotlin.rickandmortyapi.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.rickandmortyapi.data.model.CharacterBase
import com.example.kotlin.rickandmortyapi.data.model.RickAndMortyObject
import com.example.kotlin.rickandmortyapi.domain.CharacterInfoRequirement
import com.example.kotlin.rickandmortyapi.domain.CharacterListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDetailViewModel : ViewModel() {
    val characterLiveData = MutableLiveData<com.example.kotlin.rickandmortyapi.data.model.character.Character?>()
    private val characterInfoRequirement = CharacterInfoRequirement()
    fun getCharacterInfo(id: Int){
        viewModelScope.launch(Dispatchers.IO){
            val result: com.example.kotlin.rickandmortyapi.data.model.character.Character? = characterInfoRequirement(id)
            Log.d("Salida", result?.gender.toString())
            CoroutineScope(Dispatchers.Main).launch {
                characterLiveData.postValue(result)
            }
        }
    }
}