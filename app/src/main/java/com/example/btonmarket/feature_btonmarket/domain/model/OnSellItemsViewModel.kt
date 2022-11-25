package com.example.btonmarket.feature_btonmarket.domain.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.ApiService
import com.example.btonmarket.feature_btonmarket.data.data_source.remote.OnSellItems
import kotlinx.coroutines.launch
import java.lang.*

class OnSellItemsViewModel: ViewModel() {
    private val _onSellItemsList = mutableListOf<OnSellItems>()

    var errorMessage: String by mutableStateOf("")
    val onSellItemsList: List<OnSellItems>
        get() = _onSellItemsList

    fun getOnSellItems(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try{
                _onSellItemsList.clear()
                _onSellItemsList.addAll(apiService.getOnSellItems())
            } catch (e: Exception){
                //Todo: shouldn't be displayed on it.
                errorMessage = e.message.toString()
            }
        }
    }

}