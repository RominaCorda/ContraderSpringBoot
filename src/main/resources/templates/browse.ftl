<#-- @ftlvariable name="mode" type="java.lang.String" -->
<#-- @ftlvariable name="scopes" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row column">

    <div class="row">
        <div class="columns">
            <h3>${mode?capitalize}</h3>
            <nav aria-label="You are here:" role="navigation">
                <ul class="breadcrumbs">
                    <li>
                        Years
                    </li>
                </ul>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="column medium-5 large-4">
            <div class="stacked button-group">
            <#list scopes as scope>
                <a href="/scopes?parent=${scope.id}&mode=${mode}" class="button primary">${scope.name}</a>
            </#list>
            </div>
        </div>
        <div class="column medium-7 large-8">
            &nbsp;
        </div>
    </div>

</div>

<div class="row column" style="margin-top: 400px">
    &nbsp;
</div>


<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>
