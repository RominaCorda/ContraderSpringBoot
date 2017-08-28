exports = this

a = 10000

fill = (container, liquid = "coffee") ->
  "Filling the #{container} with #{liquid}..."

$ ->
  console.log("DOM is ready")
  $('#dynamic').html(fill 'cup')


