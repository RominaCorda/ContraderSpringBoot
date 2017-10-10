package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.CapitalUser
import it.com.ibm.generali.capitalreporting.model.Report
import it.com.ibm.generali.capitalreporting.model.Scope
import org.springframework.data.repository.CrudRepository

interface ReportDao : CrudRepository<Report, Long>
{
    fun findByUser(capitalUser: CapitalUser): List<Report>
    fun findByScopeOrderByCreated(scope: Scope): List<Report>
    fun findTop5ByUserOrderByCreated(capitalUser: CapitalUser): List<Report>
}