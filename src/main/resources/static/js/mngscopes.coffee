exports = this

exports.addNew = ->
  $('#scopename').text 'Add new scope'
  $('#scopesave').val 'Add'
  $('#id').val '-1'
  $('#name').val ''
  $('input:checkbox').prop 'checked', false
  return