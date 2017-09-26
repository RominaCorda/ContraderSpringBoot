package it.com.ibm.generali.capitalreporting.dto

open class ReportAvailabilityReqDTO(val environmentId: String,
                                    val reportId: String,
                                    val reportFile: String)
{
    constructor() : this("", "", "")
}
