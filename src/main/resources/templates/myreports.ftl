<#-- @ftlvariable name="reports" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Report>" -->
<h5>My last reports</h5>

<table class="hover">
    <thead>
    <tr>
        <th width="200">Date</th>
        <th width="200">Template</th>
        <th>Simulation ID</th>
        <th width="50">&nbsp;</th>
        <th width="50">&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <#if reports!?size gt 0>
        <#list reports as report>
        <tr>
            <td><a href="/report?id=${report.id}">${report.created?date}</a></td>
            <td>${report.template}</td>
            <td>${report.simulationId?c}</td>
            <td><a href="/report?id=${report.id}"><i class="fi-download"></i></a>&nbsp;</td>
            <td><a href="/report?id=${report.id}"><i class="fi-play"></i></a>&nbsp;</td>
        </tr>
        </#list>
    <#else>
    <tr>
        <td colspan="5">No reports found for ${user.username?capitalize}</td>
    </tr>
    </#if>

    </tbody>
</table>