package mx.joshh.appsipinna.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.model.FakeReportRepository
import mx.joshh.appsipinna.model.Frecuencia
import mx.joshh.appsipinna.model.Reporte
import mx.joshh.appsipinna.model.TipoActividad

class ReportViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReportUiState())
    val uiState: StateFlow<ReportUiState> = _uiState.asStateFlow()

    fun onNombreLugarChange(value: String) {
        _uiState.update { it.copy(nombreLugar = value, errorNombreLugar = null) }
    }

    fun onTipoActividadChange(value: TipoActividad) {
        _uiState.update { it.copy(tipoActividad = value) }
    }

    fun onDescripcionChange(value: String) {
        _uiState.update { it.copy(descripcion = value, errorDescripcion = null) }
    }

    fun onNumeroMenoresChange(value: Int) {
        _uiState.update { it.copy(numeroMenores = value) }
    }

    fun onEdadAproximadaChange(value: String) {
        _uiState.update { it.copy(edadAproximada = value) }
    }

    fun onHorarioChange(value: String) {
        _uiState.update { it.copy(horario = value) }
    }

    fun onFrecuenciaChange(value: Frecuencia) {
        _uiState.update { it.copy(frecuencia = value) }
    }

    fun onAdvertenciaEntendidaChange(value: Boolean) {
        _uiState.update { it.copy(advertenciaEntendida = value) }
    }

    fun onCorreoChange(value: String) {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$".toRegex()
        val isValid = value.isBlank() || emailRegex.matches(value)
        _uiState.update { 
            it.copy(
                correo = value, 
                errorCorreo = if (isValid) null else R.string.error_correo_invalido 
            ) 
        }
    }

    fun onMapClick(lat: Double, lon: Double) {
        _uiState.update { it.copy(latitud = lat, longitud = lon, ubicacionMarcada = true) }
    }
    
    fun onUseMyLocation() {
        // Mock de GPS: Atizapán Centro
        _uiState.update { it.copy(latitud = 19.5580, longitud = -99.2485, ubicacionMarcada = true) }
    }

    fun onAttachEvidence(uri: String) {
        _uiState.update { it.copy(evidenciaUri = uri) }
    }

    fun onRemoveEvidence() {
        _uiState.update { it.copy(evidenciaUri = null) }
    }

    fun enviarReporte(onSuccess: (String) -> Unit) {
        val state = _uiState.value
        if (!state.canSubmit) return

        viewModelScope.launch {
            _uiState.update { it.copy(isEnviando = true, errorEnvio = null) }
            
            val reporte = Reporte(
                tipoActividad = state.tipoActividad!!,
                latitud = state.latitud,
                longitud = state.longitud,
                nombreLugar = state.nombreLugar,
                descripcion = state.descripcion,
                numeroMenores = state.numeroMenores,
                edadAproximada = state.edadAproximada,
                horario = state.horario,
                frecuencia = state.frecuencia!!,
                evidenciaUri = state.evidenciaUri,
                correo = state.correo
            )

            val result = FakeReportRepository.crearReporte(reporte)
            
            result.onSuccess { folio ->
                _uiState.update { it.copy(isEnviando = false, folioGenerado = folio) }
                onSuccess(folio)
            }.onFailure {
                _uiState.update { it.copy(isEnviando = false, errorEnvio = R.string.error_envio_reporte) }
            }
        }
    }
    
    fun resetFolio() {
        _uiState.update { it.copy(folioGenerado = null) }
    }
}
