exports = this

messages = ['Uploading parameters...',
  'Loading Cognos API...',
  'Computing report...',
  'Report ready']

exports.doReport = ->
  console.log 'Doing report...'
  $('#loader').show()
  $('#downloader').hide()
  $('#message').text('Please wait...')
  messenger messages
  return

say = (msg) ->
  console.log 'Saying <' + msg + '>'
  $('#message').text(msg)
  if (msg == messages[messages.length - 1])
    console.log 'Ready to download '
    $('#loader').hide()
    $('#downloader').show()
  return

timerMessage = (i, msg) ->
  randomInterval = Math.floor(Math.random() * 4) + 1
  delay = (i * 2000) + 1000 * randomInterval
  setTimeout say, delay, msg
  return

messenger = (arrayOfMessages) ->
  timerMessage i, message for message, i in arrayOfMessages





