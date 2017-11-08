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
    $('scope-duplicate').hide()
  duplicate = false
  $('.scope').each (index, scope) ->
    scopeName = $('#name').val()
    if scopeName == scope.innerText || scopeName == scope.innerText.substring(0, scope.innerText.length - 1)
      duplicate = true
  if duplicate
    $('.scope-duplicate').show()
    $('.form-error').removeClass('is-visible')
    $('#name').addClass('is-invalid-input')
  else
    $('.scope-duplicate').hide()
    $('#scopeform').submit()
  return

#$('#scopeform').on('invalid.fndtn.abide') ->
#  $('.scope-duplicate').hide()
#  return


$('.scope-duplicate').on('show', ( ->
  $('.form-error').removeClass('is-visible')
  $('#name').addClass('is-invalid-input')
  return
))



