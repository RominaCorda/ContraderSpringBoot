package it.com.ibm.generali.CapitalReporting.dto

open class ReportAvailabilityReqDTO(val environmentId: String,
                                    val reportId: String,
                                    val reportFile: String)
{
    constructor() : this("", "", "")
}
