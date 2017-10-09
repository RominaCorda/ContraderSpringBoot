<#-- @ftlvariable name="simulationid" type="java.lang.String" -->
<#-- @ftlvariable name="scopedesc" type="java.lang.String" -->
<#-- @ftlvariable name="report" type="it.com.ibm.generali.capitalreporting.model.Report" -->
<#-- @ftlvariable name="templates" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Template>" -->
<#-- @ftlvariable name="tags" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Tag>" -->
<#include "header.ftl">
<#include "topbar.ftl">

<br>

<!-- REPORT FORM -->
<form id="addreportform" method="post" action="">
    <div class="row columns">
        <h3>Add new report</h3>
    </div>
    <div class="row">
        <div class="medium-6 large-5 columns">
            <label>
                Simulation ID
                <input id="simulationid" name="simulationid" type="text" value="${simulationid}">
            </label>
            <label>
                Template
                <select id="template" name="template">
                <#list templates as template>
                    <option value="${template.name}">${template.name}</option>
                </#list>
                </select>
            </label>
            <label>
                Reporting Period
                <select id="reportingperiod" name="reportingperiod">
                    <option value="2013">2013</option>
                    <option value="2014">2014</option>
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                </select>
            </label>
            <label>
                Scope:
                <input type="text" value="${scopedesc}" readonly>
            </label>

        </div>
        <div class="medium-6 large-7 columns">
            <label>
                Created by:
                <input type="text" value="${capitalUser.fullName}" readonly>
            </label>
            <label>
                Tags:
                <select id="tags" name="tags" multiple style="height: 150px">
                <#list tags as tag>
                    <option value="${tag.id}">${tag.name}</option>
                </#list>
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

<div class="row columns">
    &nbsp;
</div>
<div class="row columns">
    &nbsp;
</div>
<div class="row columns">
    &nbsp;
</div>

<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>
