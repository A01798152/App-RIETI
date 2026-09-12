package mx.joshh.appsipinna.ui.screens.report

import android.content.ClipboardManager
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.ui.components.RietiButton
import mx.joshh.appsipinna.ui.components.RietiSecondaryButton
import mx.joshh.appsipinna.ui.theme.FolioTextStyle
import mx.joshh.appsipinna.ui.theme.RietiTheme

@Composable
fun ConfirmationScreen(
    folio: String,
    onFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val copyMessage = stringResource(R.string.folio_copiado)
    val clipboardLabel = stringResource(R.string.label_copiar_folio)
    
    BackHandler {
        onFinish()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            RietiButton(
                text = stringResource(R.string.boton_entendido),
                onClick = onFinish,
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BoxExito()

            Text(
                text = stringResource(R.string.titulo_exito),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = RietiTheme.spacing.xl)
            )

            Text(
                text = stringResource(R.string.instrucciones_folio),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = RietiTheme.spacing.md)
            )

            Text(
                text = folio,
                style = FolioTextStyle,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = RietiTheme.spacing.xxl)
            )

            RietiSecondaryButton(
                text = stringResource(R.string.boton_copiar),
                onClick = {
                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = android.content.ClipData.newPlainText(clipboardLabel, folio)
                    clipboard.setPrimaryClip(clip)
                    scope.launch {
                        snackbarHostState.showSnackbar(copyMessage)
                    }
                },
                modifier = Modifier.padding(top = RietiTheme.spacing.md)
            )
        }
    }
}

@Composable
private fun BoxExito() {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ConfirmationScreenPreview() {
    RietiTheme {
        ConfirmationScreen(
            folio = "ATZ-ZQ3D-NY8E",
            onFinish = {}
        )
    }
}
