package mx.joshh.appsipinna.model

import androidx.annotation.StringRes
import mx.joshh.appsipinna.R
import java.time.LocalDate

data class Reporte(
    val folio: String = "",
    val tipoActividad: TipoActividad,
    val latitud: Double,
    val longitud: Double,
    val nombreLugar: String,
    val descripcion: String,
    val numeroMenores: Int,
    val edadAproximada: String,
    val horario: String,
    val frecuencia: Frecuencia,
    val evidenciaUri: String?,
    val correo: String,
    val estatus: EstatusReporte = EstatusReporte.RECIBIDO,
    val fechaRegistro: LocalDate = LocalDate.now()
)

enum class TipoActividad(@StringRes val labelRes: Int) {
    AGRICULTURA(R.string.tipo_agricultura),
    CONSTRUCCION(R.string.tipo_construccion),
    COMERCIO_INFORMAL(R.string.tipo_comercio_informal),
    TRABAJO_DOMESTICO(R.string.tipo_trabajo_domestico),
    MANUFACTURA(R.string.tipo_manufactura),
    OTRO(R.string.tipo_otro)
}

enum class Frecuencia(@StringRes val labelRes: Int) {
    UNICA_VEZ(R.string.frecuencia_unica),
    OCASIONAL(R.string.frecuencia_ocasional),
    VARIAS_VECES_SEMANA(R.string.frecuencia_semanal),
    DIARIO(R.string.frecuencia_diario)
}

enum class EstatusReporte(@StringRes val labelRes: Int) {
    RECIBIDO(R.string.estatus_recibido),
    EN_REVISION(R.string.estatus_revision),
    ATENDIDO(R.string.estatus_atendido),
    NO_PROCEDENTE(R.string.estatus_no_procedente)
}
