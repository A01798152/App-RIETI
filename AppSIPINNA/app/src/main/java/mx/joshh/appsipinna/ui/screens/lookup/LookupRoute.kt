package mx.joshh.appsipinna.ui.screens.lookup

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.joshh.appsipinna.ui.components.ErrorState
import mx.joshh.appsipinna.ui.components.LoadingState

@Composable
fun LookupRoute(
    navController: NavController,
    viewModel: LookupViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        LookupUiState.Idle -> {
            LookupScreen(
                onConsultarClick = { folio -> viewModel.consultarFolio(folio) },
                onBackClick = { navController.popBackStack() }
            )
        }
        LookupUiState.Loading -> {
            LoadingState(message = stringResource(mx.joshh.appsipinna.R.string.estado_cargando))
        }
        is LookupUiState.Success -> {
            ResultScreen(
                reporte = state.reporte,
                onBackClick = { 
                    viewModel.reset()
                    navController.popBackStack() 
                }
            )
        }
        is LookupUiState.Error -> {
            ErrorState(
                message = stringResource(state.messageRes),
                modifier = Modifier.clickable { viewModel.reset() }
            )
        }
    }
}
