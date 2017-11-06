<script src="js/jquery.min.js"></script>
<script src="js/what-input.min.js"></script>
<script src="js/foundation.min.js"></script>
<script>
    $(document).foundation();
    $('input, textarea, select').off('.abide').on('blur.fndtn.abide change.fndtn.abide', function (e) {
        // do nothing
    });

</script>
