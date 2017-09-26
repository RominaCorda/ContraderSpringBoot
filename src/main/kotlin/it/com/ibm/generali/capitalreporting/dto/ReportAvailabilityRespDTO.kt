package it.com.ibm.generali.capitalreporting.dto

open class ReportAvailabilityRespDTO(val isAvailable: Boolean,
                                     val response: String)
{
    constructor() : this(false, "")
}