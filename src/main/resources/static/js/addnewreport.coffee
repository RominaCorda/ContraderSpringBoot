$ ->
  $('#selecttemplate').on 'change', ->
    console.log 'Changing template'
    url = $(this).val()
    if url
      window.location = url
    false
  return
