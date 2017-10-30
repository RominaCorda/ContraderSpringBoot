<#-- @ftlvariable name="newslist" type="java.util.List<it.com.ibm.generali.capitalreporting.model.NewsArticle>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
<div class="row">
    <div class="small-6 large-6 columns">
        <div class="row">
            <h3>Author News</h3>
        </div>
        <div class="row">
            <form id="addnewsform" method="post" action="">
                <table id="newstable">
                    <thead>
                    <tr>
                        <th width="300">News</th>
                        <th width="200">Created</th>
                        <th width="30">&nbsp;</th>
                        <th width="30">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list newslist as news>
                        <tr>
                            <td>${news.title}</td>
                            <td>${news.created?date}</td>
                            <td><a href="editnews?delete=${news.id?c}"><i class="fi-x"></i></td>
                            <td><a href="editnewsarticle?newsid=${news.id?c}"><i class="fi-pencil"></i></td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="row">
            <a href="addnewsarticle" class="button secondary float-right">
                <i class="fi-plus"></i>&nbsp;Add
            </a>
        </div>
    </div>
    <div class="small-6 large-6 columns">
        &nbsp;
    </div>
</div>
<!-- END OF MAIN -->
</#macro>

<@skeleton/>