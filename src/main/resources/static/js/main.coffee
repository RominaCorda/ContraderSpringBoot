exports = this

fill = (container, liquid = "coffee") ->
  "Filling the #{container} with #{liquid}..."

$ ->
  console.log("DOM is ready")
  $('#dynamic').html(fill 'cup')


