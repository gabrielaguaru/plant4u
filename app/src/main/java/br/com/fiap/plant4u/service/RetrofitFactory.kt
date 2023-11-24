package br.com.fiap.plant4u.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "http://10.0.2.2:8080/"

    private val gson = GsonBuilder().setLenient().create();

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
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