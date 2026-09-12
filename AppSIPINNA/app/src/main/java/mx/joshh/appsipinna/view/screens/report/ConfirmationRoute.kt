package mx.joshh.appsipinna.view.screens.report

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import mx.joshh.appsipinna.view.navigation.Routes
import mx.joshh.appsipinna.viewmodel.ReportViewModel

@Composable
fun ConfirmationRoute(
    viewModel: ReportViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    ConfirmationScreen(
        folio = uiState.folioGenerado ?: "",
        onFinish = {
            viewModel.resetFolio()
            navController.navigate(Routes.HOME) {
                popUpTo(Routes.REPORT_GRAPH) { inclusive = true }
            }
        }
    )
}
