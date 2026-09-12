package mx.joshh.appsipinna.ui.screens.lookup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.model.EstatusReporte
import mx.joshh.appsipinna.model.Reporte
import mx.joshh.appsipinna.ui.components.RietiButton
import mx.joshh.appsipinna.ui.components.RietiTopAppBar
import mx.joshh.appsipinna.ui.components.StatusChip
import mx.joshh.appsipinna.ui.theme.FolioTextStyle
import mx.joshh.appsipinna.ui.theme.RietiTheme
import java.time.format.DateTimeFormatter

@Composable
fun ResultScreen(
    reporte: Reporte,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            RietiTopAppBar(
                title = stringResource(R.string.lookup_resultado_titulo),
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            RietiButton(
                text = stringResource(R.string.boton_entendido),
                onClick = onBackClick,
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
                .padding(top = RietiTheme.spacing.xxl),
            verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.xl)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.xs)) {
                Text(
                    text = reporte.folio,
                    style = FolioTextStyle,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = stringResource(
                        R.string.lookup_label_fecha,
                        reporte.fechaRegistro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.md)) {
                Text(
                    text = stringResource(R.string.lookup_label_estatus),
                    style = MaterialTheme.typography.titleMedium
                )
                StatusChip(estatus = reporte.estatus)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultScreenPreview() {
    RietiTheme {
        ResultScreen(
            reporte = Reporte(
                folio = "ATZ-XJ4K-W9PR",
                tipoActividad = mx.joshh.appsipinna.model.TipoActividad.OTRO,
                latitud = 0.0,
                longitud = 0.0,
                nombreLugar = "",
                descripcion = "",
                numeroMenores = 0,
                edadAproximada = "",
                horario = "",
                frecuencia = mx.joshh.appsipinna.model.Frecuencia.DIARIO,
                evidenciaUri = null,
                correo = "",
                estatus = EstatusReporte.EN_REVISION
            ),
            onBackClick = {}
        )
    }
}
