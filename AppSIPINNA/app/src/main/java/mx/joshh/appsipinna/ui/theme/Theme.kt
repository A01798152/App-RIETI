package mx.joshh.appsipinna.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

/**
 * Tema único de la app RIETI.
 *
 * No hay variante oscura ni color dinámico de Material You: la identidad de
 * SIPINNA depende de la paleta pastel, y dejar que Android la reemplace por el
 * fondo de pantalla del usuario rompería el reconocimiento de marca.
 *
 * En MainActivity llama enableEdgeToEdge() antes de setContent { } para que las
 * barras del sistema tomen el fondo crema.
 */
@Composable
fun RietiTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalStatusColors provides StatusColors()
    ) {
        MaterialTheme(
            colorScheme = RietiLightColorScheme,
            typography = RietiTypography,
            shapes = RietiShapes,
            content = content
        )
    }
}

/** Atajos de lectura: RietiTheme.spacing.lg, RietiTheme.statusColors.atendidoContainer */
object RietiTheme {
    val spacing: Spacing
        @Composable get() = LocalSpacing.current

    val statusColors: StatusColors
        @Composable get() = LocalStatusColors.current
}