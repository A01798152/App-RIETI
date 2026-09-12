package mx.joshh.appsipinna.ui.screens.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.model.TipoActividad
import mx.joshh.appsipinna.ui.components.MapPlaceholder
import mx.joshh.appsipinna.ui.components.RietiButton
import mx.joshh.appsipinna.ui.components.RietiSecondaryButton
import mx.joshh.appsipinna.ui.components.RietiTextField
import mx.joshh.appsipinna.ui.components.RietiTopAppBar
import mx.joshh.appsipinna.ui.components.SelectionChips
import mx.joshh.appsipinna.ui.components.StepIndicator
import mx.joshh.appsipinna.ui.theme.RietiTheme

@Composable
fun LocationStepScreen(
    latitud: Double,
    longitud: Double,
    nombreLugar: String,
    tipoActividad: TipoActividad?,
    isStepValid: Boolean,
    onNombreLugarChange: (String) -> Unit,
    onTipoActividadChange: (TipoActividad) -> Unit,
    onMapClick: () -> Unit,
    onUseMyLocationClick: () -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            RietiTopAppBar(
                title = stringResource(R.string.titulo_reporte),
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            RietiButton(
                text = stringResource(R.string.boton_continuar),
                onClick = onNextClick,
                enabled = isStepValid,
                modifier = Modifier.padding(RietiTheme.spacing.lg)
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = RietiTheme.spacing.screenHorizontal)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.xl)
        ) {
            StepIndicator(currentStep = 1)
            
            Text(
                text = stringResource(R.string.paso1_instrucciones),
                style = MaterialTheme.typography.bodyLarge
            )

            MapPlaceholder(
                latitud = latitud,
                longitud = longitud,
                onMapClick = onMapClick
            )

            RietiSecondaryButton(
                text = stringResource(R.string.boton_usar_ubicacion),
                onClick = onUseMyLocationClick
            )

            RietiTextField(
                value = nombreLugar,
                onValueChange = onNombreLugarChange,
                label = stringResource(R.string.label_referencia_lugar),
                placeholder = stringResource(R.string.placeholder_referencia_lugar)
            )

            Column(verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.sm)) {
                Text(
                    text = stringResource(R.string.label_tipo_actividad),
                    style = MaterialTheme.typography.titleSmall
                )
                SelectionChips(
                    options = TipoActividad.entries,
                    selectedOption = tipoActividad,
                    onOptionSelected = onTipoActividadChange,
                    labelProvider = { stringResource(it.labelRes) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun LocationStepScreenPreview() {
    RietiTheme {
        LocationStepScreen(
            latitud = 19.5546,
            longitud = -99.2476,
            nombreLugar = "",
            tipoActividad = null,
            isStepValid = false,
            onNombreLugarChange = {},
            onTipoActividadChange = {},
            onMapClick = {},
            onUseMyLocationClick = {},
            onNextClick = {},
            onBackClick = {}
        )
    }
}
