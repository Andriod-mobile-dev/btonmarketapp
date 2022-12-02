package com.example.btonmarket.feature_btonmarket.data.data_source.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

const val base_url = "https://btonmarketapi.herokuapp.com/api/"

interface RetrofitAPI {
    @Headers("Content-Type: application/json")
    @POST("onsale-create/")
    fun createOnSell(@Body dataModel: onSellItem?): Call<onSellItem?>?

    companion object{
        var apiService: RetrofitAPI? = null
        fun getInstance(): RetrofitAPI {
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(RetrofitAPI::class.java)
            }
            return apiService!!
        }
    }
}