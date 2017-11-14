<#-- @ftlvariable name="users" type="java.util.List<it.com.ibm.generali.capitalreporting.model.CapitalUser>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->

<div class="row columns" xmlns="http://www.w3.org/1999/html">
    <div class="row columns">
        <h3>Configure Users</h3>
    </div>

    <div class="row columns">
        <div class="row">
            <div class="small-12 medium-2 large-2 columns">
                <div class="button-group stacked secondary small" style="margin-top: 25px">
                    <a href="userscsvdownload" class="success button">Download...</a>
                    <form id="uploadfile" name="uploadfile" method="POST" action="uploadusersfile"
                          enctype="multipart/form-data">ù
                        <label for="file" class="button">Upload File</label>
                        <input type="file" id="file" name="file" class="show-for-sr">
                    </form>
                    <a href="configure?mode=new" class="button"><i class="fi-plus"></i>&nbsp;Add new</a>
                </div>
            </div>
            <div class="small-12 medium-10 large-10 columns">
                <div class="row">
                    <div class="columns">
                        <form name="filterdata" method="post" action="">
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
                                    <button type="submit" class="small button success float-right" name="searchfilter"
                                            value="Filter">
                                        <i class="fi-magnifying-glass"></i> Filter
                                    </button>
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
<script>
    $('#file').change(function () {
        $('#uploadfile').submit();
    });
</script>

<!-- END OF MAIN -->
</#macro>

<@skeleton/>