<#-- @ftlvariable name="mode" type="java.lang.String" -->
<#-- @ftlvariable name="scopes" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
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
                    <a href="scopes?parent=${scope.id?c}&mode=${mode}" class="button primary">${scope.name}</a>
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
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script></script>
</#macro>

<@skeleton/>
