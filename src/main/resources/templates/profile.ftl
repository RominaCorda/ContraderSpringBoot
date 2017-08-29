<#include "header.ftl">
<#include "topbar.ftl">


<div class="loginform row">
    <div class="small-3 large-3 columns">

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

            <div class="button-group float-right">
                <a class="secondary button">Cancel</a>
                <input type="submit" value="Log in" class="primary button">
            </div>

        </form>


    </div>
    <div class="small-6 large-6 columns">&nbsp;</div>
    <div class="small-3 large-3 columns">&nbsp;</div>

</div>

<#include "foundation.ftl">


</body>
</html>
