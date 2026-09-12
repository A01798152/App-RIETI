package mx.joshh.appsipinna.ui.screens.report

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import mx.joshh.appsipinna.ui.navigation.Routes

@Composable
fun DetailsStepRoute(
    viewModel: ReportViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    DetailsStepScreen(
        descripcion = uiState.descripcion,
        numeroMenores = uiState.numeroMenores,
        edadAproximada = uiState.edadAproximada,
        horario = uiState.horario,
        frecuencia = uiState.frecuencia,
        isStepValid = uiState.isStep2Valid,
        onDescripcionChange = viewModel::onDescripcionChange,
        onNumeroMenoresChange = viewModel::onNumeroMenoresChange,
        onEdadAproximadaChange = viewModel::onEdadAproximadaChange,
        onHorarioChange = viewModel::onHorarioChange,
        onFrecuenciaChange = viewModel::onFrecuenciaChange,
        onNextClick = { navController.navigate(Routes.REPORT_STEP_3) },
        onBackClick = { navController.popBackStack() }
    )
}
