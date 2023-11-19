package br.com.fiap.plant4u.model

data class Plant(
    val id: Long = 0,
    val imageId: Int = 0,
    val name: String = "",
    val lastWatering: String = "",
    val frequency: String = "",
    val nextWatering: String = "",
    val isError: Boolean = false
)
