package mx.joshh.appsipinna.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import mx.joshh.appsipinna.R
import mx.joshh.appsipinna.ui.theme.RietiTheme

@Composable
fun LoadingState(
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.estado_cargando)
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(RietiTheme.spacing.minTouchTarget)
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = RietiTheme.spacing.lg)
        )
    }
}

@Composable
fun EmptyState(
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.estado_vacio),
    icon: ImageVector = Icons.Default.Info
) {
    BaseStateView(
        message = message,
        icon = icon,
        modifier = modifier
    )
}

@Composable
fun ErrorState(
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.estado_error),
    icon: ImageVector = Icons.Default.Warning
) {
    BaseStateView(
        message = message,
        icon = icon,
        iconColor = MaterialTheme.colorScheme.error,
        modifier = modifier
    )
}

@Composable
private fun BaseStateView(
    message: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    iconColor: Color = MaterialTheme.colorScheme.primary
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(RietiTheme.spacing.screenHorizontal),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(RietiTheme.spacing.xxl * 2)
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = RietiTheme.spacing.lg)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StatesPreview() {
    RietiTheme {
        Column {
            LoadingState(modifier = Modifier.weight(1f))
            EmptyState(modifier = Modifier.weight(1f))
        }
    }
}
