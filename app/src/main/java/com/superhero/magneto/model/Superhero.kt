package com.superhero.magneto.model

import com.google.gson.annotations.SerializedName

data class Superhero(
    val id: String,
    val name: String,
    val powerstats: PowerStats,
    val biography: Biography,
    val connections: Connections,
    @SerializedName("image")
    val image: Image,
    val appearance: Appearance
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)


data class Image(
    @SerializedName("url")
    val url: String
)