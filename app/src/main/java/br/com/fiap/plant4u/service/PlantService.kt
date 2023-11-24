package br.com.fiap.plant4u.service

import br.com.fiap.plant4u.model.Plant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlantService {

    @POST("plants/register/{userId}")
    suspend fun registerPlant(@Path("userId") userId: Long, @Body plant: Plant): Response<String>

    @DELETE("plants/delete/{plantId}")
    fun deletePlantById(@Path("plantId") plantId: String): Call<Plant>

    @GET("plants/{plantId}")
    fun getPlantById(@Path("plantId") plantId: String): Call<Plant>

    @PUT("plants/{plantId}")
    fun updatePlant(@Path("plantId") plantId: String): Call<Plant>

    @GET("/plants/listPlants/{userId}")
    fun getPlantsByUserId(@Path("userId") userId: Long): Call<List<Plant>>


}