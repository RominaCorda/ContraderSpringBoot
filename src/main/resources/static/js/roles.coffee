$ ->
  $('#addnew').click ->
    $('#addnew').prop 'disabled', true
    $('#rolestable').append '' + '<tr><td>\n' + '<input id="description" name="description" type="text" placeholder="Enter role name">\n' + '</td>\n' + '<td><input class="button" type="submit" value="OK"></td>\n' + '</tr>'
    return
