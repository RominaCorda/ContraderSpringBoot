<#-- @ftlvariable name="templates" type="java.util.Collection<it.com.ibm.generali.capitalreporting.model.Template>" -->
<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-6 large-6 columns">
        <div class="row">
            <h3>Manage Templates</h3>
        </div>
        <div class="row">
            <form id="addtemplate" method="post" action="">
                <table id="templatestable">
                    <thead>
                    <tr>
                        <th width="330">Template</th>
                        <th width="30">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list templates as template>
                    <tr>
                        <td>${template.name}</td>
                        <td><a href="templates?delete=${template.id}"><i class="fi-x"></i></td>
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
        $("#templatestable").append('' +
                '<tr><td>\n' +
                '<input id="name" name="name" type="text" placeholder="Enter template name">\n' +
                '</td>\n' +
                '<td><input class="button" type="submit" value="OK"></td>\n' +
                '</tr>');
    });

</script>


</body>
</html>
