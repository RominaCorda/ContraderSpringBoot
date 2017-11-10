<#-- @ftlvariable name="user" type="it.com.ibm.generali.capitalreporting.model.CapitalUser" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row">
    <div class="small-6 large-6 columns">

        <form id="changepwdform" method="post" action="">

            <h3 class="userprofile">${user.username?capitalize} profile</h3>

            <div class="row">
                <label>Full Name:
                    <input id="fullname" name="fullname" type="text" value="${user.fullName}" disabled>
                </label>
            </div>

            <div class="row">
                <label>eMail Address:
                    <input id="email" name="email" type="email" value="${user.email}" disabled>
                </label>
            </div>

            <div class="row">
                <label>Roles:
                    <ul class="inline-list">
                        <#list user.roles as role>
                            <li><a href="#">${role.description}</a></li>
                        </#list>
                    </ul>
                </label>
            </div>

            <div class="row">
                <a class="secondary button float-right" href="index">Back</a>
            </div>

        </form>


    </div>
    <div class="small-6 large-6 columns">&nbsp;</div>

</div>
<!-- END OF MAIN -->
</#macro>

<@skeleton/>

