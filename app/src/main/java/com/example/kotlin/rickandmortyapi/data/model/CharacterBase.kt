package com.example.kotlin.rickandmortyapi.data.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class CharacterBase (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("image") val image: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String
)

