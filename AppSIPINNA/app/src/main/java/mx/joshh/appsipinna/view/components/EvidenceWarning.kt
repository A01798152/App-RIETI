package mx.joshh.appsipinna.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.view.theme.RietiTheme

@Composable
fun EvidenceWarning(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(RietiTheme.spacing.md)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(RietiTheme.spacing.xs)
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier
                    .size(RietiTheme.spacing.xl)
                    .padding(top = 2.dp)
            )
            Text(
                text = stringResource(R.string.advertencia_evidencia),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier.padding(start = RietiTheme.spacing.md)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EvidenceWarningPreview() {
    RietiTheme {
        EvidenceWarning(modifier = Modifier.padding(RietiTheme.spacing.lg))
    }
}
