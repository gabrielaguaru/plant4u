package br.com.fiap.plant4u.service

import br.com.fiap.plant4u.model.Plant
import br.com.fiap.plant4u.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/users/{userId}/password")
    fun updateUserPassword(@Path("userId") userId: String): Call<User>

    @GET("/users/{userId}")
    fun getUserById(@Path("userId") userId: String): Call<User>
}