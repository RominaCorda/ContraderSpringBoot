<#-- @ftlvariable name="tags" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.UserTag>" -->
<#-- @ftlvariable name="roles" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.Role>" -->
<#-- @ftlvariable name="selecteduser" type="it.com.ibm.generali.capitalreporting.model.CapitalUser" -->
<#-- @ftlvariable name="users" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.CapitalUser>" -->
<#-- @ftlvariable name="mode" type="String" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row">

    <div class="small-3 medium-3 large-3 columns">
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
                <h3>Add new User</h3>
            <#else>
                <h3>Configure User</h3>
            </#if>
        </div>
        <#if mode != "new">
            <div class="row">
                <label>Select User
                    <select onchange="if (this.value) window.location.href='configure?selecteduser='+this.value">
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
                <a href="configure?delete=${selecteduser.username}" class="button alert float-left"><i class="fi-x"></i>&nbsp;
                    Delete</a>
                <a href="configure?selecteduser=new" class="button secondary float-right"><i class="fi-plus"></i>&nbsp;
                    Add
                    new</a>
                <a style="float:right" class="button secondary" onclick="showCopyUser()">
                    <i class="fi-page-copy"></i>&nbsp;Copy
                </a>
                <div id="copy-user" hidden>
                    <label>Choose a username</label>
                    <input id="copy-user-val" type="text"></input>
                    <a id="btn-copy-user" class="button" href="">Copy<a>
                </div>
            </div>
        </#if>
    </div>

    <div class="medium-1 medium-1 large-1 columns">
        &nbsp;
    </div>

    <div class="small-9 medium-8 large-8 columns">
        <form data-abide novalidate name="userform" action="" method="post" style="margin-top: 60px">
            <div class="row">
                <div class="column medium-10 large-10">
                    <label>User ID:
                        <input id="username" name="username" type="text" value="${selecteduser.username}" readonly>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="column medium-10 large-10">
                    <label>Full Name:
                        <input id="fullName" name="fullName" type="text" value="${selecteduser.fullName}" required>
                        <span class="form-error">This field cannot be blank</span>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="column medium-10 large-10">
                    <label>eMail Address:
                        <input id="email" name="email" type="email" value="${selecteduser.email}" required>
                        <span class="form-error">Not a valid e-mail</span>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="column medium-10 large-10">
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
                <div class="column medium-10 large-10">
                    <label>Roles:
                        <select multiple id="roles" name="roles">
                            <#list roles as role>
                                <#if selecteduser.roles?seq_contains(role)>
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
                        <span class="float-left">
                            <a href="roles"><i class="fi-pencil"></i></a>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column medium-10 large-10">
                    <#if tags??>
                        <fieldset name="usertags">
                            <legend>User Tags:</legend>
                            <#list tags as tag>
                                <#if selecteduser.usertags?seq_contains(tag)>
                                    <input id="chk${tag.name}" type="checkbox" value="${tag.name}" checked="checked">
                                <#else>
                                    <input id="chk${tag.name}" type="checkbox" value="${tag.name}">
                                </#if>
                                <label for="chk${tag.name}">${tag.name}</label>
                            </#list>
                        </fieldset>
                    </#if>
                </div>
                <div class="column medium-1 large-1">
                    <div style="margin-top: 30px" data-tooltip aria-haspopup="true" class="has-tip"
                         data-disable-hover="false" title="Edit User tags">
                        <span class="float-left">
                            <a href="usertags"><i class="fi-pencil"></i></a>
                        </span>
                    </div>
                </div>
            </div>
            <#if mode != "new">
                <div class="row">
                    <div class="columns">
                        <p>Last modified: <i>August 28th, 2017</i></p>
                    </div>
                </div>
            </#if>
            <div class="row">
                <div class="column medium-10 large-10">
                    <p>&nbsp;</p>
                    <input type="submit" value="Save" class="primary button float-right">
                </div>
            </div>

        </form>
    </div>


</div>
<!-- END OF MAIN -->
</#macro>
<#macro  before_end_scripts>
<script src="js/users.js"></script>
</#macro>

<@skeleton/>
