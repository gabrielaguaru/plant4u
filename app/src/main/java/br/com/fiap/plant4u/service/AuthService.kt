package br.com.fiap.plant4u.service

import br.com.fiap.plant4u.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signup")
    suspend fun registerUser(@Body user: User): Response<User>

    @POST("auth/login")
    suspend fun authenticateUser(@Body user: User): Response<User>
}