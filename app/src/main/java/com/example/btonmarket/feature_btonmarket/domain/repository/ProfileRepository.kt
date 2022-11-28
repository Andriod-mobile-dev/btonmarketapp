package com.example.btonmarket.feature_btonmarket.domain.repository

import com.example.btonmarket.feature_auth.domain.model.Response


typealias SignOutResponse = Response<Boolean>
typealias RevokeAccessResponse = Response<Boolean>

interface ProfileRepository {
    val displayName: String
    val photoUrl: String

    suspend fun signOut(): SignOutResponse

    suspend fun revokeAccess(): RevokeAccessResponse
}