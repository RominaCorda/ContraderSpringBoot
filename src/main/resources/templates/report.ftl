<#-- @ftlvariable name="report" type="it.com.ibm.generali.capitalreporting.model.Report" -->
<#include "header.ftl">
<#include "topbar.ftl">

<br>

<!-- REPORT FORM -->
<div class="row columns">
    <h3>REPORT #${report.id}</h3>
</div>
<div class="row">
    <div class="medium-6 columns">
        <label>
            Simulation ID
            <input type="text" value="${report.simulationId?c}" readonly>
        </label>
        <label>
            Template
            <input type="text" value="${report.template}" readonly>
        </label>
        <label>
            Scope:
            <input type="text" value="${report.scope.name}" readonly>
        </label>

        <label>
            Number of iterations
            <div class="row">
                <div class="small-10 columns">
                    <div class="slider" data-slider data-initial-start="50">
                        <span class="slider-handle" data-slider-handle role="slider" tabindex="1"
                              aria-controls="sliderOutput1"></span>
                        <span class="slider-fill" data-slider-fill></span>
                    </div>
                </div>
                <div class="small-2 columns">
                    <input type="number" id="sliderOutput1">
                </div>
            </div>
        </label>

    </div>
    <div class="medium-6 large-5 columns">
        <label>
            Creation Date:
            <input type="text" value="${report.created}" readonly>
        </label>
        <label>
            Created by:
            <input type="text" value="${report.capitalUser.fullName}" readonly>
        </label>
        <label>
            Tags:
            <input type="text" value="${report.scope.tags}" readonly>
        </label>
        <button style="margin-top: 150px" class="button large expanded" data-open="runReport" onclick="doReport()">
            <i class="fi-play"></i>&nbsp;Run
        </button>
    </div>
</div>
<div class="row columns">
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
</div>
<!-- END REPORT FORM -->

<!-- MODAL WINDOW -->
<div class="reveal" id="runReport" data-reveal>
    <h1>Computing report #${report.id}</h1>
    <p id="message" class="lead">Please wait...</p>
    <div id="loader" class="loader"></div>
    <button class="close-button" data-close aria-label="Close modal" type="button">
        <span aria-hidden="true">&times;</span>
    </button>
    <div class="row">
        &nbsp;
        <div id="downloader" style="display: none;">
            <a href="#" class="button success float-right"><i class="fi-download"></i>&nbsp;Download Report</a>
        </div>
    </div>
</div>
<!-- END MODAL WINDOW -->

<#include "footer.ftl">
<#include "foundation.ftl">

</body>
</html>
