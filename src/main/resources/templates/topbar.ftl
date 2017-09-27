<#-- @ftlvariable name="user" type="java.lang.String" -->
<#-- @ftlvariable name="title" type="java.lang.String" -->
<!-- TOP BAR -->
<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text">
                <a href="/index" class="generali">
                    <img src="img/generali.png" width="60px"/>
                ${title}</a>
            </li>
            <li class="has-submenu">
                <a href="#0"><i class="fi-torso"></i>&nbsp;${user.username?capitalize}</a>
                <ul class="submenu menu vertical" data-submenu>
                    <li><a href="/profile">Profile</a></li>
                <#if user=="admin">
                    <li class="has-submenu">
                        <a href="#0"><i class="fi-crown"></i>&nbsp;Admin Tools</a>
                        <ul class="submenu menu vertical" data-submenu>
                            <li><a href="/configure">Configure User</a></li>
                            <li><a href="/roles">Define Roles</a></li>
                            <li><a href="/managescopes">Manage Scopes</a></li>
                            <li><a href="/templates">Manage Templates</a></li>
                            <li><a href="#0">Official simulations</a></li>
                        </ul>
                    </li>
                </#if>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </li>

            <li><a href="/freereporting">Free Reporting</a></li>
            <li><a href="/browse">Analysis</a></li>
            <li><a href="/browse?mode=Official">Official</a></li>
            <li class="has-submenu">
                <a href="/browse">Add-ons</a>
                <ul class="submenu menu vertical" data-submenu>
                    <li><a href="#0">Upload</a></li>
                    <li><a href="#0">Manage</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="menu" style="margin-top: 30px; margin-right: 50px">
            <li>
                <a href="/search" class="button">Search</a>
            </li>
        </ul>
    </div>
</div>
<!-- TOP BAR -->

