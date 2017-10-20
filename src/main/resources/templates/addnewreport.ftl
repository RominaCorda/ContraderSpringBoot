<#-- @ftlvariable name="simulationid" type="java.lang.String" -->
<#-- @ftlvariable name="scopedesc" type="java.lang.String" -->
<#-- @ftlvariable name="report" type="it.com.ibm.generali.capitalreporting.model.Report" -->
<#-- @ftlvariable name="template" type="it.com.ibm.generali.capitalreporting.model.Template" -->
<#-- @ftlvariable name="templates" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Template>" -->
<#-- @ftlvariable name="tags" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Tag>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->

<!-- REPORT FORM -->
<form id="addreportform" method="post" action="">
    <div class="row columns">
        <h3>Add new report</h3>
    </div>
    <div class="row">
        <div class="medium-6 large-5 columns">
            <input id="templateid" name="templateid" type="hidden" value="${template.id?c}">
            <label>
                Template
                <select id="selecttemplate" name="selecttemplate">
                    <#list templates as xtemplate>
                        <#if xtemplate.id==template.id>
                            <option value="addnewreport?scopeid=${scopeid}&templateid=${xtemplate.id?c}"
                                    selected="selected">${xtemplate.name}</option>
                        <#else>
                            <option value="addnewreport?scopeid=${scopeid}&templateid=${xtemplate.id?c}">${xtemplate.name}</option>
                        </#if>
                    </#list>
                </select>
            </label>
            <label>
                Simulation ID:
                <select id="simulationids" name="simulationids">
                    <option value="${template.simulationId}" selected="selected">${template.simulationId}</option>
                    <option value="SE929">SE929</option>
                    <option value="FK230">FK230</option>
                    <option value="MK329">MK329</option>
                    <option value="AA232">AA232</option>
                </select>
            </label>
            <label>
                Node ID:
                <select id="nodeids" name="nodeids">
                    <option value="${template.nodeId}" selected="selected">${template.nodeId}</option>
                    <option value="121">DE012</option>
                    <option value="122">IT000</option>
                    <option value="123">IT101</option>
                    <option value="124">BG301</option>
                </select>
            </label>
            <label>
                Scope:
                <input id="scopedesc" type="text" value="${scopedesc}" readonly>
            </label>
        </div>
        <div class="medium-6 large-7 columns">
            <label>
                Name:
                <input id="reportname" name="reportname" type="text" required>
            </label>
            <label>
                Manual Adjustments:
                <select id="manadjustment" name="manadjustment">
                    <option value="1">01</option>
                    <option value="2">02</option>
                    <option value="3">03</option>
                    <option value="4">04</option>
                    <option value="5">05</option>
                </select>
            </label>
        </div>
    </div>
    <div class="row">
        <div class="columns">
            <div class="float-right">
                <input type="submit" value="Save" class="button">
            </div>
        </div>
    </div>
</form>
<!-- END REPORT FORM -->
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script src="js/addnewreport.js"></script>
</#macro>

<@skeleton/>


