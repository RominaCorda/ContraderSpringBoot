<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row column">
    <div class="row">
        <h3>Available reports for ${month} ${year}</h3>
    </div>

    <div class="row">
        <nav aria-label="You are here:" role="navigation">
            <ul class="breadcrumbs">
                <li><a href="/browse">Years</a></li>
                <li><a href="/months?year=${year}">${year}</a></li>
                <li>
                ${month}
                </li>
            </ul>
        </nav>
    </div>

    <div class="row">
        <h3>Reports</h3>
        <table>
            <thead>
            <tr>
                <th width="200">Report Name</th>
                <th width="150">View</th>
                <th width="150">Run</th>
            </tr>
            </thead>
            <tbody>

            <#list archive as key, value>
            <tr>
                <td>${key} ${value}</td>
                <td><a href="#">View in Cognos</a></td>
                <td><a href="#">Download Excel</a></td>
            </tr>
            </#list>

            </tbody>
        </table>
    </div>

</div>


<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>

