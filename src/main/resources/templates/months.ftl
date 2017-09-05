<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row column">
    <div class="row">
        <h3>Select report's month</h3>
    </div>

    <div class="row">
        <nav aria-label="You are here:" role="navigation">
            <ul class="breadcrumbs">
                <li><a href="/browse">Years</a></li>
                <li>
                    Year ${year}
                </li>
            </ul>
        </nav>
    </div>

    <div class="row">
    <#list months as month>
        <a href="/archive?year=${year}&month=${month}" class="button primary">${month} ${year}</a>
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