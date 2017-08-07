<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>${title} - Login</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="css/foundation-float.min.css">
    <link rel="stylesheet" href="css/foundation-icons.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<!-- TOP BAR -->
<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text">${title}</li>
        </ul>
    </div>
</div>
<!-- TOP BAR -->

<div class="loginform row">
    <div class="small-3 large-3 columns">&nbsp;</div>
    <div class="small-6 large-6 columns">
        <div class="callout large secondary clearfix">
            <h3>Login</h3>

            <form id="loginform" method="post" action="">

                <input id="username" name="username" type="text" placeholder="Username" aria-describedby="help1"
                       required>
                <p class="help-text" id="help1">Enter your username here</p>

                <input id="password" name="password" type="password" placeholder="Password" aria-describedby="help2"
                       required>
                <p class="help-text" id="help2">Enter your password here</p>

            <#if error??>
                <span id="errorPopup" class="label alert"><i class="fi-x-circle"></i>&nbsp;${error}</span>
            </#if>

                <div class="button-group float-right">
                    <a class="secondary button">Cancel</a>
                    <input type="submit" class="primary button">
                </div>

            </form>
        </div>
    </div>
    <div class="small-3 large-3 columns">&nbsp;</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/what-input.min.js"></script>
<script src="js/foundation.min.js"></script>
<script>
    $(document).foundation();

    $("#errorPopup").click(function () {
        $("#errorPopup").hide()
    });

    $("#username").click(function () {
        $("#errorPopup").hide()
    });

    $("#password").click(function () {
        $("#errorPopup").hide()
    });

</script>

</body>
</html>
