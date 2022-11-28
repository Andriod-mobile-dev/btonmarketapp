package com.example.btonmarket.core

import android.util.Log
import com.example.btonmarket.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) {
            Log.e(TAG, e.message ?: e.toString())
        }
    }
}