exports = this

exports.deleteUser = (userId) ->
  $('#user-delete-confirm').foundation('open');
  $("#user-delete-yes").click ->
    window.location.href = "configure?delete=" + userId
  $("#user-delete-no").click ->
    $('#user-delete-confirm').foundation('close');

exports.showUpload = ->
  $('#upload').show()

$('#copy-user-val').change () ->
  $('#btn-copy-user').attr('href', "copyuser?username=" + $('select option:selected').val() + "&username_new=" + $('#copy-user-val').val())


