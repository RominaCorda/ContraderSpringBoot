<#include "header.ftl">
<#include "topbar.ftl">


<div class="row">
    <div class="small-6 large-6 columns">

        <form id="changepwdform" method="post" action="">

            <h3 class="userprofile">${capitalUser.username?capitalize} profile</h3>

            <div class="row">
                <label>Full Name:
                    <input id="fullname" name="fullname" type="text" value="${capitalUser.fullName}" disabled>
                </label>
            </div>

            <div class="row">
                <label>eMail Address:
                    <input id="email" name="email" type="email" value="${capitalUser.email}" disabled>
                </label>
            </div>

            <div class="row">
                <label>Role:
                    <input id="role" name="role" type="text" value="${capitalUser.role.description}" disabled>
                </label>
            </div>

            <div class="row">
                <a class="secondary button float-right" href="/index">Back</a>
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
