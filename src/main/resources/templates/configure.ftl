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
                <label>Selected User
                    <input id="username" name="username" type="text" value="${selecteduser.username}" readonly>
                </label>
                <div class="stacked button-group">
                    <a href="configure?delete=${selecteduser.username}" class="button alert"><i
                            class="fi-x"></i>&nbsp;
                        Delete</a>
                    <a href="searchusers" class="button secondary"><i class="fi-list"></i>&nbsp;Users List</a>
                    <ul class="accordion" data-accordion data-allow-all-closed="true">
                        <li class="accordion-item" data-accordion-item>
                            <!-- Accordion tab title -->
                            <a href="#" class="accordion-title button secondary"> <i class="fi-page-copy"></i>&nbsp;Copy</a>
                            <!-- Accordion tab content: it would start in the open state due to using the `is-active` state class. -->
                            <div class="accordion-content" data-tab-content>
                                <label for="copy-user-val">Choose a username</label>
                                <input id="copy-user-val" type="text">
                                <a id="btn-copy-user" class="button" href="">Copy<a>
                            </div>
                        </li>
                    </ul>

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
                        <#if mode=="new">
                            <input id="username" name="username" type="text" placeholder="Unique username here"
                                   required>
                        <#else>
                            <input id="username" name="username" type="text" value="${selecteduser.username}" readonly>
                        </#if>
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
                    <label>Tags:
                        <select multiple id="usertags" name="usertags">
                            <#list tags as tag>
                                <#if selecteduser.usertags?seq_contains(tag)>
                                <option value="${tag.id}" selected="selected">
                                <#else>
                                <option value="${tag.id}">
                                </#if>
                            ${tag.name}
                            </option>
                            </#list>
                        </select>
                    </label>
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
                    <input type="submit" value="Save changes" class="primary button float-right">
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
