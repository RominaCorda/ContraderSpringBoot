<#-- @ftlvariable name="scopes" type="java.util.List<it.com.ibm.generali.CapitalReporting.model.Scope>" -->
<#-- @ftlvariable name="parent" type="it.com.ibm.generali.CapitalReporting.model.Scope" -->
<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row column">
    <div class="row">
        <h3>Select report's scope</h3>
    </div>

    <div class="row">
        <nav aria-label="You are here:" role="navigation">
            <ul class="breadcrumbs">
                <li><a href="/browse">Years</a></li>
                <li>
                    Year ${parent.name}
                </li>
            </ul>
        </nav>
    </div>

    <div class="row">
    <#list scopes as scope>
        <a href="/archive?parent=${parent.id}&scope=${scope.id}" class="button primary">${scope.name} ${parent.name}</a>
    </#list>
    </div>

</div>

<div class="row column" style="margin-top: 400px">
    &nbsp;
</div>

<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>
