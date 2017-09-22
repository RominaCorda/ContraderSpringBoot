<#include "header.ftl">
<#include "topbar.ftl">

<br>

<div class="row">
    <div class="medium-6 columns">
        <img class="thumbnail" src="http://placehold.it/650x320">
    </div>
    <div class="medium-6 large-5 columns">
        <h3>Capital Reporting</h3>
        <p>Nunc eu ullamcorper orci. Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque
            faucibus vestibulum. Nulla at nulla justo, eget luctus tortor. Nulla facilisi. Duis aliquet egestas purus
            in.</p>

        <a href="/report" class="button large expanded">Calculate now</a>
        <a href="/browse" class="small secondary expanded button">Analysis</a>
    </div>
</div>

<div class="column row">
    <hr>
    <ul class="tabs" data-tabs id="example-tabs">
        <li class="tabs-title is-active"><a href="#panel1" aria-selected="true">My reports</a></li>
        <li class="tabs-title"><a href="#panel2">Recent reporting periods</a></li>
        <li class="tabs-title"><a href="#panel3">Recent scopes</a></li>
    </ul>
    <div class="tabs-content" data-tabs-content="example-tabs">
        <div class="tabs-panel is-active" id="panel1">
            <h4>My reports</h4>
            <div class="media-object stack-for-small">
                <div class="media-object-section">
                    <img class="thumbnail" src="http://placehold.it/200x200">
                </div>
                <div class="media-object-section">
                    <h5>A-380323 23-07-2017</h5>
                    <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An
                        idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It
                        can grow to define or destroy you.</p>
                </div>
            </div>
            <div class="media-object stack-for-small">
                <div class="media-object-section">
                    <img class="thumbnail" src="http://placehold.it/200x200">
                </div>
                <div class="media-object-section">
                    <h5>B-893922 19-07-2017</h5>
                    <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An
                        idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It
                        can grow to define or destroy you</p>
                </div>
            </div>
        </div>
        <div class="tabs-panel" id="panel2">
            <div class="row medium-up-3 large-up-5">
                <div class="column">
                    <img class="thumbnail" src="http://placehold.it/350x200">
                    <h5>Report
                        <small>A22</small>
                    </h5>
                    <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac
                        euismod semper, magna diam.</p>
                    <a href="#" class="button hollow tiny expanded">Run Now</a>
                </div>
                <div class="column">
                    <img class="thumbnail" src="http://placehold.it/350x200">
                    <h5>Report
                        <small>B22</small>
                    </h5>
                    <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac
                        euismod semper, magna diam.</p>
                    <a href="#" class="button hollow tiny expanded">Run Now</a>
                </div>
                <div class="column">
                    <img class="thumbnail" src="http://placehold.it/350x200">
                    <h5>Report
                        <small>C22</small>
                    </h5>
                    <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac
                        euismod semper, magna diam.</p>
                    <a href="#" class="button hollow tiny expanded">Run Now</a>
                </div>
                <div class="column">
                    <img class="thumbnail" src="http://placehold.it/350x200">
                    <h5>Report
                        <small>D22</small>
                    </h5>
                    <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac
                        euismod semper, magna diam.</p>
                    <a href="#" class="button hollow tiny expanded">Run Now</a>
                </div>
                <div class="column">
                    <img class="thumbnail" src="http://placehold.it/350x200">
                    <h5>Report
                        <small>E22</small>
                    </h5>
                    <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac
                        euismod semper, magna diam.</p>
                    <a href="#" class="button hollow tiny expanded">Run Now</a>
                </div>
            </div>
        </div>
        <div class="tabs-panel" id="panel3">

            <table>
                <thead>
                <tr>
                    <th width="200">Date</th>
                    <th>Report Name</th>
                    <th width="150">Scope</th>
                    <th width="100">&nbsp;</th>
                    <th width="100">&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>19.03.2017</td>
                    <td>Experimental Report A23</td>
                    <td>Analysis | YE17</td>
                    <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                    <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
                </tr>
                <tr>
                    <td>22.02.2017</td>
                    <td>Scenario Beta</td>
                    <td>Analysis | YE17</td>
                    <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                    <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
                </tr>
                <tr>
                    <td>17.07.2016</td>
                    <td>Report A32</td>
                    <td>Analysis | YE17</td>
                    <td><a href="#"><i class="fi-download"></i></a>&nbsp;</td>
                    <td><a href="/report"><i class="fi-play"></i></a>&nbsp;</td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>


<#include "footer.ftl">
<#include "foundation.ftl">


</body>
</html>