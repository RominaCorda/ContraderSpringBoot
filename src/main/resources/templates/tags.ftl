<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-6 large-6 columns">
        <div class="row">
            <h3>Manage Tags</h3>
        </div>
        <div class="row">
            <form id="addtagform" method="post" action="">
                <table id="tagstable">
                    <thead>
                    <tr>
                        <th width="330">Tag</th>
                        <th width="30">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list tags as tag>
                    <tr>
                        <td>${tag.name}</td>
                        <td><a href="/tags?delete=${tag.id}"><i class="fi-x"></i></td>
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
        $("#tagstable").append('' +
                '<tr><td>\n' +
                '<input id="name" name="name" type="text" placeholder="Enter tag name">\n' +
                '</td>\n' +
                '<td><input class="button" type="submit" value="OK"></td>\n' +
                '</tr>');
    });

</script>


</body>
</html>
