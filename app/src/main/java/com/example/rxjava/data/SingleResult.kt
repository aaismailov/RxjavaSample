package com.example.rxjava.data

import com.example.rxjava.domain.models.User

sealed class SingleResult {
    data class Success(val data: User) : SingleResult()
    data class Error(val message: String) : SingleResult()
}
