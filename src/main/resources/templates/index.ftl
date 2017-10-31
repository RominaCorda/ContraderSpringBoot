<#-- @ftlvariable name="news" type="java.util.List<it.com.ibm.generali.capitalreporting.model.NewsArticle>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<div class="row">
    <div class="medium-5 large-5 columns">
        <h5>News</h5>
        <#list news as article>
            <div class="callout">
                <h5>${article.title} - ${article.created?date}</h5>
                <p>${article.body}</p>
                <a href="${article.linkUrl}">${article.linkTitle}</a>
            </div>
        </#list>
    </div>
    <div class="medium-7 large-7 columns">
        <#include "myreports.ftl">
    </div>
</div>
<div class="row">
    <div class="medium-7 large-7 columns">
        <ul class="tabs" data-tabs id="example-tabs">
            <li class="tabs-title is-active"><a href="#panel1">Recent reporting periods</a></li>
            <li class="tabs-title"><a href="#panel2">Recent scopes</a></li>
        </ul>
        <div class="tabs-content" data-tabs-content="example-tabs">
            <div class="tabs-panel is-active" id="panel1">
                <h5>Reporting Periods</h5>
                <ul>
                    <li><a href="#">YE2016</a></li>
                    <li><a href="#">YE2017</a></li>
                </ul>
            </div>
            <div class="tabs-panel" id="panel2">
                <h5>Scopes</h5>
                <ul>
                    <li><a href="#">Official</a> | <a href="#">YE2015</a> | <a href="#">Closure SCR</a> |
                        <a
                                href="#">Germany</a></li>
                    <li><a href="#">Analysis</a> | <a href="#">YE2016</a></li>
                </ul>

            </div>


        </div>
    </div>

    <div class="medium-5 large-5 columns">
        <img class="thumbnail" src="http://placehold.it/600x230">
    </div>

</div>
</#macro>

<@skeleton/>



