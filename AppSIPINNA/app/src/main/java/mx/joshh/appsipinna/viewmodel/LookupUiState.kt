package mx.joshh.appsipinna.viewmodel

import mx.joshh.appsipinna.model.Reporte

sealed interface LookupUiState {
    data object Idle : LookupUiState
    data object Loading : LookupUiState
    data class Success(val reporte: Reporte) : LookupUiState
    data class Error(val messageRes: Int) : LookupUiState
}
