package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Report
import it.com.ibm.generali.capitalreporting.model.Scope
import it.com.ibm.generali.capitalreporting.model.User
import org.springframework.data.repository.CrudRepository

interface ReportDao : CrudRepository<Report, Long>
{
    fun findByUser(user: User): List<Report>
    fun findByScopeOrderByCreated(scope: Scope): List<Report>
    fun findTop5ByUserOrderByCreated(user: User): List<Report>
}