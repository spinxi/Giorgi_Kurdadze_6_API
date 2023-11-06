package com.example.giorgi_kurdadze_5

import com.google.gson.annotations.SerializedName

data class ColorsDetails(
    val data: ColorData
)

data class ColorData(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    @SerializedName("pantone_value")
    val pantoneValue: String
)

