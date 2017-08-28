<!-- TOP BAR -->
<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text">
                <img src="img/generali.png" width="60px"/>
                &nbsp;&nbsp;
                GENERALI ASSICURAZIONI
            </li>
            <li class="has-submenu">
                <a href="#0"><i class="fi-torso"></i>&nbsp;${user.username?capitalize}</a>
                <ul class="submenu menu vertical" data-submenu>
                    <li><a href="/report">Reporting</a></li>
                    <li><a href="#0">Analysis</a></li>
                    <li><a href="#0">Do Yourself</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </li>
            <li><a href="#0">Reporting</a></li>
            <li><a href="#0">Analysis</a></li>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="menu" style="margin-top: 15px">
            <li><input type="search" placeholder="Search"></li>
            <li>
                <button type="button" class="button">Search</button>
            </li>
        </ul>
    </div>
</div>
<!-- TOP BAR -->

