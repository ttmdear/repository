/**
 * Przykład odczytania pliku
 */

def getNoticeContent() {
    InputStreamReader inputStreamReader = new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("notice-content-1.base64"))

    BufferedReader bufferedReader = new BufferedReader(inputStreamReader)

    String content = bufferedReader.lines().collect(Collectors.joining("\n"))

    return Base64.getDecoder().decode(content)
}
