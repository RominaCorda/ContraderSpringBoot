<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-6 large-6 columns">
        <div class="row">
            <h3>Manage User Tags</h3>
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
                    <#list usertags as tag>
                    <tr>
                        <td id="tag${tag.id}" contenteditable="true">${tag.name}</td>
                        <td><a href="tags?delete=${tag.id}"><i class="fi-x"></i></td>
                        <td><a onclick="editcell(${tag.id});"><i class="fi-save"></i></td>
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

<script src="js/tags.js"></script>

</body>
</html>
