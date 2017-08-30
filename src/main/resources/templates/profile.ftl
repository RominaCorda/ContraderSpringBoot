<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-3 large-3 columns">

        <h3>${user.username?capitalize} profile</h3>

        <p>Change password:</p>

        <form id="changepwdform" method="post" action="">

            <label>Your current password:
                <input id="curpwd" name="curpwd" type="password" value="" aria-describedby="help1" required>
                <p class="help-text" id="help1">Enter your current password here</p>
            </label>

            <hr>

            <label>Type here your new password:
                <input id="newpwd1" name="newpwd1" type="password" value="" aria-describedby="help2" required>
                <p class="help-text" id="help2">Enter your new password here</p>
            </label>
            <label>Please re-type your new password:
                <input id="newpwd2" name="newpwd2" type="password" value="" aria-describedby="help3" required>
                <p class="help-text" id="help3">Enter your new password for validation purposes</p>
            </label>
            <br>
        <#if error??>
            <span id="errorPopup" class="label alert"><i class="fi-x-circle"></i>&nbsp;${error}</span>
        </#if>
            <br>

            <div class="button-group float-right">
                <a class="secondary button" href="/index">Cancel</a>
                <input type="submit" value="Submit" class="primary button">
            </div>

        </form>


    </div>
    <div class="small-6 large-6 columns">&nbsp;</div>
    <div class="small-3 large-3 columns">&nbsp;</div>

</div>

<#include "foundation.ftl">

<script>

    $("#errorPopup").click(function () {
        $("#errorPopup").hide()
    });

    $("#curpwd").click(function () {
        $("#errorPopup").hide()
    });

    $("#newpwd1").click(function () {
        $("#errorPopup").hide()
    });

</script>


</body>
</html>
