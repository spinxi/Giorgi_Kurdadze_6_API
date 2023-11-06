package com.example.giorgi_kurdadze_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var yearTextView: TextView
    private lateinit var colorTextView: TextView
    private lateinit var pantoneValueTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        nameTextView = findViewById(R.id.nameDetail)
        yearTextView = findViewById(R.id.yearDetail)
        colorTextView = findViewById(R.id.colorDetail)
        pantoneValueTextView = findViewById(R.id.pantoneDetail)


        val selectedColor: Int? = intent.getIntExtra("COLOR_ID", -1);
        if (selectedColor != null && selectedColor != -1) {
            fetchColorDetails(selectedColor)
        }else{
            Toast.makeText(this, "Error", LENGTH_LONG).show()
        }
    }

    private fun fetchColorDetails(colorId: Int) {
        val apiService = RetrofitClient.retrofit.create(ApiService::class.java)
        val call = apiService.getDetails(colorId)

        call.enqueue(object : Callback<ColorsDetails> {
            override fun onResponse(call: Call<ColorsDetails>, response: Response<ColorsDetails>) {
                if (response.isSuccessful) {
                    val details = response.body()?.data
                    updateUI(details)
                } else {
                    Log.e("API", "Request failed with code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ColorsDetails>, t: Throwable) {
                Log.e("API", "Request failed with exception: ${t.message}")
            }
        })
    }

    private fun updateUI(details: ColorData?) {
        if (details != null) {
            nameTextView.text = details.name
            yearTextView.text = "Year: ${details.year}"
            colorTextView.text = "Color: ${details.color}"
            pantoneValueTextView.text = "Pantone: ${details.pantoneValue}"
        }
    }
}

