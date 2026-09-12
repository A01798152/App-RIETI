package mx.joshh.appsipinna.view.screens.report

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import mx.joshh.appsipinna.view.navigation.Routes
import mx.joshh.appsipinna.viewmodel.ReportViewModel

@Composable
fun LocationStepRoute(
    viewModel: ReportViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    LocationStepScreen(
        latitud = uiState.latitud,
        longitud = uiState.longitud,
        nombreLugar = uiState.nombreLugar,
        tipoActividad = uiState.tipoActividad,
        isStepValid = uiState.isStep1Valid,
        onNombreLugarChange = viewModel::onNombreLugarChange,
        onTipoActividadChange = viewModel::onTipoActividadChange,
        onMapClick = { viewModel.onMapClick(19.5546, -99.2476) },
        onUseMyLocationClick = viewModel::onUseMyLocation,
        onNextClick = { navController.navigate(Routes.REPORT_STEP_2) },
        onBackClick = { navController.popBackStack() }
    )
}
