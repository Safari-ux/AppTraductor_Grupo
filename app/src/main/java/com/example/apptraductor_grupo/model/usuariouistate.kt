package com.example.apptraductor_grupo.model

data class usuariouistate(
    val nombre: String = "",
    val correo: String = "",
    val clave: String = "",
    val direccion: String = "",
    val aceptaterminos: Boolean = false,
    val errores: usuarioerrores = usuarioerrores()
)

data class usuarioerrores(
    val nombre: String? = null,
    val correo: String? = null,
    val clave: String? = null,
    val direccion: String? = null
)
