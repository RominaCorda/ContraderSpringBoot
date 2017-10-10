package it.com.ibm.generali.capitalreporting.framework

import it.com.ibm.generali.capitalreporting.model.ScopeType

object Utilities
{
    fun getScopeType(scopeType: String): ScopeType
    {
        var type = ScopeType.ANALYSIS
        if (scopeType.toLowerCase() == "official")
            type = ScopeType.OFFICIAL
        return type
    }
}