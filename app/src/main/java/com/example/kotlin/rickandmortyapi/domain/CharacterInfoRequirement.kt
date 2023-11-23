package com.example.kotlin.rickandmortyapi.domain

import com.example.kotlin.rickandmortyapi.data.CharacterRepository
import com.example.kotlin.rickandmortyapi.data.model.character.Character

class CharacterInfoRequirement {
    private val repository = CharacterRepository()

    suspend operator fun invoke(
        id:Int
    ): Character? = repository.getCharacterInfo(id)
}