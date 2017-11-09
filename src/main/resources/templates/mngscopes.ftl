<#-- @ftlvariable name="tags" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Tag>" -->
<#-- @ftlvariable name="canAddReports" type="java.lang.Boolean" -->
<#-- @ftlvariable name="mode" type="java.lang.String" -->
<#-- @ftlvariable name="selscope" type="it.com.ibm.generali.capitalreporting.model.Scope" -->
<#-- @ftlvariable name="parents" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#-- @ftlvariable name="scopes" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Scope>" -->
<#-- @ftlvariable name="users" type="java.util.List<it.com.ibm.generali.capitalreporting.model.CapitalUser>" -->
<#-- @ftlvariable name="templates" type="java.util.List<it.com.ibm.generali.capitalreporting.model.Template>" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->

<div class="row column">

    <div class="row">
        <div class="columns">
            <h3>Manage ${mode} scopes:</h3>
            <nav aria-label="You are here:" role="navigation">
                <ul class="breadcrumbs">
                    <li>
                        <a href="managescopes?mode=${mode}">YEARS</a>
                    </li>
                    <#if parents??>
                        <#list parents?reverse as parent>
                            <li>
                                <a href="managescope?scope=${parent.id?c}">${parent.name}</a>
                            </li>
                        </#list>
                    </#if>
                </ul>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="column medium-5 large-4">

            <#if scopes??>
                <#list scopes as scope>
                    <div class="row columns">
                        <a href="managescope?scope=${scope.id?c}" class="scope button" style="width: 200px">
                        ${scope.name}
                        </a>
                        <#if scope.hasNoReports()>
                            <a href="managechild?scope=${scope.id?c}" class="button arrow-only warning">
                                <i class="fi-arrow-right" aria-hidden="true"></i>
                                <span class="show-for-sr">Children</span>
                            </a>
                        </#if>
                    </div>
                </#list>
            </#if>

        </div>
        <div class="column medium-7 large-8">
            <div class="callout secondary">
                <#if selscope??>
                    <!-- A SCOPE EXISTS AND HAVE BEEN SELECTED -->
                    <div class="row columns">
                        <h5 id="scopename">${selscope.name}</h5>
                    </div>
                    <form data-abide novalidate id="scopeform" method="post" action="managescope">
                        <div class="row">
                            <div class="column medium-6 large-6">
                                <input id="id" name="id" type="hidden" value="${selscope.id}">
                                <input id="parent" name="parent" type="hidden" value="${selscope.parent}">
                                <input id="mode" name="mode" type="hidden" value="${mode}">
                                <label>Name:
                                    <input id="name" name="name" type="text" value="${selscope.name}" required>
                                    <span class="form-error">This field cannot be blank</span>
                                </label>
                                <span class="scope-duplicate" hidden>Parent scopes cannot have children with the same name</span>
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
                                                <input id="chk${tag.name}" name="tags" type="checkbox"
                                                       value="${tag.name}"
                                                       checked="checked">
                                            <#else>
                                                <input id="chk${tag.name}" name="tags" type="checkbox"
                                                       value="${tag.name}">
                                            </#if>
                                            <label for="chk${tag.name}">${tag.name}</label>
                                        </#list>
                                    </fieldset>
                                </#if>
                            </div>
                        </div>
                        <#if canAddReports??>
                            <#if canAddReports>
                                <div class="row">
                                    <div class="column medium-6 large-6">
                                        <label>Viewers:
                                            <select multiple>
                                                <#list users as user>
                                                    <option value="${user}">${user}</option>
                                                </#list>
                                            </select>
                                        </label>
                                    </div>
                                    <div class="column medium-6 large-6">
                                        <label>
                                            Templates:
                                            <select multiple>
                                                <#list templates as template>
                                                    <option value="${template.id}">${template.name}</option>
                                                </#list>
                                            </select>
                                        </label>
                                    </div>
                                </div>
                            </#if>
                        </#if>
                        <div class="row columns">
                            <input id="scopesave" type="submit" class="button" value="Save" onclick="persistScope()">
                            &nbsp;
                            <div class="reveal" id="scope-save-confirm" data-reveal>
                                <h1>Success</h1>
                                <p class="lead">Scope saved successfully!</p>
                                <button class="close-button" data-close aria-label="Close modal" type="button">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <a href="deletescope?id=${selscope.id?c}" class="warning button">
                                <i class="fi-x"></i>&nbsp;Delete
                            </a>
                            <a href="copyscope?id=${selscope.id?c}" class="button secondary">
                                <i class="fi-page-copy"></i>&nbsp;Copy
                            </a>
                            <#if canAddReports??>
                                <#if canAddReports>
                                    <div class="button-group float-right">
                                        <a href="reports?scope=${selscope.id?c}&mode=${mode}"
                                           class="button secondary">Reports</a>
                                        </a>
                                    </div>
                                </#if>
                            </#if>
                        </div>
                    </form>
                <#else>
                    <!-- A SCOPE DOES NOT EXIST -->
                    <div class="row columns">
                        <h5 id="scopename">Add new scope</h5>
                    </div>
                    <form data-abide no-validate id="scopeform" method="post" action="managescope">
                        <div class="row">
                            <div class="column medium-6 large-6">
                                <input id="id" name="id" type="hidden" value="-1">
                                <input id="parent" name="parent" type="hidden" value="${parents?last}">
                                <input id="mode" name="mode" type="hidden" value="${mode}">
                                <label>Name:
                                    <input id="name" name="name" type="text" value="" required>
                                    <span class="form-error">This field cannot be blank</span>
                                </label>
                                <span class="scope-duplicate" hidden>Parent scopes cannot have children with the same name</span>
                                <label>Published
                                    <input id="published" name="published" type="checkbox">
                                </label>
                            </div>
                            <div class="column medium-6 large-6">
                                <#if tags??>
                                    <fieldset>
                                        <legend>Tags:</legend>
                                        <#list tags as tag>
                                            <input id="chk${tag.name}" name="tags" type="checkbox" value="${tag.name}">
                                            <label for="chk${tag.name}">${tag.name}</label>
                                        </#list>
                                    </fieldset>
                                </#if>
                            </div>
                        </div>
                        <div class="row columns">
                            <input id="scopesave" type="submit" class="button" value="Save"
                                   onclick="persistScope()">
                            &nbsp;
                            <div class="reveal" id="scope-save-confirm" data-reveal>
                                <h1>Success</h1>
                                <p class="lead">Scope saved successfully!</p>
                                <button class="close-button" data-close aria-label="Close modal" type="button">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>
                    </form>
                </#if>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="column medium-5 large-4">
            <button class="button secondary" onclick="addNew()"><i class="fi-plus"></i>&nbsp;Add new</button>
        </div>
        <div class="column medium-7 large-8">
            &nbsp;
        </div>
    </div>

</div>

<div class="row column" style="margin-top: 400px">
    &nbsp;
</div>
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script src="js/mngscopes.js"></script>
</#macro>

<@skeleton/>
