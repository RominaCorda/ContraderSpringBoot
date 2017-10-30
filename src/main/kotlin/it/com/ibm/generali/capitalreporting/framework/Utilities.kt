package it.com.ibm.generali.capitalreporting.framework

import it.com.ibm.generali.capitalreporting.model.ScopeType

object Utilities
{
    fun getScopeType(scopeType: String): ScopeType =
            if (scopeType.toLowerCase() == "official")
                ScopeType.OFFICIAL
            else
                ScopeType.ANALYSIS

}