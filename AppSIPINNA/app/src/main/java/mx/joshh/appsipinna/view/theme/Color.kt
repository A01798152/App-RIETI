package mx.joshh.appsipinna.view.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/* ---------------------------------------------------------------------------
 * Colores de marca RIETI / SIPINNA Atizapán.
 * Estos son los cuatro hex oficiales. Se usan tal cual para el logo,
 * ilustraciones y fondos amplios, NUNCA como color de texto.
 * ------------------------------------------------------------------------- */
object BrandRieti {
    val Rosa = Color(0xFFF29191)
    val Turquesa = Color(0xFF24B1B1)
    val Crema = Color(0xFFFFEED6)
    val Morado = Color(0xFFAF719D)
}

/* ---------------------------------------------------------------------------
 * Escalas tonales derivadas. Conservan el matiz de marca pero cubren el rango
 * de luminosidad que Material 3 necesita y que exige el RNF-07 (contraste).
 * ------------------------------------------------------------------------- */

// Turquesa (#24B1B1) -> acción principal
private val Teal10 = Color(0xFF002020)
private val Teal20 = Color(0xFF003738)
private val Teal30 = Color(0xFF005152)
private val Teal40 = Color(0xFF0E6E6E) // primary — 6.1:1 sobre blanco
private val Teal60 = Color(0xFF1E9797)
private val Teal80 = Color(0xFF7FD4D4)
private val Teal90 = Color(0xFFB8E9E9)

// Morado (#AF719D) -> apoyo, estados, chips informativos
private val Purple10 = Color(0xFF2E0F24)
private val Purple30 = Color(0xFF5C3350)
private val Purple40 = Color(0xFF7A4A6C) // secondary — 6.9:1 sobre blanco
private val Purple90 = Color(0xFFF5DEEB)

// Rosa (#F29191) -> aviso de privacidad del menor (RF-13)
private val Rose10 = Color(0xFF3B0A14)
private val Rose40 = Color(0xFF8E3B4B) // tertiary — 7.3:1 sobre blanco
private val Rose90 = Color(0xFFFFDDE2)

// Crema (#FFEED6) -> superficies
private val Cream99 = Color(0xFFFFFBF3)
private val Cream98 = Color(0xFFFFF8EC)
private val Cream96 = Color(0xFFFFF3E3)
private val Cream94 = Color(0xFFFBEBD8)
private val Cream92 = Color(0xFFF6E3CD)
private val Cream90 = Color(0xFFF0E2CE)

// Neutrales cálidos para texto y bordes
private val Ink = Color(0xFF26201A)
private val InkSoft = Color(0xFF55483A)
private val OutlineWarm = Color(0xFF877662)
private val OutlineSoft = Color(0xFFDCCCB4)

// Error: rojo funcional, deliberadamente fuera de la paleta de marca para no
// confundirse con el rosa del aviso de privacidad.
private val Error40 = Color(0xFFBA1A1A)
private val Error90 = Color(0xFFFFDAD6)
private val Error10 = Color(0xFF410002)

/* ---------------------------------------------------------------------------
 * Esquema claro. La app es solo modo claro: la paleta RIETI es pastel y una
 * versión oscura la desnaturaliza. Se fuerza en Theme.kt.
 * ------------------------------------------------------------------------- */
val RietiLightColorScheme = lightColorScheme(
    primary = Teal40,
    onPrimary = Color.White,
    primaryContainer = Teal90,
    onPrimaryContainer = Teal10,
    inversePrimary = Teal80,

    secondary = Purple40,
    onSecondary = Color.White,
    secondaryContainer = Purple90,
    onSecondaryContainer = Purple10,

    tertiary = Rose40,
    onTertiary = Color.White,
    tertiaryContainer = Rose90,
    onTertiaryContainer = Rose10,

    error = Error40,
    onError = Color.White,
    errorContainer = Error90,
    onErrorContainer = Error10,

    background = BrandRieti.Crema,
    onBackground = Ink,

    surface = Cream99,
    onSurface = Ink,
    surfaceVariant = Cream90,
    onSurfaceVariant = InkSoft,

    surfaceContainerLowest = Color.White,
    surfaceContainerLow = Cream98,
    surfaceContainer = Cream96,
    surfaceContainerHigh = Cream94,
    surfaceContainerHighest = Cream92,

    outline = OutlineWarm,
    outlineVariant = OutlineSoft,

    inverseSurface = Ink,
    inverseOnSurface = Cream98,
    scrim = Color(0xFF000000)
)

/* ---------------------------------------------------------------------------
 * Colores semánticos de dominio que Material 3 no cubre.
 * Los estatus del reporte vienen del RF-27: recibido, en revisión, atendido,
 * no procedente. Se exponen vía LocalStatusColors (ver Theme.kt).
 * ------------------------------------------------------------------------- */
data class StatusColors(
    val recibidoContainer: Color = Teal90,
    val onRecibidoContainer: Color = Teal20,
    val enRevisionContainer: Color = Purple90,
    val onEnRevisionContainer: Color = Purple30,
    val atendidoContainer: Color = Color(0xFFCDEBD3),
    val onAtendidoContainer: Color = Color(0xFF17492A),
    val noProcedenteContainer: Color = Cream92,
    val onNoProcedenteContainer: Color = InkSoft
)