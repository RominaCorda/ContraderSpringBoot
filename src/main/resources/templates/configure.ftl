<#-- @ftlvariable name="roles" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.Role>" -->
<#-- @ftlvariable name="selecteduser" type="it.com.ibm.generali.capitalreporting.model.User" -->
<#-- @ftlvariable name="users" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.User>" -->
<#-- @ftlvariable name="mode" type="String" -->
<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">

    <div class="small-5 large-5 columns">

    <#if mode?starts_with("ok")>
        <div class="row">
            <div class="callout success" data-closable>
                <#if mode == "ok_added">
                    <b>User has been added</b>
                <#elseif mode == "ok_modified">
                    <b>User has been modified</b>
                <#elseif mode == "ok_deleted">
                    <b>User has been deleted</b>
                </#if>
                <button class="close-button" aria-label="Dismiss alert" type="button" data-close>
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
    </#if>

        <div class="row">
        <#if mode == "none" || mode == "ok_added" || mode=="ok_modified" || mode=="ok_deleted">
            <h3>Configure users</h3>
        <#elseif mode == "new">
            <h3>Add new user</h3>
        <#else>
            <h3>Configure user <b>${mode}</b></h3>
        </#if>
        </div>

    <#if mode != "new">
        <div class="row">
            <label>Select User
                <select onchange="if (this.value) window.location.href='/configure?selecteduser='+this.value">
                    <#list users as user>
                        <#if selecteduser.username==user.username>
                        <option value="${user.username}" selected="selected">
                        <#else>
                        <option value="${user.username}">
                        </#if>
                    ${user.fullName}
                    </option>
                    </#list>
                </select>
            </label>
            <a href="/configure?delete=${selecteduser.username}" class="button alert float-left"><i class="fi-x"></i>&nbsp;
                Delete</a>
            <a href="/configure?selecteduser=new" class="button secondary float-right"><i class="fi-plus"></i>&nbsp; Add
                new</a>
        </div>
    </#if>




    </div>

    <div class="small-1 large-1 columns">
        &nbsp;
    </div>

    <div class="small-5 large-5 columns">
        <form name="user" action="" method="post" style="margin-top: 60px">
        <#if mode != "new">
            <div class="row">
                <div class="columns">
                    <p>Last modified: <i>August 28th, 2017</i></p>
                </div>

            </div>
        </#if>
            <div class="row">
                <div class="columns">
                    <label>User ID:
                        <input id="username" name="username" type="text" value="${selecteduser.username}">
                        <input id="password" name="password" type="hidden" value="***">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="columns">
                    <label>Full Name:
                        <input id="fullName" name="fullName" type="text" value="${selecteduser.fullName}">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="columns">
                    <label>eMail Address:
                        <input id="email" name="email" type="email" value="${selecteduser.email}">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="columns">
                    <label>Active:
                    <#if selecteduser.active>
                        <input id="active" name="active" type="checkbox" checked="checked">
                    <#else>
                        <input id="active" name="active" type="checkbox">
                    </#if>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="column medium-11 large-11">
                    <label>Role:
                        <select id="role" name="role">
                        <#list roles as role>
                            <#if selecteduser.role.id==role.id>
                            <option value="${role.id}" selected="selected">
                            <#else>
                            <option value="${role.id}">
                            </#if>
                        ${role.description}
                        </option>
                        </#list>
                        </select>
                    </label>
                </div>
                <div class="column medium-1 large-1">
                    <div style="margin-top: 30px" data-tooltip aria-haspopup="true" class="has-tip"
                         data-disable-hover="false" title="Edit roles">
                        <a href="/roles"><i class="fi-pencil"></i></a>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="columns">
                    <label>Tags:
                        <input id="tags" name="tags" type="text" placeholder="Input tags separated by comma.">
                    </label>
                </div>

            </div>
            <div class="row">
                <div class="columns">
                    <div class="button-group float-right">
                        <a class="secondary button" href="/index">Cancel</a>
                        <input type="submit" value="Submit" class="primary button">
                    </div>
                </div>
            </div>
        </form>
    </div>


</div>

<#include "footer.ftl">
<#include "foundation.ftl">


</body>
</html>
