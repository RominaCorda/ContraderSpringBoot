exports = this
exports.editcell = (tagid) ->
  cellEmpty = false
  content = $('#tag' + tagid).html()
  console.log 'Editing ' + tagid + ' with content=' + content
  if content == ''
        $ ->
        $('.form-error-' + tagid).show()
        cellEmpty = true
  else
        $ ->
        $('.form-error-' + tagid).hide()
        cellEmpty = false

  if !cellEmpty
    window.location.assign 'tags?edit=' + tagid + '&content=' + content
    return





$ ->
  $('#addnew').click ->
    $('#addnew').prop 'disabled', true
    $('#tagstable').append '' + '<tr><td>\n' + '<input id="name" name="name" type="text" placeholder="Enter tag name">\n' + '</td>\n' + '<td><input id="btn-new-tag" class="button" type="submit" value="OK"></td>\n' + '</tr>'
    $('#tagstable').append '' + '<td><span id="new-tag-error" class="form-error">This field cannot be blank</span></td>'


  $('#tagstable').on 'click', '#btn-new-tag', ->
    event.preventDefault()
    console.log "entered"
    inputValue = $('#name').val()
    if inputValue == ''
      $('#new-tag-error').show()
    else
      $('#new-tag-error').hide()
      $.post '/capitalreporting/tags',
        name: inputValue
        () -> window.location.reload()

