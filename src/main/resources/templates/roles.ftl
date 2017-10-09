<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-6 large-6 columns">
        <div class="row">
            <h3>Manage Roles</h3>
        </div>
        <div class="row">
            <form id="addroleform" method="post" action="">
                <table id="rolestable">
                    <thead>
                    <tr>
                        <th width="330">Role</th>
                        <th width="30">&nbsp;</th>
                        <th width="30">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list roles as role>
                    <tr>
                        <td>${role.description}</td>
                        <td><a href="/roles?delete=${role.id}"><i class="fi-x"></i></td>
                        <td><a href="/editrole?roleid=${role.id}"><i class="fi-pencil"></i></td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="row">
            <button id="addnew" class="button secondary float-right">
                <i class="fi-plus"></i>&nbsp;Add
            </button>
        </div>
    </div>
    <div class="small-6 large-6 columns">
        &nbsp;
    </div>
</div>
<div class="row">
    &nbsp;
</div>
<div class="row">
    &nbsp;
</div>

<#include "footer.ftl">
<#include "foundation.ftl">

<script>
    $("#addnew").click(function () {
        $("#addnew").prop("disabled", true);
        $("#rolestable").append('' +
                '<tr><td>\n' +
                '<input id="description" name="description" type="text" placeholder="Enter role name">\n' +
                '</td>\n' +
                '<td><input class="button" type="submit" value="OK"></td>\n' +
                '</tr>');
    });

</script>


</body>
</html>
