package com.example.giorgi_kurdadze_5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("api/unknown") // Replace with the actual API endpoint
    fun getPosts(): Call<Colors>

    @GET("api/unknown/{id}") // Replace with your actual endpoint
    fun getDetails(@Path("id") id: Int): Call<ColorsDetails>
}