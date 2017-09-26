package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Report
import org.springframework.data.repository.CrudRepository

interface ReportDao : CrudRepository<Report, Long>