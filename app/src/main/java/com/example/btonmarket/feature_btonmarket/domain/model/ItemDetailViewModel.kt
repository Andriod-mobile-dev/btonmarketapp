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

//Todo: variable names
class ItemDetailViewModel: ViewModel() {
    private val _itemDetailList = mutableStateListOf<onSellItem>()
    var errorMessage: String by mutableStateOf("")
    val itemDetail: List<onSellItem>
        get() = _itemDetailList

    fun getitemDetailInfo(searchedItemID: Int){
        val apiService = ApiService.getInstance()
        viewModelScope.launch {
            try{
                _itemDetailList.clear()
                _itemDetailList.add(apiService.getItemDetail(searchedItemID))
                Log.d("Search success", _itemDetailList.size.toString())
            }catch (e: Exception){
                errorMessage = e.message.toString()
                Log.d("Search failed", errorMessage)
            }
        }
    }
}