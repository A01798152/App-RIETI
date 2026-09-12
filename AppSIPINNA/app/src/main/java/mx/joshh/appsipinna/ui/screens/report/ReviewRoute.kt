package mx.joshh.appsipinna.ui.screens.report

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import mx.joshh.appsipinna.ui.navigation.Routes

@Composable
fun ReviewRoute(
    viewModel: ReportViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    ReviewScreen(
        state = uiState,
        onEditStep = { step ->
            val route = when (step) {
                1 -> Routes.REPORT_STEP_1
                2 -> Routes.REPORT_STEP_2
                else -> Routes.REPORT_STEP_3
            }
            navController.navigate(route) {
                popUpTo(Routes.REPORT_STEP_1) { inclusive = false }
            }
        },
        onSubmit = {
            viewModel.enviarReporte { folio ->
                navController.navigate(Routes.REPORT_CONFIRMATION) {
                    popUpTo(Routes.REPORT_STEP_1) { inclusive = true }
                }
            }
        },
        onBackClick = { navController.popBackStack() }
    )
}
