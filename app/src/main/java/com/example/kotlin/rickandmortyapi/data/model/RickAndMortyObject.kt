package com.example.kotlin.rickandmortyapi.data.model

import com.example.kotlin.rickandmortyapi.data.model.CharacterBase
import com.example.kotlin.rickandmortyapi.data.model.InfoBase
import com.google.gson.annotations.SerializedName

data class RickAndMortyObject(
    @SerializedName("info") val info: InfoBase,
    @SerializedName("results") val results: ArrayList<CharacterBase>,
)
