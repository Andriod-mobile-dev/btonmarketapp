package com.example.btonmarket.feature_btonmarket.domain.model

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

class OnSellViewModel : ViewModel() {
    private val _onSellItemsList = mutableStateListOf<onSellItem>()
    var errorMessage: String by mutableStateOf("")
    val onSellItemsList: List<onSellItem>
        get() = _onSellItemsList

    fun getOnSellItemsList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                _onSellItemsList.clear()
                _onSellItemsList.addAll(apiService.getOnSellItems())
            } catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}