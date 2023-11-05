package com.example.giorgi_kurdadze_5

import com.google.gson.annotations.SerializedName

data class Colors(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<ColorsData>,
    val support: Support
)

data class ColorsData(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    @SerializedName("pantone_value")
    val pantoneValue: String
)

data class Support(
    val url: String,
    val text: String
)
