// Oczytanie za pomocą bufforu
private String readFile(String path) throws IOException {
    InputStream inputStream = new FileInputStream(path);

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    StringBuilder outputBuilder = new StringBuilder();

    String line;

    while ((line = bufferedReader.readLine()) != null) {
        outputBuilder.append(line);
    }

    bufferedReader.close();

    return outputBuilder.toString();
}
