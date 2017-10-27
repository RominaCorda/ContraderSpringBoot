<#-- @ftlvariable name="permissionsIds" type="java.util.List<java.lang.Long>" -->
<#-- @ftlvariable name="permissions" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Permission>" -->
<#-- @ftlvariable name="role" type="it.com.ibm.generali.capitalreporting.model.Role" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row">
    <div class="small-12 medium-6 large-6">
        <h3>Manage Role <i class="generali">${role.description}</i></h3>
    </div>
</div>

<form id="editroleform" method="post" action="">

    <div class="row">
        <div class="small-12 medium-6 large-6">
            <label>
                Role Name:
                <input id="rolename" name="rolename" type="text" value="${role.description}">
                <input id="roleid" name="roleid" type="hidden" value="${role.id}">
            </label>
        </div>
    </div>

    <div class="row">
        <div class="small-12 medium-6 large-6">
            <label>
                Role Permissions:
                <select id="rolepermissions" name="rolepermissions" multiple style="height: 300px">
                    <#list permissions as permission>
                        <#if permissionsIds?seq_contains(permission.id)>
                            <option name="permission" selected="selected">${permission.description}</option>
                        <#else>
                            <option name="permission">${permission.description}</option>
                        </#if>
                    </#list>
                </select>
            </label>
        </div>
    </div>

    <div class="row columns">
        <div class="small-12 medium-6 large-6">
            <div class="button-group float-right">
                <a href="roles" class="button secondary">Back</a>
                <input type="submit" class="button" value="Save">
            </div>
        </div>
    </div>

</form>

<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script></script>
</#macro>

<@skeleton/>


