<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">

    <div class="small-6 large-6 columns">

        <div class="row">
            <h3>Configure users</h3>
        </div>

        <div class="row">
            <label>Select User
                <select onchange="if (this.value) window.location.href='/configure?selecteduser='+this.value">
                <#list users as user>
                    <option value="${user.username}">${user.fullName}</option>
                </#list>
                </select>
            </label>
        </div>

        <form>
            <div class="row">
                <p>Last modified: August 28th, 2017</p>
            </div>
            <div class="row">
                <label>User ID:
                    <input id="userid" name="userid" type="text" value="${selecteduser.username}">
                </label>
            </div>
            <div class="row">
                <label>Full Name:
                    <input id="fullname" name="fullname" type="text" value="${selecteduser.fullName}">
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
            <br>
            <div class="button-group float-right">
                <a class="secondary button" href="/index">Cancel</a>
                <input type="submit" value="Submit" class="primary button">
            </div>
        </form>

    </div>

    <div class="small-6 large-6 columns">
    </div>


</div>

<#include "footer.ftl">
<#include "foundation.ftl">


</body>
</html>
