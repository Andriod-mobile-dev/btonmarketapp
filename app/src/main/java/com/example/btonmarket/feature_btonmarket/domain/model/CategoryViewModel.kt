package com.example.btonmarket.feature_btonmarket.domain.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.ApiService
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.onSellItem
import kotlinx.coroutines.launch
import java.lang.Exception

//Todo: some variables need to be renamed
class CategoryViewModel: ViewModel() {
    private val _onSellItemsList = mutableStateListOf<onSellItem>()
    var errorMessage: String by mutableStateOf("")
    val searchedSellItemsList: List<onSellItem>
        get() = _onSellItemsList

    fun searchItems(searchedItem: String){
        val apiService = ApiService.getInstance()
        viewModelScope.launch {
            try{
                _onSellItemsList.clear()
                _onSellItemsList.addAll(apiService.getCategory(searchedItem))
                Log.d("Search success", _onSellItemsList.size.toString())
            }catch (e: Exception){
                errorMessage = e.message.toString()
                Log.d("Search failed", errorMessage)
            }
        }
    }
}