package com.example.intento7.model.repository.localWithRoom.networkWithRetrofit.Pojo2


import com.google.gson.annotations.SerializedName

data class Utm(
    @SerializedName("codigo")
    val codigo: String,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("unidad_medida")
    val unidadMedida: String,
    @SerializedName("valor")
    val valor: Int
)