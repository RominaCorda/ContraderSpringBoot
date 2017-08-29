<#include "header.ftl">
<#include "topbar.ftl">

<br>

<!-- REPORT FORM -->
<div class="row">
    <div class="medium-6 columns">
        <h3>REPORT A-38902</h3>
        <p>Nunc eu ullamcorper orci. Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque
            faucibus vestibulum. Nulla at nulla justo, eget luctus tortor. Nulla facilisi. Duis aliquet egestas purus
            in.</p>

        <fieldset>
            <legend>Output</legend>
            <input type="radio" name="output" value="csv" id="csv" required><label for="csv">CSV</label>
            <input type="radio" name="output" value="excel" id="excel" checked="checked" aria-selected="true"><label
                for="excel">Excel</label>
            <input type="radio" name="output" value="pdf" id="pdf"><label for="pdf">PDF</label>
        </fieldset>
        <label>Algorithm
            <select>
                <option value="excel"> Buzen's</option>
                <option value="pdf"> Chi-square</option>
                <option value="csv"> Lander-Green</option>
            </select>
        </label>
        <label>
            Correction delta
            <input type="text" placeholder="100.0">
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
        <label>
            Notes
            <textarea placeholder="None"></textarea>
        </label>

        <button class="button large expanded" data-open="runReport" onclick="doReport()">
            <i class="fi-play"></i>&nbsp;Run
        </button>


    </div>

    <div class="medium-6 large-5 columns">
        <img class="thumbnail" src="http://placehold.it/650x350">
    </div>
</div>
<!-- END REPORT FORM -->

<!-- MODAL WINDOW -->
<div class="reveal" id="runReport" data-reveal>
    <h1>Computing A-38902</h1>
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
