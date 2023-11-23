package com.example.kotlin.rickandmortyapi.data.model

import com.google.gson.annotations.SerializedName

data class InfoBase(
    @SerializedName("count") val count: String
)
