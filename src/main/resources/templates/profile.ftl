<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-6 large-6 columns">

        <form id="changepwdform" method="post" action="">

            <h3 class="userprofile">${user.username?capitalize} profile</h3>

            <div class="row">
                <label>Full Name:
                    <input id="fullname" name="fullname" type="text" value="${user.fullName}" disabled>
                </label>
            </div>

            <div class="row">
                <label>eMail Address:
                    <input id="email" name="email" type="email" value="${user.email}" disabled>
                </label>
            </div>

            <div class="row">
                <label>Role:
                    <input id="role" name="role" type="text" value="${user.role.description}" disabled>
                </label>
            </div>

            <ul class="accordion pwdchanger" data-accordion data-allow-all-closed="true">
                <li class="accordion-item" data-accordion-item>
                    <!-- Accordion tab title -->
                    <a href="#" class="accordion-title">Change my password</a>

                    <!-- Accordion tab content: it would start in the open state due to using the `is-active` state class. -->
                    <div class="accordion-content" data-tab-content>
                        <label>Your current password:
                            <input id="curpwd" name="curpwd" type="password" value="" aria-describedby="help1" required>
                            <p class="help-text" id="help1">Enter your current password here</p>
                        </label>
                        <label>Type here your new password:
                            <input id="newpwd1" name="newpwd1" type="password" value="" aria-describedby="help2"
                                   required>
                            <p class="help-text" id="help2">Enter your new password here</p>
                        </label>
                        <label>Please re-type your new password:
                            <input id="newpwd2" name="newpwd2" type="password" value="" aria-describedby="help3"
                                   required>
                            <p class="help-text" id="help3">Enter your new password for validation purposes</p>
                        </label>
                    </div>
                </li>
            </ul>

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
