<#-- @ftlvariable name="role" type="it.com.ibm.generali.capitalreporting.model.Role" -->
<#-- @ftlvariable name="permissions" type="type="java.util.List<String>" -->

<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="row columns">
        <h3>Manage Role ${role.description}</h3>
    </div>
</div>

<div class="row">
    <form>

        <div class="row">
            <div class="small-12 medium-6 large-6">
                <label>
                    Role Name:
                    <input id="rolename" name="rolename" type="text" value="${role.description}">
                </label>
            </div>
        </div>

        <div class="row">
            <div class="small-12 medium-6 large-6">
                <label>
                    Role Permissions:
                    <select multiple style="height: 300px">
                    <#list permissions as permission>
                        <#if role.id==1>
                            <option name="permission" selected="selected">${permission}</option>
                        <#elseif role.id==permissions?seq_index_of(permission)>
                            <option name="permission" selected="selected">${permission}</option>
                        <#else>
                            <option name="permission">${permission}</option>
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
                    <a href="roles" class="button">Submit</a>
                </div>
            </div>
        </div>

    </form>
</div>
<div class="row">
    &nbsp;
</div>

<#include "footer.ftl">
<#include "foundation.ftl">

