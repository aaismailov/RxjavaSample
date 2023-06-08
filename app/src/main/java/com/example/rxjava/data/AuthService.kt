package com.example.rxjava.data

import com.example.rxjava.domain.models.User
import io.reactivex.Single

object AuthService {
    private val users: List<User> = listOf(
        User("admin", "admin", "Администратор"),
        User("guest", "guest", "Гость"),
    )

    fun login(login: String, password: String): Single<SingleResult> {
        val user = users.firstOrNull { it.login == login }
        if (user != null) {
            if (user.password != password) {
                return Single.just(SingleResult.Error("Неверный пароль"))
            }
            return Single.just(SingleResult.Success(user))
        } else {
            return Single.just(SingleResult.Error("Неверный логин"))
        }
    }
}