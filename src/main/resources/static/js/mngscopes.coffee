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
    sameName = currentScopeName == scopeName || currentScopeName == scopeName.substr(0, scopeName.length - 1)
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
    scopeId = scopeHref.substr(scopeHref.indexOf('=') + 1)
    scopeName = scope.innerText
    sameId = currentScopeId == scopeId
    sameName = currentScopeName == scopeName || currentScopeName == scopeName.substr(0, scopeName.length - 1)
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
     selectAll()
     console.log ''
     $('#scopeform').submit()
  else if scopeValid()
    removeWarnings()
    $('#scope-save-confirm').foundation('open');
    $(".close-button").click ->
       selectAll()
       console.log ''
       $('#scopeform').submit()


exports.selectAll = ->
  $('.viewer').each (index,item) ->
    $(this).attr('selected', true)




exports.deleteScope = (scopeId) ->
  $('#scope-delete-confirm').foundation('open');
  $("#scope-delete-yes").click ->
    window.location.href = "deletescope?id=" + scopeId
  $("#scope-delete-no").click ->
    $('#scope-delete-confirm').foundation('close');

#$('#scopeform').on('invalid.fndtn.abide') ->
#  $('.scope-duplicate').hide()
#  return

exports.showUsers = ->
  $('#show-users').foundation('open');
  $('#btn-add-viewers').click ->
    $('.users:selected').each (index, user) ->
      $('#viewers').append($('<option>', {
        value: $(user).text(),
        text: $(user).text()
        class: 'viewer'
      }));
      $('#owner').append($('<option>', {
        value: $(user).text(),
        text: $(user).text()
      }));
      $('#add-viewers option[value="' + $(user).text() + '"]').remove()
    $('#show-users').foundation('close')


exports.removeViewers = ->
  $('#viewers option:selected').each (index, viewer) ->
    if $(viewer).text() == "admin"
      return
    else
      $('#viewers option[value="' + $(viewer).text() + '"]').remove()
      $('#owner option[value="' + $(viewer).text() + '"]').remove()
      $('#add-viewers').append($('<option>', {
        class: "users",
        value: $(viewer).text(),
        text: $(viewer).text()
      }));


$('.scope-duplicate').on('show', ( ->
  $('.form-error').removeClass('is-visible')
  $('#name').addClass('is-invalid-input')
  return
))

highlightSelected()



