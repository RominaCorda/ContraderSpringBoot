<#macro page_head>
    <#include "header.ftl">
</#macro>

<#macro page_body>
</#macro>

<#macro before_end_scripts>
</#macro>

<#macro footer>
    <#include "footer.ftl">
    <#include "foundation.ftl">
</#macro>

<#macro skeleton>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <@page_head/>
</head>
<body>
    <@page_body/>
        <@footer/>
        <@before_end_scripts/>
</body>
</html>
</#macro>
