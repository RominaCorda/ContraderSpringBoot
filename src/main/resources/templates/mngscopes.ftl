<#-- @ftlvariable name="tags" type="java.lang.String" -->
<#-- @ftlvariable name="children" type="java.lang.Boolean" -->
<#-- @ftlvariable name="mode" type="java.lang.String" -->
<#-- @ftlvariable name="selscope" type="it.com.ibm.generali.capitalreporting.model.Scope" -->
<#-- @ftlvariable name="parents" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#-- @ftlvariable name="scopes" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row column">

    <div class="row">
        <div class="columns">
            <h3>Select report's scope</h3>
            <nav aria-label="You are here:" role="navigation">
                <ul class="breadcrumbs">
                    <li>
                        <a href="/managescopes">YEARS</a>
                    </li>
                <#if parents??>
                    <#list parents?reverse as parent>
                        <li>
                            <a href="/managescope?scope=${parent.id}">${parent.name}</a>
                        </li>
                    </#list>
                </#if>
                </ul>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="column medium-5 large-4">

        <#list scopes as scope>
            <div class="row columns">
                <a href="/managescope?scope=${scope.id}" class="button" style="width: 200px">
                ${scope.name}
                </a>
                <#if children>
                    <a href="/managechild?scope=${scope.id}" class="button arrow-only warning">
                        <i class="fi-arrow-right" aria-hidden="true"></i>
                        <span class="show-for-sr">Children</span>
                    </a>
                </#if>
            </div>
        </#list>

            <button class="button secondary"><i class="fi-plus"></i>&nbsp;Add new</button>

        </div>
        <div class="column medium-7 large-8">
            <div class="callout secondary">
            <#if selscope??>
                <div class="row columns">
                    <h5>${selscope.name}</h5>
                </div>
                <form id="scopeform" method="post" action="">
                    <div class="row">
                        <div class="column medium-6 large-6">
                            <input id="id" name="id" type="hidden" value="${selscope.id}">
                            <label>Name:
                                <input id="name" name="name" type="text" value="${selscope.name}">
                            </label>
                            <label>Published
                                <#if selscope.published>
                                    <input id="published" name="published" type="checkbox" checked="checked">
                                <#else>
                                    <input id="published" name="published" type="checkbox">
                                </#if>
                            </label>
                        </div>
                        <div class="column medium-6 large-6">
                            <#if tags??>
                                <fieldset>
                                    <legend>Tags:</legend>
                                    <#list tags as tag>
                                        <#if selscope.tags?contains(tag.name)>
                                            <input id="chk${tag.name}" name="tags" type="checkbox" value="${tag.name}"
                                                   checked="checked">
                                        <#else>
                                            <input id="chk${tag.name}" name="tags" type="checkbox" value="${tag.name}">
                                        </#if>
                                        <label for="chk${tag.name}">${tag.name}</label>
                                    </#list>
                                </fieldset>
                            </#if>
                        </div>
                    </div>
                    <div class="row columns">
                        <input type="submit" class="button" value="Save">
                    </div>
                </form>
            </#if>
            </div>
        </div>
    </div>

</div>

<div class="row column" style="margin-top: 400px">
    &nbsp;
</div>

<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>
