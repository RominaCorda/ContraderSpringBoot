exports = this

exports.addNew = ->
  $('#scopename').text 'Add new scope'
  $('#scopesave').val 'Add'
  $('#id').val '-1'
  $('#name').val ''
  $('input:checkbox').prop 'checked', false
  return


exports.highlightSelected = ->
  $('.scope').each (index, scope) ->
    $(scope).removeClass('active')
  $('.scope').each (index, scope) ->
    selectedScope = $('#scopename').html()
    if selectedScope  == scope.innerText || selectedScope == scope.innerText.substring(0, scope.innerText.length - 1)
      $(scope).addClass('active')
    return


exports.scopeValid = () ->
    currentScopeName = $('#name').val()
    blank = false
    duplicate = false
    if currentScopeName == ''
      blank = true
    $('.scope').each (index, scope) ->
      scopeName = scope.innerText
      sameName = currentScopeName == scopeName || currentScopeName == scopeName.substr(0, scopeName.length-1)
      if sameName
        duplicate = true
    if blank
      showWarningFieldIsBlank()
    if duplicate
      showWarningFieldAlreadyExists()
    return !blank && !duplicate


exports.scopeEdited = () ->
  edited = true
  currentScopeId = $("#id").val()
  currentScopeName = $('#name').val()
  $('.scope').each (index, scope) ->
    scopeHref = $(scope).attr('href')
    scopeId = scopeHref.substr(scopeHref.indexOf('=')+1)
    scopeName = scope.innerText
    sameId = currentScopeId == scopeId
    sameName = currentScopeName == scopeName || currentScopeName == scopeName.substr(0, scopeName.length-1)
    edited = !(sameId && sameName)
  return edited


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
  event.preventDefault()
  if !scopeEdited()
    $('#scopeform').submit()
  else if scopeValid()
    removeWarnings()
    $('#scope-save-confirm').foundation('open');
    $(".close-button").click ->
      $('#scopeform').submit()


exports.deleteScope = (scopeId) ->
  $('#scope-delete-confirm').foundation('open');
  $("#scope-delete-yes").click ->
    window.location.href = "deletescope?id="+scopeId
  $("#scope-delete-no").click ->
    $('#scope-delete-confirm').foundation('close');

#$('#scopeform').on('invalid.fndtn.abide') ->
#  $('.scope-duplicate').hide()
#  return


$('.scope-duplicate').on('show', ( ->
  $('.form-error').removeClass('is-visible')
  $('#name').addClass('is-invalid-input')
  return
))

highlightSelected()



