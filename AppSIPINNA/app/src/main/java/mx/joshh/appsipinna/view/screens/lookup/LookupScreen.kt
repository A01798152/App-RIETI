package mx.joshh.appsipinna.view.screens.lookup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.view.components.RietiButton
import mx.joshh.appsipinna.view.components.RietiTextField
import mx.joshh.appsipinna.view.components.RietiTopAppBar
import mx.joshh.appsipinna.view.theme.RietiTheme

@Composable
fun LookupScreen(
    onConsultarClick: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var folio by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            RietiTopAppBar(
                title = stringResource(R.string.lookup_titulo),
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            RietiButton(
                text = stringResource(R.string.boton_consultar),
                onClick = { onConsultarClick(folio) },
                enabled = folio.isNotBlank(),
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
                .padding(top = RietiTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(RietiTheme.spacing.xl)
        ) {
            Text(
                text = stringResource(R.string.lookup_instrucciones),
                style = MaterialTheme.typography.bodyLarge
            )

            RietiTextField(
                value = folio,
                onValueChange = { folio = it.uppercase() },
                label = stringResource(R.string.lookup_label_folio),
                placeholder = stringResource(R.string.lookup_placeholder_folio)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LookupScreenPreview() {
    RietiTheme {
        LookupScreen(onConsultarClick = {}, onBackClick = {})
    }
}
