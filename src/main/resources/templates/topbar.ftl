<#-- @ftlvariable name="user" type="it.com.ibm.generali.capitalreporting.model.CapitalUser" -->
<#-- @ftlvariable name="title" type="java.lang.String" -->
<!-- TOP BAR -->
<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text">
                <a href="index" class="generali">
                    <img src="img/generali.png" width="60px"/>
                ${title}</a>
            </li>
            <li class="has-submenu">
                <a href="#0"><i class="fi-torso"></i>&nbsp;${user.username?capitalize}</a>
                <ul class="submenu menu vertical" data-submenu>
                    <li><a href="profile">Profile</a></li>
                <#if user.username=="admin">
                    <li class="has-submenu">
                        <a href="#0"><i class="fi-crown"></i>&nbsp;Admin Tools</a>
                        <ul class="submenu menu vertical" data-submenu>
                            <li><a href="searchusers">Configure Users</a></li>
                            <li><a href="roles">Manage Roles</a></li>
                            <li class="has-submenu">
                                <a href="#0">Manage Tags</a>
                                <ul class="submenu menu vertical" data-submenu>
                                    <li><a href="tags">Scope</a></li>
                                    <li><a href="usertags">User</a></li>
                                </ul>
                            </li>
                            <li class="has-submenu">
                                <a href="#0">Manage Scopes</a>
                                <ul class="submenu menu vertical" data-submenu>
                                    <li><a href="managescopes?mode=analysis">Analysis</a></li>
                                    <li><a href="managescopes?mode=official">Official</a></li>
                                </ul>
                            </li>
                            <li><a href="simulations">Manage Simulations</a></li>
                            <li><a href="editnews">News</a></li>
                        </ul>
                    </li>
                </#if>
                    <li><a href="logout">Logout</a></li>
                </ul>
            </li>
            <li><a href="freereporting">Free Reporting</a></li>
            <li><a href="browse?mode=analysis">Analysis</a></li>
            <li><a href="browse?mode=official">Official</a></li>
            <li class="has-submenu">
                <a href="#0">Manual Adjustment</a>
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
                <a href="search" class="button"><i class="fi-magnifying-glass"></i>&nbsp;Search</a>
            </li>
        </ul>
    </div>
</div><br>
<!-- TOP BAR -->

