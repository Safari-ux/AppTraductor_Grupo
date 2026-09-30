package com.example.apptraductor_grupo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apptraductor_grupo.model.usuarioerrores
import com.example.apptraductor_grupo.model.usuariouistate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class usuarioviewmodel : ViewModel() {
    private val _estado = MutableStateFlow(usuariouistate())

    val estado: StateFlow<usuariouistate> = _estado

    fun onnombrechange(valor: String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    fun oncorreochange(valor: String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    fun onclavechange(valor: String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun ondireccionchange(valor: String) {
        _estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }

    fun onaceptarterminoschange(valor: Boolean) {
        _estado.update { it.copy(aceptaterminos = valor) }
    }

    fun validarformulario(): Boolean {
        val estadoactual = _estado.value

        val errores = usuarioerrores(
            nombre = if (estadoactual.nombre.isBlank()) "Campo obligatorio" else null,
            correo = if (!estadoactual.correo.contains("@")) "Correo invalido" else null,
            clave = if (estadoactual.clave.length < 6) "Debe tener al menos 6 caracteres" else null,
            direccion = if (estadoactual.direccion.isBlank()) "Campo obligatorio" else null
        )

        val hayerrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()

        _estado.update { it.copy(errores = errores) }

        return !hayerrores && estadoactual.aceptaterminos
    }
}
