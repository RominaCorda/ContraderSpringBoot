<#-- @ftlvariable name="iframesrc" type="String" -->
<#include "base.ftl">

<#macro page_body>
    <#include "topbar.ftl">
<!-- MAIN -->
    <#if iframesrc??>
    <iframe id="cognosframe" src="http://${iframesrc}"></iframe>
    <script type="text/javascript">//<![CDATA[
    function resize() {
        $("#cognosframe").height(window.innerHeight - 185);
    }

    resize();
    window.onresize = function () {
        resize();
    };
    //]]>
    </script>
    <#else>
    <div class="row">
        <div class="medium-12 large-12 columns">
            <img src="img/freereporting.jpg">
        </div>
    </div>
    </#if>
<!-- END OF MAIN -->
</#macro>

<#macro  before_end_scripts>
<script></script>
</#macro>

<@skeleton/>

