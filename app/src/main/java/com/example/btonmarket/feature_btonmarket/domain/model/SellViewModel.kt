package com.example.btonmarket.feature_btonmarket.domain.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.ApiService
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.onSellItem
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellViewModel: ViewModel() {
    var sellErrorMessage: String by mutableStateOf("")

    fun postSellItem(item: onSellItem){
        //Todo: debbugging stopped here!
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            val call: Call<onSellItem?>? = apiService.createOnSell(item)

            call!!.enqueue(object: Callback<onSellItem?> {
                override fun onResponse(call: Call<onSellItem?>?, response: Response<onSellItem?>) {
                    //TODO("Not yet implemented")
                    Log.d("Debug tesfa", "Success")
                }

                override fun onFailure(call: Call<onSellItem?>?, t: Throwable) {
                    sellErrorMessage = t.message.toString()
                    Log.d("Debug tesfa", sellErrorMessage)
                }
            })
        }
    }
}