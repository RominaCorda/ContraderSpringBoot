exports = this


exports.showCopyUser = ->
  $('#copy-user').show()

$('#copy-user-val').change () ->
  $('#btn-copy-user').attr('href', "copyuser?username="+$('select option:selected').val()+"&username_new="+$('#copy-user-val').val())