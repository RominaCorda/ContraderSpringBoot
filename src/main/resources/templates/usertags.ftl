<#-- @ftlvariable name="usertags" type="java.util.List<it.com.ibm.generali.capitalreporting.model.UserTag>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
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
                        <td colspan="100%" class="form-error-${tag.id}" style="display: none"><span class="form-error form-error-${tag.id}">This field cannot be blank</span></td>
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
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script src="js/tags.js"></script>
</#macro>

<@skeleton/>


