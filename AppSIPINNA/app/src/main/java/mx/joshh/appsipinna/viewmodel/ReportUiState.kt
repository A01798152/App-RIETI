package mx.joshh.appsipinna.viewmodel

import mx.joshh.appsipinna.model.Frecuencia
import mx.joshh.appsipinna.model.TipoActividad

data class ReportUiState(
    // Paso 1: Ubicación
    val latitud: Double = 19.5546,
    val longitud: Double = -99.2476,
    val ubicacionMarcada: Boolean = false,
    val nombreLugar: String = "",
    val tipoActividad: TipoActividad? = null,
    
    // Paso 2: Detalles
    val descripcion: String = "",
    val numeroMenores: Int = 1,
    val edadAproximada: String = "",
    val horario: String = "",
    val frecuencia: Frecuencia? = null,
    
    // Paso 3: Evidencia y Contacto
    val advertenciaEntendida: Boolean = false,
    val evidenciaUri: String? = null,
    val correo: String = "",
    
    // Estado del envío
    val isEnviando: Boolean = false,
    val folioGenerado: String? = null,
    val errorEnvio: Int? = null,
    
    // Validaciones
    val errorNombreLugar: Int? = null,
    val errorDescripcion: Int? = null,
    val errorCorreo: Int? = null
) {
    val isStep1Valid: Boolean = ubicacionMarcada && nombreLugar.isNotBlank() && tipoActividad != null
    val isStep2Valid: Boolean = descripcion.length >= 20 && 
            numeroMenores > 0 && 
            edadAproximada.isNotBlank() && 
            horario.isNotBlank() && 
            frecuencia != null
    val isStep3Valid: Boolean = correo.isNotBlank() && errorCorreo == null
    
    val canSubmit: Boolean = isStep1Valid && isStep2Valid && isStep3Valid
}
