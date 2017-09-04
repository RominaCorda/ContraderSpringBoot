<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">

    <div class="small-6 large-6 columns">

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
            <h3>Configure user ${mode}</h3>
        </#if>
        </div>

    <#if mode != "new">
        <div class="row">
            <label>Select User
                <select onchange="if (this.value) window.location.href='/configure?selecteduser='+this.value">
                    <#list users as user>
                        <option value="${user.username}">${user.fullName}</option>
                    </#list>
                </select>
            </label>
            <a href="/configure?delete=${selecteduser.username}" class="button alert float-left"><i class="fi-x"></i>&nbsp;
                Delete</a>
            <a href="/configure?selecteduser=new" class="button secondary float-right"><i class="fi-plus"></i>&nbsp; Add
                new</a>
        </div>
    </#if>

        <form name="user" action="" method="post">
        <#if mode != "new">
            <div class="row">
                <p>Last modified: <i>August 28th, 2017</i></p>
            </div>
        </#if>
            <div class="row">
                <label>User ID:
                    <input id="username" name="username" type="text" value="${selecteduser.username}">
                    <input id="password" name="password" type="hidden" value="***">
                </label>
            </div>
            <div class="row">
                <label>Full Name:
                    <input id="fullName" name="fullName" type="text" value="${selecteduser.fullName}">
                </label>
            </div>
            <div class="row">
                <label>eMail Address:
                    <input id="email" name="email" type="email" value="${selecteduser.email}">
                </label>
            </div>
            <div class="row">
                <label>Active:
                <#if selecteduser.active>
                    <input id="active" name="active" type="checkbox" checked="checked">
                <#else>
                    <input id="active" name="active" type="checkbox">
                </#if>
                </label>
            </div>
            <div class="row">
                <label>Role:
                    <select id="role" name="role">
                    <#list roles as role>
                        <option value="${role.description}">${role.description}</option>
                    </#list>
                    </select>
                </label>
            </div>
            <div class="row">
                <label>Tags:
                    <input id="tags" name="tags" type="text" placeholder="Input tags separated by comma.">
                </label>
            </div>
            <div class="row">
                <div class="button-group float-right">
                    <a class="secondary button" href="/index">Cancel</a>
                    <input type="submit" value="Submit" class="primary button">
                </div>
            </div>
        </form>


    </div>

    <div class="small-6 large-6 columns">
        &nbsp;
    </div>


</div>

<#include "footer.ftl">
<#include "foundation.ftl">


</body>
</html>
