<#include "header.ftl">
<#include "topbar.ftl">

<div class="row">
    <div class="small-3 large-3 columns">

        <h3>${user.username?capitalize} profile</h3>

        <div class="callout primary">
            <h5>Password saved.</h5>
            <p>Your password has been succesfully changed.</p>
            <a href="/logout">Logout</a>
        </div>


    </div>
    <div class="small-6 large-6 columns">&nbsp;</div>
    <div class="small-3 large-3 columns">&nbsp;</div>

</div>

<#include "foundation.ftl">


</body>
</html>
