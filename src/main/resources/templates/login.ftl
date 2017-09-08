<#include "header.ftl">

<!-- TOP BAR -->
<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text">
                <a href="#" class="generali">
                <img src="img/generali.png" width="60px"/>
                    &nbsp;&nbsp;${title}</a>
            </li>
        </ul>
    </div>
</div>
<!-- TOP BAR -->


<div class="loginform row">
    <div class="small-1 large-3 columns">&nbsp;</div>
    <div class="small-10 large-6 columns">
        <div class="callout large secondary clearfix">
            <h3>Login</h3>

            <form id="loginform" method="post" action="">

                <input id="username" name="username" type="text" placeholder="Username" aria-describedby="help1"
                       required>
                <p class="help-text" id="help1">Enter your username here</p>

                <input id="password" name="password" type="password" placeholder="Password" aria-describedby="help2"
                       required>
                <p class="help-text" id="help2">Enter your password here</p>

            <#if error??>
                <span id="errorPopup" class="label alert"><i class="fi-x-circle"></i>&nbsp;${error}</span>
            </#if>

                <input type="submit" value="Log in" class="button float-right">

            </form>
        </div>
    </div>
    <div class="small-1 large-3 columns">&nbsp;</div>
</div>

<#include "foundation.ftl">

<script>

    $("#errorPopup").click(function () {
        $("#errorPopup").hide()
    });

    $("#username").click(function () {
        $("#errorPopup").hide()
    });

    $("#password").click(function () {
        $("#errorPopup").hide()
    });

</script>

</body>
</html>
