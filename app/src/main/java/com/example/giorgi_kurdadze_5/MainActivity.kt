package com.example.giorgi_kurdadze_5

import ColorAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var colorAdapter: ColorAdapter
    private var mList: MutableList<ColorsData> =  ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showRecyclerview()
        fetchDataFromApi()
    }

    private fun showRecyclerview() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        colorAdapter = ColorAdapter(mList)
        recyclerView.adapter = colorAdapter
    }


    private fun fetchDataFromApi() {
        val apiService = RetrofitClient.retrofit.create(ApiService::class.java)
        val call = apiService.getPosts()

        call.enqueue(object : Callback<Colors> {
            override fun onResponse(call: Call<Colors>, response: Response<Colors>) {
                if (response.isSuccessful) {
                    val colorsResponse = response.body()
                    colorsResponse?.data?.let { colorsResponseData ->
                        mList.addAll(colorsResponseData)
                        colorAdapter.notifyDataSetChanged()
                    }
                } else {
                    Log.e("API", "Request failed with code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Colors>, t: Throwable) {
                Log.e("API", "Request failed with exception: ${t.message}")
            }
        })
    }
}