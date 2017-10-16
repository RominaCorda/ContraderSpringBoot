$ ->
  $('#addnew').click ->
    $('#addnew').prop 'disabled', true
    $('#templatestable').append '' + '<tr><td>\n' + '<input id="name" name="name" type="text" placeholder="Enter template name">\n' + '</td>\n' + '<td><input class="button" type="submit" value="OK"></td>\n' + '</tr>'
    return
