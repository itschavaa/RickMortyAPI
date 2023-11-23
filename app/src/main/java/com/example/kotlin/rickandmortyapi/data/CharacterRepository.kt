package com.example.kotlin.rickandmortyapi.data

import com.example.kotlin.rickandmortyapi.data.model.RickAndMortyObject
import com.example.kotlin.rickandmortyapi.data.model.character.Character
import com.example.kotlin.rickandmortyapi.data.network.NetworkModuleDI
import com.example.kotlin.rickandmortyapi.data.network.RickANdMOrtyAPIService
import com.example.kotlin.rickandmortyapi.data.network.RickAndMortyAPIClient

class CharacterRepository() {
    private val api = RickAndMortyAPIClient()
    suspend fun getCharacterList(): RickAndMortyObject? = api.getCharacterList()
    suspend fun getCharacterInfo(id:Int): Character? = api.getCharacterInfo(id)
}
