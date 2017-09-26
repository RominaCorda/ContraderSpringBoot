<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row">
    <div class="medium-5 large-5 columns">
        <h5>News</h5>

        <div class="callout">
            <h5>Reporting is online!! - 25 Set 2017</h5>
            <p>Wow, reporting is online!.</p>
            <a href="#0">It's dangerous to go alone, take this.</a>
        </div>

        <div class="callout">
            <h5>New report A32980 available - 20 Set 2017.</h5>
            <p>It has an easy to override visual style, and is appropriately subdued.</p>
            <a href="#0">It's dangerous to go alone, take this.</a>
        </div>

    </div>
    <div class="medium-7 large-7 columns">

        <h5>My reports</h5>

        <table>
            <thead>
            <tr>
                <th width="100">Date</th>
                <th width="200">Report Name</th>
                <th>Scope</th>
                <th width="70">&nbsp;</th>
                <th width="70">&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>19.03.2017</td>
                <td>Experimental Report A23</td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover='false'
                          title="Analysis | YE17">Analysis | YE17</span></td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
            </tr>
            <tr>
                <td>22.02.2017</td>
                <td>Scenario Beta</td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover='false'
                          title="Official | YE17 | Closure SCR | Germany ">Official | YE17 | Closure &hellip;</td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
            </tr>
            <tr>
                <td>17.07.2016</td>
                <td>Report A32</td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover='false'
                          title="Analysis | YE17">Analysis | YE17</span></td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
            </tr>
            <tr>
                <td>19.03.2017</td>
                <td>Experimental Report A23</td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover='false'
                          title="Analysis | YE17">Analysis | YE17</span></td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
            </tr>
            <tr>
                <td>22.02.2017</td>
                <td>Scenario Beta</td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover='false'
                          title="Official | YE17">Official | YE17</span></td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
            </tr>
            <tr>
                <td>17.07.2016</td>
                <td>Report A32</td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip" data-disable-hover='false'
                          title="Analysis | YE17">Analysis | YE17</span></td>
                <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
            </tr>
            </tbody>
        </table>

    </div>
</div>

<div class="row">
    <hr>
    <div class="medium-7 large-7 columns">
        <ul class="tabs" data-tabs id="example-tabs">
            <li class="tabs-title is-active"><a href="#panel1">Recent reporting periods</a></li>
            <li class="tabs-title"><a href="#panel2">Recent scopes</a></li>
        </ul>
        <div class="tabs-content" data-tabs-content="example-tabs">
            <div class="tabs-panel is-active" id="panel1">
                <h5>Reporting Periods</h5>
                <ul>
                    <li><a href="#">YE2015</a></li>
                    <li><a href="#">YE2016</a></li>
                    <li><a href="#">YE2017</a></li>
                </ul>
            </div>
            <div class="tabs-panel" id="panel2">
                <h5>Scopes</h5>
                <ul>
                    <li><a href="#">Analysis</a> | <a href="scopes?parent=4">YE2014</a> | <a href="#">Closure SCR</a>
                    </li>
                    <li><a href="#">Official</a> | <a href="scopes?parent=5">YE2015</a> | <a href="#">Closure SCR</a> |
                        <a
                                href="#">Germany</a></li>
                    <li><a href="#">Analysis</a> | <a href="scopes?parent=6">YE2016</a></li>
                </ul>

            </div>


        </div>
    </div>

    <div class="medium-5 large-5 columns">
        <img class="thumbnail" src="http://placehold.it/600x270">
    </div>

</div>


<#include "footer.ftl">
<#include "foundation.ftl">


</body>
</html>