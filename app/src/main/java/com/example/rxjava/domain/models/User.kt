package com.example.rxjava.domain.models

import java.io.Serializable

data class User(
    val login: String,
    val password: String,
    val name: String
) : Serializable
