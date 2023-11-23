package com.example.kotlin.rickandmortyapi.domain

import com.example.kotlin.rickandmortyapi.data.CharacterRepository
import com.example.kotlin.rickandmortyapi.data.model.RickAndMortyObject

class CharacterListRequirement {

    private val repository = CharacterRepository()

    suspend operator fun invoke(
    ): RickAndMortyObject? = repository.getCharacterList()
}