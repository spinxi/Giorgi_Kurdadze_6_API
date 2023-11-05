package com.example.giorgi_kurdadze_5

import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("api/unknown") // Replace with the actual API endpoint
    fun getPosts(): Call<Colors>
}