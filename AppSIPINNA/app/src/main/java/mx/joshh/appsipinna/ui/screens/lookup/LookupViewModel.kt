package mx.joshh.appsipinna.ui.screens.lookup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.data.FakeReportRepository
import mx.joshh.appsipinna.data.LookupError
import mx.joshh.appsipinna.data.LookupErrorException

class LookupViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<LookupUiState>(LookupUiState.Idle)
    val uiState: StateFlow<LookupUiState> = _uiState.asStateFlow()

    fun consultarFolio(folio: String) {
        if (folio.isBlank()) return

        viewModelScope.launch {
            _uiState.value = LookupUiState.Loading
            val result = FakeReportRepository.consultarPorFolio(folio)
            
            result.onSuccess { reporte ->
                _uiState.value = LookupUiState.Success(reporte)
            }.onFailure { exception ->
                val errorRes = if (exception is LookupErrorException && 
                    exception.error == LookupError.FolioNoEncontrado) {
                    R.string.error_folio_no_encontrado
                } else {
                    R.string.estado_error
                }
                _uiState.value = LookupUiState.Error(errorRes)
            }
        }
    }
    
    fun reset() {
        _uiState.value = LookupUiState.Idle
    }
}
