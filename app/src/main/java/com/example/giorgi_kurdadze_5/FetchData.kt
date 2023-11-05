package com.example.giorgi_kurdadze_5

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun fetchDataFromApi2(mlist: MutableList<Colors>){
    val apiService = RetrofitClient.retrofit.create(ApiService::class.java)
    val call = apiService.getPosts();

    call.enqueue(object : Callback<Colors> {
        override fun onResponse(call: Call<Colors>, response: Response<Colors>) {
            if (response.isSuccessful) {
                val colorsResponse = response.body()
                if (colorsResponse != null) {
                    mlist.add(colorsResponse)
                }
                colorsResponse?.data?.forEach { color ->
                    Log.d("API", "Color ID: ${color.id}, Name: ${color.name}, Year: ${color.year}, Color: ${color.color}, Pantone Value: ${color.pantoneValue}")
                }

            } else {
                Log.e("API", "Request failed with code ${response.code()}")
            }
        }

        override fun onFailure(call: Call<Colors>, t: Throwable) {
            Log.e("API", "Request failed with exception 222: ${t.message}")
        }
    })
}