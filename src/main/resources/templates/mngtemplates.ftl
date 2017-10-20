<#-- @ftlvariable name="templates" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.Template>" -->

<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row">
    <div class="small-6 large-6 columns">
        <div class="row">
            <h3>Manage Templates</h3>
        </div>
        <div class="row">
            <form id="addtemplate" method="post" action="">
                <table id="templatestable">
                    <thead>
                    <tr>
                        <th width="330">Template</th>
                        <th width="30">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list templates as template>
                        <tr>
                            <td>${template.name}</td>
                            <td><a href="templates?delete=${template.id}"><i class="fi-x"></i></td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="row">
            <button id="addnew" class="button secondary float-right">
                <i class="fi-plus"></i>&nbsp;Add
            </button>
        </div>
    </div>
    <div class="small-6 large-6 columns">
        &nbsp;
    </div>
</div>
<div class="row">
    &nbsp;
</div>
<div class="row">
    &nbsp;
</div>
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script src="js/templates.js"></script>
</#macro>

<@skeleton/>
