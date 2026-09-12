package mx.joshh.appsipinna.ui.screens.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.ui.components.EvidenceWarning
import mx.joshh.appsipinna.ui.components.RietiButton
import mx.joshh.appsipinna.ui.components.RietiSecondaryButton
import mx.joshh.appsipinna.ui.components.RietiTextField
import mx.joshh.appsipinna.ui.components.RietiTopAppBar
import mx.joshh.appsipinna.ui.components.StepIndicator
import mx.joshh.appsipinna.ui.theme.RietiTheme

@Composable
fun EvidenceStepScreen(
    advertenciaEntendida: Boolean,
    evidenciaUri: String?,
    correo: String,
    errorCorreo: Int?,
    isStepValid: Boolean,
    onAdvertenciaEntendidaChange: (Boolean) -> Unit,
    onAttachEvidenceClick: () -> Unit,
    onRemoveEvidenceClick: () -> Unit,
    onCorreoChange: (String) -> Unit,
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
            StepIndicator(currentStep = 3)
            
            Text(
                text = stringResource(R.string.paso3_instrucciones),
                style = MaterialTheme.typography.bodyLarge
            )

            EvidenceWarning()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(RietiTheme.spacing.sm)
            ) {
                Checkbox(
                    checked = advertenciaEntendida,
                    onCheckedChange = onAdvertenciaEntendidaChange,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = stringResource(R.string.entendido_checkbox),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            if (evidenciaUri == null) {
                RietiSecondaryButton(
                    text = stringResource(R.string.adjuntar_evidencia),
                    onClick = onAttachEvidenceClick,
                    enabled = advertenciaEntendida
                )
            } else {
                AttachedFileItem(
                    fileName = evidenciaUri.substringAfterLast("/"),
                    onRemoveClick = onRemoveEvidenceClick
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.sm)) {
                RietiTextField(
                    value = correo,
                    onValueChange = onCorreoChange,
                    label = stringResource(R.string.label_correo),
                    placeholder = stringResource(R.string.placeholder_correo),
                    errorText = errorCorreo?.let { stringResource(it) },
                    keyboardType = KeyboardType.Email
                )
                Text(
                    text = stringResource(R.string.nota_anonimato),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun AttachedFileItem(
    fileName: String,
    onRemoveClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = RietiTheme.spacing.sm),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(RietiTheme.spacing.sm)
    ) {
        Icon(
            imageVector = Icons.Default.Description,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = fileName,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        IconButton(onClick = onRemoveClick) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(R.string.quitar_archivo),
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EvidenceStepScreenPreview() {
    RietiTheme {
        EvidenceStepScreen(
            advertenciaEntendida = true,
            evidenciaUri = "foto_lugar.jpg",
            correo = "",
            errorCorreo = null,
            isStepValid = false,
            onAdvertenciaEntendidaChange = {},
            onAttachEvidenceClick = {},
            onRemoveEvidenceClick = {},
            onCorreoChange = {},
            onNextClick = {},
            onBackClick = {}
        )
    }
}
