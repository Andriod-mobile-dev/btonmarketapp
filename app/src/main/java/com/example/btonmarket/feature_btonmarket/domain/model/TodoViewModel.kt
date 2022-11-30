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

class TodoViewModel : ViewModel() {
    private val _todoList = mutableStateListOf<onSellItem>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<onSellItem>
        get() = _todoList

    fun getTodoList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(apiService.getOnSellItems())
            } catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}