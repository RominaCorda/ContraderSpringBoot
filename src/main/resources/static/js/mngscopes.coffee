exports = this

exports.addNew = ->
  $('#scopename').text 'Add new scope'
  $('#scopesave').val 'Add'
  $('#id').val '-1'
  $('#name').val ''
  $('input:checkbox').prop 'checked', false
  return


exports.scopeValid = () ->
  blank = false
  duplicate = false
  event.preventDefault()
  if $('#name').val() == ''
    blank = true
  $('.scope').each (index, scope) ->
    scopeName = $('#name').val()
    if scopeName == scope.innerText || scopeName == scope.innerText.substring(0, scope.innerText.length - 1)
      duplicate = true
  if blank
    showWarningFieldIsBlank()
  if duplicate
    showWarningFieldAlreadyExists()
  return !blank && !duplicate


exports.showWarningFieldIsBlank = ->
  $('.scope-duplicate').hide()
  $('.form-error').show()
  $('#name').addClass('is-invalid-input')

exports.showWarningFieldAlreadyExists = ->
  $('.scope-duplicate').show()
  $('.form-error').removeClass('is-visible')
  $('.form-error').hide()
  $('#name').addClass('is-invalid-input')

exports.removeWarnings = ->
  $('.form-error').removeClass('is-visible')
  $('.form-error').hide()
  $('.scope-duplicate').hide()
  $('#name').removeClass('is-invalid-input')



exports.persistScope = () ->
  if scopeValid()
    removeWarnings()
    $('#scope-save-confirm').foundation('open');
    $(".close-button").click ->
      $('#scopeform').submit()


#$('#scopeform').on('invalid.fndtn.abide') ->
#  $('.scope-duplicate').hide()
#  return


$('.scope-duplicate').on('show', ( ->
  $('.form-error').removeClass('is-visible')
  $('#name').addClass('is-invalid-input')
  return
))



