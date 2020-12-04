
InputStream inputStream = new FileInputStream(file);

BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

// Ommit first line with heading
bufferedReader.readLine();

String line;

while ((line = bufferedReader.readLine()) != null) {
    System.out.println(line);
}
