package com.example.mymvvmsample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CatFactDTO(
    @SerializedName("fact")
    @Expose
    val fact: String,
    @SerializedName("length")
    @Expose
    val length: Int
)
