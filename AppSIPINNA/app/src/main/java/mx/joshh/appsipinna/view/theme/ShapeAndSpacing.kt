package mx.joshh.appsipinna.view.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Radios amplios y consistentes. Vienen de los círculos del logo RIETI:
 * la app no debe verse como un formulario oficial rígido, porque la persona
 * que reporta suele estar incómoda o con prisa.
 */
val RietiShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),   // chips, badges de estatus
    small = RoundedCornerShape(12.dp),       // campos de texto
    medium = RoundedCornerShape(16.dp),      // tarjetas
    large = RoundedCornerShape(24.dp),       // hojas, contenedores grandes
    extraLarge = RoundedCornerShape(32.dp)   // bottom sheets, hero
)

/** Botones: cápsula completa, coherente con los redondeos del logotipo. */
val PillShape = RoundedCornerShape(percent = 50)

data class Spacing(
    /** 4dp — separación entre etiqueta y campo. */
    val xs: Dp = 4.dp,
    /** 8dp — dentro de un mismo componente. */
    val sm: Dp = 8.dp,
    /** 12dp — entre elementos relacionados. */
    val md: Dp = 12.dp,
    /** 16dp — padding interno de tarjetas. */
    val lg: Dp = 16.dp,
    /** 24dp — entre bloques de un formulario. */
    val xl: Dp = 24.dp,
    /** 32dp — entre secciones distintas. */
    val xxl: Dp = 32.dp,
    /** 48dp — respiro antes del pie de pantalla. */
    val huge: Dp = 48.dp,

    /** Margen lateral estándar de toda pantalla. */
    val screenHorizontal: Dp = 20.dp,
    /** Altura mínima táctil accesible (WCAG / Material). */
    val minTouchTarget: Dp = 48.dp
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }
val LocalStatusColors = staticCompositionLocalOf { StatusColors() }