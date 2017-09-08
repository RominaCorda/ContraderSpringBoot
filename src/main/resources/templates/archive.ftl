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
                <th>Report</th>
                <th width="200">Reporting Period</th>
                <th width="200">Simulation ID</th>
                <th width="150">View</th>
                <th width="150">Download</th>
                <th width="50"></th>
            </tr>
            </thead>
            <tbody>

            <#list archive as key, value>
            <tr>
                <td>${key}</td>
                <td>${year}</td>
                <td>${value}</td>
                <td><a href="/freereporting">View in Cognos</a></td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="#"><i class="fi-x"></i></a>&nbsp;</td>
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

