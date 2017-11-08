exports = this
exports.editcell = (tagid) ->
  cellEmpty = false
  cell = $('#tag' + tagid)
  content = cell.text()
  console.log 'Editing ' + tagid + ' with content=' + content
  if content == ''
        $ ->
        $('.form-error-' + tagid).show()
        cell.parent().addClass('is-invalid-input')
        cellEmpty = true
  else
        $ ->
        $('.form-error-' + tagid).hide()
        cell.parent().removeClass('is-invalid-input')
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
    tagName = $('#name').val()
    if tagName == ''
      $('#new-tag-error').show()
      $('#name').addClass('is-invalid-input')
    else
      $('#new-tag-error').hide()
      $('#name').removeClass('is-invalid-input')
      $('#addtagform').submit()


