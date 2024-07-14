package com.superhero.magneto.model

import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("eye-color")
    val eyecolor: String,
    @SerializedName("hair-color")
    val haircolor: String,
    val height: List<String>,
    val weight: List<String>,
    val race: String,
    val gender: String
)
