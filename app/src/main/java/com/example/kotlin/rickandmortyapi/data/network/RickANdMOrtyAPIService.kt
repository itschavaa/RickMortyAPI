package com.example.kotlin.rickandmortyapi.data.network

import com.example.kotlin.rickandmortyapi.data.model.RickAndMortyObject
import com.example.kotlin.rickandmortyapi.data.model.character.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface RickANdMOrtyAPIService {
    //https://rickandmortyapi.com/api/character
    @GET("character")
    suspend fun getCharacterList(
    ): RickAndMortyObject
    //https://rickandmortyapi.com/api/character/2
    @GET("character/{numberCharacter}")
    suspend fun getCharacterInfo(
        @Path("numberCharacter") numberCharacter:Int
    ): Character
}