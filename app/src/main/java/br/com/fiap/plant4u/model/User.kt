package br.com.fiap.plant4u.model

data class User(
    val userId: Long? = 0,
    val password: String = "",
    val email: String = "",
    val fullName: String? = ""
)
