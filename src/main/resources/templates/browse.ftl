<#include "header.ftl">
<#include "topbar.ftl">

<br>


<div class="row column">
    <div class="row">
        <h3>Analysis</h3>
    </div>

    <div class="row">
        <nav aria-label="You are here:" role="navigation">
            <ul class="breadcrumbs">
                <li>
                    Years
                </li>
            </ul>
        </nav>
    </div>

    <div class="row">
    <#list scopes as scope>
        <a href="/scopes?parent=${scope.id}" class="button primary">${scope.name}</a>
    </#list>
    </div>

</div>

<div class="row column" style="margin-top: 400px">
    &nbsp;
</div>


<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>
