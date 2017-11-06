exports = this

exports.addNew = ->
  $('#scopename').text 'Add new scope'
  $('#scopesave').val 'Add'
  $('#id').val '-1'
  $('#name').val ''
  $('input:checkbox').prop 'checked', false
  return


exports.checkDuplicate = () ->
  event.preventDefault()
  if $('#name').val() == ''
    $('form-error').hide()
  duplicate = false
  $('.scope').each (index, scope) ->
    if $('#name').val() == scope.innerText.substring(0, scope.innerText.length - 1)
      duplicate = true
  if duplicate
    $('.scope-duplicate').show()
  else
    $('.scope-duplicate').hide()
    $('#scopeform').submit()
return

