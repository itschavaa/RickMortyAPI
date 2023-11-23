package com.example.kotlin.rickandmortyapi.data.network

import com.example.kotlin.rickandmortyapi.data.model.RickAndMortyObject
import com.example.kotlin.rickandmortyapi.data.model.character.Character

class RickAndMortyAPIClient {
    private lateinit var api: RickANdMOrtyAPIService

    suspend fun getCharacterList(): RickAndMortyObject?{
        api = NetworkModuleDI()
        return try{
            api.getCharacterList()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getCharacterInfo(numberCharacter:Int): Character? {
        api = NetworkModuleDI()
        return try{
            api.getCharacterInfo(numberCharacter)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}