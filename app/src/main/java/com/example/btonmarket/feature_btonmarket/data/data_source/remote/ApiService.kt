package com.example.btonmarket.feature_btonmarket.data.data_source.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

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

const val BASE_URL = "https://btonmarketapi.herokuapp.com/api/"

interface ApiService{
    @GET("onsale-items")
    suspend fun getOnSellItems(): List<onSellItem>

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
    @Headers("Content-Type: application/json")
    @POST("onsale-create/")
    fun createOnSell(@Body dataModel: onSellItem?): Call<onSellItem?>?

//    @POST("onsale-create")
//    suspend fun createOnSell(@Body dataModel: onSellItem?): Call<onSellItem?>?

}