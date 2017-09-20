package it.com.ibm.generali.CapitalReporting.dto

open class ReportAvailabilityRespDTO(val isAvailable: Boolean,
                                     val response: String)
{
    constructor() : this(false, "")
}