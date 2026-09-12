package mx.joshh.appsipinna.data

import kotlinx.coroutines.delay
import mx.joshh.appsipinna.model.EstatusReporte
import mx.joshh.appsipinna.model.Frecuencia
import mx.joshh.appsipinna.model.Reporte
import mx.joshh.appsipinna.model.TipoActividad
import java.time.LocalDate

sealed interface LookupError {
    data object FolioNoEncontrado : LookupError
    data object ErrorDeConexion : LookupError
}

class LookupErrorException(val error: LookupError) : Exception()

interface ReportRepository {
    suspend fun crearReporte(reporte: Reporte): Result<String>
    suspend fun consultarPorFolio(folio: String): Result<Reporte>
}

object FakeReportRepository : ReportRepository {
    private val reportes = mutableListOf<Reporte>()

    init {
        // Precarga de 3 reportes de ejemplo con estatus distintos
        reportes.add(
            Reporte(
                folio = "ATZ-XJ4K-W9PR",
                tipoActividad = TipoActividad.COMERCIO_INFORMAL,
                latitud = 19.5546,
                longitud = -99.2476,
                nombreLugar = "Mercado Central Atizapán",
                descripcion = "Niño de aproximadamente 8 años vendiendo chicles en la entrada.",
                numeroMenores = 1,
                edadAproximada = "8",
                horario = "Tarde",
                frecuencia = Frecuencia.DIARIO,
                evidenciaUri = null,
                correo = "anonimo1@correo.com",
                estatus = EstatusReporte.RECIBIDO,
                fechaRegistro = LocalDate.now().minusDays(1)
            )
        )
        reportes.add(
            Reporte(
                folio = "ATZ-B7M2-QW3F",
                tipoActividad = TipoActividad.CONSTRUCCION,
                latitud = 19.5600,
                longitud = -99.2500,
                nombreLugar = "Obra Residencial",
                descripcion = "Varios menores ayudando en la mezcla de cemento sin equipo.",
                numeroMenores = 3,
                edadAproximada = "10-14",
                horario = "Mañana",
                frecuencia = Frecuencia.VARIAS_VECES_SEMANA,
                evidenciaUri = null,
                correo = "test2@correo.com",
                estatus = EstatusReporte.EN_REVISION,
                fechaRegistro = LocalDate.now().minusDays(3)
            )
        )
        reportes.add(
            Reporte(
                folio = "ATZ-YR8N-V5TC",
                tipoActividad = TipoActividad.TRABAJO_DOMESTICO,
                latitud = 19.5400,
                longitud = -99.2300,
                nombreLugar = "Casa particular",
                descripcion = "Menor realizando labores de limpieza pesada.",
                numeroMenores = 1,
                edadAproximada = "12",
                horario = "Todo el día",
                frecuencia = Frecuencia.DIARIO,
                evidenciaUri = null,
                correo = "user3@correo.com",
                estatus = EstatusReporte.ATENDIDO,
                fechaRegistro = LocalDate.now().minusDays(7)
            )
        )
    }

    override suspend fun crearReporte(reporte: Reporte): Result<String> {
        delay(800)
        val nuevoFolio = generarFolio()
        val reporteConFolio = reporte.copy(
            folio = nuevoFolio,
            fechaRegistro = LocalDate.now(),
            estatus = EstatusReporte.RECIBIDO
        )
        reportes.add(reporteConFolio)
        return Result.success(nuevoFolio)
    }

    override suspend fun consultarPorFolio(folio: String): Result<Reporte> {
        delay(800)
        val reporte = reportes.find { it.folio.equals(folio, ignoreCase = true) }
        return if (reporte != null) {
            Result.success(reporte)
        } else {
            Result.failure(LookupErrorException(LookupError.FolioNoEncontrado))
        }
    }

    private fun generarFolio(): String {
        // Formato ATZ-XXXX-XXXX
        // Excluye O, 0, I, 1, L
        val allowedChars = "ABCDEFGHJKMNPQRSTUVWXYZ23456789"
        fun randomSegment() = (1..4)
            .map { allowedChars.random() }
            .joinToString("")

        return "ATZ-${randomSegment()}-${randomSegment()}"
    }
}
