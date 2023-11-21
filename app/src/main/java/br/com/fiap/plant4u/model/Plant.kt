package br.com.fiap.plant4u.model

import com.google.gson.annotations.SerializedName

data class Plant(
    val id: Long = 0,
    val imageId: Int = 0,
    val name: String = "",
    val lastWatering: String = "",
    val frequency: String = "",
    val nextWatering: String = "",
    val isError: Boolean = false
)

//data class Plant(
//    val id: Long = 0,
//    val name: String = "",
//    val urlImage: String = "",
//    @SerializedName("frequencyWatering") val frequency: String = "",
//    val intervalTime: String = "",
//    val lastWatering: String = "",
//    val notification: Boolean = false
//)