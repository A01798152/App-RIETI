package mx.joshh.appsipinna.ui.screens.report

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import mx.joshh.appsipinna.ui.navigation.Routes

@Composable
fun EvidenceStepRoute(
    viewModel: ReportViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    EvidenceStepScreen(
        advertenciaEntendida = uiState.advertenciaEntendida,
        evidenciaUri = uiState.evidenciaUri,
        correo = uiState.correo,
        errorCorreo = uiState.errorCorreo,
        isStepValid = uiState.isStep3Valid,
        onAdvertenciaEntendidaChange = viewModel::onAdvertenciaEntendidaChange,
        onAttachEvidenceClick = { viewModel.onAttachEvidence("foto_evidencia_atizapan.jpg") },
        onRemoveEvidenceClick = viewModel::onRemoveEvidence,
        onCorreoChange = viewModel::onCorreoChange,
        onNextClick = { navController.navigate(Routes.REPORT_REVIEW) },
        onBackClick = { navController.popBackStack() }
    )
}
