exports = this

exports.editcell = (tagid) ->
  content = $('#tag' + tagid).html()
  console.log 'Editing ' + tagid + ' with content=' + content
  window.location.assign 'tags?edit=' + tagid + '&content=' + content
  return

$ ->
  $('#addnew').click ->
    $('#addnew').prop 'disabled', true
    $('#tagstable').append '' + '<tr><td>\n' + '<input id="name" name="name" type="text" placeholder="Enter tag name">\n' + '</td>\n' + '<td><input class="button" type="submit" value="OK"></td>\n' + '</tr>'
    return
