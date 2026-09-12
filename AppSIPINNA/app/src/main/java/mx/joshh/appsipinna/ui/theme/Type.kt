package mx.joshh.appsipinna.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

/* ---------------------------------------------------------------------------
 * FUENTES
 *
 * Por ahora ambas familias apuntan a la fuente del sistema (Roboto) para que el
 * proyecto compile sin descargar nada. La escala, los pesos y el interlineado
 * ya son los definitivos, así que la app se ve correcta desde hoy.
 *
 * PARA ACTIVAR LAS FUENTES REALES (hazlo cuando quieras, no urge):
 *   1. Descarga Nunito e Inter de fonts.google.com (son gratuitas, licencia OFL).
 *   2. En Android Studio: clic derecho en res > New > Android Resource Directory
 *      > Resource type: font. Se crea res/font/.
 *   3. Copia ahí estos seis archivos, renombrados EXACTAMENTE así
 *      (Android rechaza mayúsculas y guiones medios):
 *         nunito_semibold.ttf   inter_regular.ttf
 *         nunito_bold.ttf       inter_medium.ttf
 *         nunito_extrabold.ttf  inter_semibold.ttf
 *   4. Descomenta el bloque de abajo, borra las dos líneas de FontFamily.Default
 *      y agrega este import:  import mx.joshh.appsipinna.R
 *
 * No hace falta cambiar nada más: el resto del archivo ya usa Nunito e Inter.
 * ------------------------------------------------------------------------- */

val Nunito = FontFamily.Default
val Inter = FontFamily.Default

/*
val Nunito = FontFamily(
    Font(R.font.nunito_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_extrabold, FontWeight.ExtraBold)
)

val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold)
)
*/

/** Centra el texto dentro de su caja de línea; evita títulos "flotando" arriba. */
private val TrimAlign = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

val RietiTypography = Typography(

    // --- Nunito: voz de la marca. Títulos de pantalla y momentos grandes. ---
    displaySmall = TextStyle(
        fontFamily = Nunito, fontWeight = FontWeight.ExtraBold,
        fontSize = 34.sp, lineHeight = 42.sp, letterSpacing = (-0.5).sp,
        lineHeightStyle = TrimAlign
    ),
    headlineLarge = TextStyle(
        fontFamily = Nunito, fontWeight = FontWeight.Bold,
        fontSize = 30.sp, lineHeight = 38.sp, letterSpacing = (-0.4).sp,
        lineHeightStyle = TrimAlign
    ),
    headlineMedium = TextStyle(
        fontFamily = Nunito, fontWeight = FontWeight.Bold,
        fontSize = 26.sp, lineHeight = 34.sp, letterSpacing = (-0.3).sp,
        lineHeightStyle = TrimAlign
    ),
    headlineSmall = TextStyle(
        fontFamily = Nunito, fontWeight = FontWeight.Bold,
        fontSize = 22.sp, lineHeight = 30.sp, letterSpacing = (-0.2).sp,
        lineHeightStyle = TrimAlign
    ),
    titleLarge = TextStyle(
        fontFamily = Nunito, fontWeight = FontWeight.Bold,
        fontSize = 19.sp, lineHeight = 26.sp,
        lineHeightStyle = TrimAlign
    ),

    // --- Inter: interfaz. Etiquetas de campo, ayudas, botones. ---
    titleMedium = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.1.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.Normal,
        fontSize = 16.sp, lineHeight = 25.sp, letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.Normal,
        fontSize = 14.sp, lineHeight = 22.sp, letterSpacing = 0.15.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.Normal,
        fontSize = 12.sp, lineHeight = 18.sp, letterSpacing = 0.2.sp
    ),
    labelLarge = TextStyle(   // texto de botones
        fontFamily = Inter, fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.Medium,
        fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.3.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Inter, fontWeight = FontWeight.Medium,
        fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.3.sp
    )
)

/**
 * Estilo exclusivo del folio de seguimiento (RF-17, RF-19).
 * Monoespaciada por una razón funcional, no estética: el ciudadano tiene que
 * leer y transcribir un código como ATZ-ZQ3D-NY8E y necesita distinguir
 * 0 de O y 1 de I. No usar esta fuente en ningún otro lugar de la app.
 */
val FolioTextStyle = TextStyle(
    fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold,
    fontSize = 26.sp, lineHeight = 34.sp, letterSpacing = 2.sp
)