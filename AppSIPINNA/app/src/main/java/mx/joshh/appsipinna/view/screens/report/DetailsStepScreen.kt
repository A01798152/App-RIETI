package mx.joshh.appsipinna.view.screens.report

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
import mx.joshh.appsipinna.model.Frecuencia
import mx.joshh.appsipinna.view.components.RietiButton
import mx.joshh.appsipinna.view.components.RietiTextField
import mx.joshh.appsipinna.view.components.RietiTopAppBar
import mx.joshh.appsipinna.view.components.SelectionChips
import mx.joshh.appsipinna.view.components.StepIndicator
import mx.joshh.appsipinna.view.components.Stepper
import mx.joshh.appsipinna.view.theme.RietiTheme

@Composable
fun DetailsStepScreen(
    descripcion: String,
    numeroMenores: Int,
    edadAproximada: String,
    horario: String,
    frecuencia: Frecuencia?,
    isStepValid: Boolean,
    onDescripcionChange: (String) -> Unit,
    onNumeroMenoresChange: (Int) -> Unit,
    onEdadAproximadaChange: (String) -> Unit,
    onHorarioChange: (String) -> Unit,
    onFrecuenciaChange: (Frecuencia) -> Unit,
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
            StepIndicator(currentStep = 2)
            
            Text(
                text = stringResource(R.string.paso2_instrucciones),
                style = MaterialTheme.typography.bodyLarge
            )

            RietiTextField(
                value = descripcion,
                onValueChange = onDescripcionChange,
                label = stringResource(R.string.label_descripcion),
                placeholder = stringResource(R.string.placeholder_descripcion),
                singleLine = false,
                minLines = 4,
                minCharacters = 20
            )

            Column(verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.sm)) {
                Text(
                    text = stringResource(R.string.label_numero_menores),
                    style = MaterialTheme.typography.titleSmall
                )
                Stepper(
                    value = numeroMenores,
                    onValueChange = onNumeroMenoresChange
                )
            }

            RietiTextField(
                value = edadAproximada,
                onValueChange = onEdadAproximadaChange,
                label = stringResource(R.string.label_edad_aproximada),
                placeholder = stringResource(R.string.placeholder_edad_aproximada)
            )

            RietiTextField(
                value = horario,
                onValueChange = onHorarioChange,
                label = stringResource(R.string.label_horario),
                placeholder = stringResource(R.string.placeholder_horario)
            )

            Column(verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.sm)) {
                Text(
                    text = stringResource(R.string.label_frecuencia),
                    style = MaterialTheme.typography.titleSmall
                )
                SelectionChips(
                    options = Frecuencia.entries,
                    selectedOption = frecuencia,
                    onOptionSelected = onFrecuenciaChange,
                    labelProvider = { stringResource(it.labelRes) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DetailsStepScreenPreview() {
    RietiTheme {
        DetailsStepScreen(
            descripcion = "",
            numeroMenores = 1,
            edadAproximada = "",
            horario = "",
            frecuencia = null,
            isStepValid = false,
            onDescripcionChange = {},
            onNumeroMenoresChange = {},
            onEdadAproximadaChange = {},
            onHorarioChange = {},
            onFrecuenciaChange = {},
            onNextClick = {},
            onBackClick = {}
        )
    }
}
