<#-- @ftlvariable name="mode" type="java.lang.String" -->
<#-- @ftlvariable name="selscope" type="it.com.ibm.generali.capitalreporting.model.Scope" -->
<#-- @ftlvariable name="parents" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#-- @ftlvariable name="reports" type="java.util.List<it.com.ibm.generali.capitalreporting.framework.Report>" -->
<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row column">

    <div class="row">
        <div class="columns">
            <h3>Reports</h3>
            <nav aria-label="You are here:" role="navigation">
                <ul class="breadcrumbs">
                    <li>
                        <a href="/browse?mode=${mode}">${mode}</a>
                    </li>
                <#list parents?reverse as parent>
                    <li>
                        <a href="/scopes?parent=${parent.id}&mode=${mode}">${parent.name}</a>
                    </li>
                </#list>
                </ul>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="columns">
            <table class="hover">
                <thead>
                <tr>
                    <th width="50">ID</th>
                    <th width="150">Template</th>
                    <th width="150">Date Created</th>
                    <th>Created by</th>
                    <th width="200">Reporting Period</th>
                    <th width="150">Simulation ID</th>
                    <th width="50">View</th><!-- View -->
                    <th width="50"></th><!-- Download -->
                </tr>
                </thead>
                <tbody>

                <#list reports as report>
                <tr>
                    <td><a href="/report?id=${report.id}">${report.id}</a></td>
                    <td>${report.template}</td>
                    <td>${report.created?date}</td>
                    <td>${report.user.fullName}</td>
                    <td>${report.reportingPeriod}</td>
                    <td>${report.simulationId?c}</td>
                    <td><a href="/report?id=${report.id}"><i class="fi-play"></i></a>&nbsp;</td>
                    <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                </tr>
                </#list>

                </tbody>
            </table>
        </div>
    </div>

    <div class="row columns">
        <a href="/addnewreport?scopeid=${selscope.id}" class="success button float-right">
            <i class="fi-plus">&nbsp;</i>
        </a>
    </div>

    <div class="row columns">
        <br>&nbsp;<br>
    </div>

</div>

<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>

