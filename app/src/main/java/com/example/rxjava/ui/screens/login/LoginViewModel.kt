package com.example.rxjava.ui.screens.login

import androidx.lifecycle.ViewModel
import com.example.rxjava.data.AuthService
import com.example.rxjava.data.SingleResult
import io.reactivex.Single

class LoginViewModel : ViewModel() {
    private val repository = AuthService

    fun login(login: String, password: String): Single<SingleResult> =
        repository.login(login, password)
}