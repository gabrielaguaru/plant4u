package br.com.fiap.plant4u.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "https://localhost:8080/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPlantService(): PlantService {
        return retrofitFactory.create(PlantService::class.java)
    }

    fun getAuthService(): AuthService {
        return retrofitFactory.create(AuthService::class.java)
    }

    fun getUserService(): UserService {
        return retrofitFactory.create(UserService::class.java)
    }
}