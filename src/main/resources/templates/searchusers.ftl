<#-- @ftlvariable name="users" type="java.util.List<it.com.ibm.generali.capitalreporting.model.CapitalUser>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->

<div class="row columns">
    <div class="row columns">
        <h3>Configure Users</h3>
    </div>

    <div class="row columns">
        <div class="row">
            <div class="small-12 medium-2 large-2 columns">
                <div class="button-group stacked secondary small" style="margin-top: 25px">
                    <a href="userscsvdownload" class="success button">Download...</a>
                    <a class="success button" onclick="showUpload()">
                        Upload...
                    </a>
                    <div id="upload" hidden>
                        <form method="POST" action="uploadUsersFile" enctype="multipart/form-data">
                            <input style="background: cadetblue" type="file" name="file" class="button">
                            <input style="width: 30%; margin: 0 35%;" class="button" type="submit" value="Upload">
                        </form>
                    </div>
                    <a href="configure?mode=new" class="button"><i class="fi-plus"></i>&nbsp;Add new</a>
                </div>
            </div>
            <div class="small-12 medium-10 large-10 columns">
                <div class="row">
                    <div class="columns">
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
                                    <input type="submit" class="small button success float-right" value="Filter">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- RESULTS HERE -->
                <div class="row">
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
                                        <td><a href="configure?selecteduser=${user.username}"><i class="fi-pencil"></i></a>&nbsp;
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                    </#if>
                </div>
            </div>
        </div>
    </div>
    <div class="row columns">&nbsp;</div>


</div>

<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script src="js/users.js"></script>
</#macro>

<@skeleton/>