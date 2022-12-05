package com.example.btonmarket.feature_btonmarket.data.data_source.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

data class onSellItem(
    //var userId: Int,
    var id: Int,
    var name: String,
    var seller: String,
    var condition: String,
    var price : Float, // may be wrong
    var negotiable : Boolean,
    var sold: Boolean,
    var img: String,
)

data class sellItem(
    var name: String,
    var seller: String,
    var condition: String,
    var price : Float,
    var negotiable : Boolean,
    var sold: Boolean,
    var img: String,
)

const val BASE_URL = "https://btonmarketapi.herokuapp.com/api/"

interface ApiService{
    @GET("onsale-items")
    suspend fun getOnSellItems(): List<onSellItem>

    @GET("searchItem/{item}")
    suspend fun getSearchedItem(@Path("item") item: String): List<onSellItem>

    @Headers("Content-Type: application/json")
    @POST("onsale-create/")
    fun createOnSell(@Body dataModel: sellItem?): Call<sellItem?>?

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