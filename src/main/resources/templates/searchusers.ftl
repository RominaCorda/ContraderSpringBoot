<#-- @ftlvariable name="users" type="java.util.List<it.com.ibm.generali.capitalreporting.model.CapitalUser>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->

<div class="row columns">
    <div class="row columns">
        <h3>Search for Users</h3>
    </div>

    <div class="row columns">
        <form method="post" action="">
            <div class="row">
                <div class="small-12 medium-5 large-5 columns">
                    <label>Name
                        <input id="name" name="name" type="text" placeholder="User name contains...">
                    </label>
                </div>
                <div class="small-12 medium-7 large-7 columns">
                    <label>Tags
                        <input id="tags" name="tags" type="text"
                               placeholder="Comma delimited tags list (ie: india, life)">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-12 large-12 columns">
                    <input type="submit" class="button float-right" value="Search">
                </div>
            </div>
        </form>
    </div>
    <div class="row columns">&nbsp;</div>
    <div class="row columns">
        <!-- RESULTS HERE -->
        <#if users??>
            <div class="columns">
                <table class="hover">
                    <thead>
                    <tr>
                        <th width="150">Username</th>
                        <th width="200">Full Name</th>
                        <th width="250">eMail Address</th>
                        <th>Roles</th>
                        <th width="200">Tags</th>
                        <th width="40"></th><!-- View -->
                    </tr>
                    </thead>
                    <tbody>
                        <#list users as user>
                        <tr>
                            <td><a href="configure?selecteduser=${user.username}">${user.username}</a></td>
                            <td>${user.fullName}</td>
                            <td>${user.email}</td>
                            <td>${user.rolesString()}</td>
                            <td>${user.tagsString()}</td>
                            <td><a href="configure?selecteduser=${user.username}"><i class="fi-play"></i></a>&nbsp;</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </#if>
    </div>

</div>

<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script></script>
</#macro>

<@skeleton/>