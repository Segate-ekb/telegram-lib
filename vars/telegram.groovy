#!/usr/bin/env groovy

class telegram_q {

    String authToken
    String chatId
    String parseMode

    def setAuthToken(String authToken) {
        if (${ authToken }.trim().length() == 0) {
            throw new Exception("can't set auth token")
        }
        this.authToken = ${ authToken }
    }

    def setChatId(String chatId) {
        if (${ chatId }.trim().length() == 0) {
            throw new Exception("can't set chatId")
        }
        this.chatId = ${ chatId }
    }

    def sendMessage(String message) {
        if (${ message }.trim().length() == 0) {
            throw new Exception('Message is empty!')
        }
        String urlString = 'https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s'
        urlString = String.format(urlString, authToken, chatId, message)

        URL url = new URL(urlString)
        URLConnection conn = url.openConnection()

        StringBuilder sb = new StringBuilder()
        InputStream is = new BufferedInputStream(conn.getInputStream())
        BufferedReader br = new BufferedReader(new InputStreamReader(is))
        String inputLine = ''
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine)
        }
        String response = sb.toString()
        echo response
    }

}
