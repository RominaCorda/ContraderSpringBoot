package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Simulation
import org.springframework.data.repository.CrudRepository

interface SimulationDao : CrudRepository<Simulation, Long>
{
    fun findByReportingPeriod(reportingPeriod: String): List<Simulation>
}
