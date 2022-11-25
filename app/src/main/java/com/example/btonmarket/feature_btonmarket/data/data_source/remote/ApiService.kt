package com.example.btonmarket.feature_btonmarket.data.data_source.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class OnSellItems(
    var id: Int,
    var name: String,
    var seller: String,
    var condition: String,
    var price : Float,
    var negotiable : Boolean,
    var sold: Boolean,
    var img: String,
)

const val BASE_URL = "https://btonmarketapi.herokuapp.com/api/"

interface ApiService {
    @GET("onsale-items")
    suspend fun getOnSellItems(): List<OnSellItems>

    companion object{
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}