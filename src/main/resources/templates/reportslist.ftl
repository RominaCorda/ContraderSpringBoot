<#-- @ftlvariable name="mode" type="java.lang.String" -->
<#-- @ftlvariable name="selscope" type="it.com.ibm.generali.capitalreporting.model.Scope" -->
<#-- @ftlvariable name="report" type="it.com.ibm.generali.capitalreporting.model.Report" -->
<#-- @ftlvariable name="parents" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#-- @ftlvariable name="reports" type="java.util.List<it.com.ibm.generali.capitalreporting.framework.Report>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row column">

    <div class="row">
        <div class="columns">
            <h3>Reports</h3>
            <nav aria-label="You are here:" role="navigation">
                <ul class="breadcrumbs">
                    <li>
                        <a href="browse?mode=${mode}">${mode}</a>
                    </li>
                    <#list parents?reverse as parent>
                        <li>
                            <a href="scopes?parent=${parent.id}&mode=${mode}">${parent.name}</a>
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
                    <th width="150">Name</th>
                    <th width="150">Template</th>
                    <th width="150">Date Created</th>
                    <th>Created by</th>
                    <th width="200">Reporting Period</th>
                    <th width="150">Simulation</th>
                    <th width="40">Info</th><!-- View -->
                    <th width="40"></th><!-- Download -->
                </tr>
                </thead>
                <tbody>

                    <#list reports as report>
                    <tr>
                        <td><a href="report?id=${report.id?c}">${report.name}</a></td>
                        <td>
                        <span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover="false"
                              title="Node ID=${report.template.nodeId}">
                        ${report.template.name}
                        </span>
                        </td>
                        <td>${report.created?date}</td>
                        <td>${report.user.fullName}</td>
                        <td>${report.reportingPeriod}</td>
                        <td>${report.template.simulationId}</td>
                        <td><a href="report?id=${report.id?c}"><i class="fi-play"></i></a>&nbsp;</td>
                        <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                    </tr>
                    </#list>

                </tbody>
            </table>
        </div>
    </div>

    <div class="row columns">
        <a href="addnewreport?scopeid=${selscope.id}" class="success button float-right">
            <i class="fi-plus">&nbsp;</i>Generate New
        </a>
    </div>

    <div class="row columns">
        <br>&nbsp;<br>
    </div>

</div>
<!-- END OF MAIN -->
</#macro>

<@skeleton/>


