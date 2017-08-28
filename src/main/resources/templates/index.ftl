<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>${title} - Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="css/foundation-float.min.css">
    <link rel="stylesheet" href="css/foundation-icons.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<#include "topbar.ftl">

<br>

<div class="row">
    <div class="medium-6 columns">
        <img class="thumbnail" src="http://placehold.it/650x350">
        <div class="row small-up-4">
            <div class="column">
                <img class="thumbnail" src="http://placehold.it/250x200">
            </div>
            <div class="column">
                <img class="thumbnail" src="http://placehold.it/250x200">
            </div>
            <div class="column">
                <img class="thumbnail" src="http://placehold.it/250x200">
            </div>
            <div class="column">
                <img class="thumbnail" src="http://placehold.it/250x200">
            </div>
        </div>
    </div>
    <div class="medium-6 large-5 columns">
        <h3>Capital Reporting</h3>
        <p>Nunc eu ullamcorper orci. Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque
            faucibus vestibulum. Nulla at nulla justo, eget luctus tortor. Nulla facilisi. Duis aliquet egestas purus
            in.</p>

        <label>Choose Report
            <select>
                <option value="husker"> A-38902</option>
                <option value="starbuck">B-39287</option>
                <option value="hotdog"> B-57958</option>
                <option value="apollo"> K-37897</option>
            </select>
        </label>

        <div class="row">
            <div class="small-3 columns">
                <label for="middle-label" class="middle">Correction:</label>
            </div>
            <div class="small-9 columns">
                <input type="text" id="middle-label" placeholder="One fish two fish">
            </div>
        </div>

        <a href="/report" class="button large expanded">Calculate now</a>

        <div class="small secondary expanded button-group">
            <a class="button">Excel</a>
            <a class="button">CSV</a>
            <a class="button">PDF</a>
        </div>
    </div>
</div>

<div class="column row">
    <hr>
    <ul class="tabs" data-tabs id="example-tabs">
        <li class="tabs-title is-active"><a href="#panel1" aria-selected="true">Latest reports</a></li>
        <li class="tabs-title"><a href="#panel2">Other reports</a></li>
    </ul>
    <div class="tabs-content" data-tabs-content="example-tabs">
        <div class="tabs-panel is-active" id="panel1">
            <h4>Latest reports</h4>
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
    </div>
</div>

<div class="row column">
    <hr>
    <ul class="menu">
        <li>GENERALI ASSICURAZIONI</li>
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
        <li class="float-right">
            <small>Copyright &copy; IBM CORPORATION 2017</small>
        </li>
    </ul>
</div>

<#include "foundation.ftl">


</body>
</html>