<#-- @ftlvariable name="reportingperiod" type="java.lang.String" -->
<#-- @ftlvariable name="reportingperiods" type="java.util.List<java.lang.String>" -->
<#-- @ftlvariable name="simulations" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Simulation>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row columns">

    <div class="row columns">
        <h3>Manage Simulations</h3>
    </div>

    <div class="row">
        <div class="large-4 medium-5 columns">
            <select onchange="gotourl(value);">
                <#list reportingperiods as year>
                    <#if reportingperiod==year>
                        <option value="${year}" selected="selected">${year}</option>
                    <#else>
                        <option value="${year}">${year}</option>
                    </#if>
                </#list>
            </select>
        </div>
    </div>

    <div class="row columns">
        <table id="tagstable">
            <thead>
            <tr>
                <th width="100">ID</th>
                <th>Name</th>
                <th width="130">Created</th>
                <th width="130">User</th>
                <th width="130">Official</th>
            </tr>
            </thead>
            <tbody>
                <#list simulations as simulation>
                <tr>
                    <td>${simulation.id}</td>
                    <td>${simulation.name}</td>
                    <td>${simulation.created?date}</td>
                    <td>${simulation.user.fullName}</td>
                    <td>
                        <#if simulation.official>
                            <input type="checkbox" checked="checked">
                        <#else>
                            <input type="checkbox">
                        </#if>

                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>

    <div class="row columns">
        <button class="button float-right">Save</button>
    </div>

</div>
<div class="row column" style="margin-top: 100px">
    &nbsp;
</div>
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script src="js/simulations.js"></script>
</#macro>

<@skeleton/>


