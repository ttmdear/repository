// Sprawdzenie czy plik istnieje w zasobie.

private boolean isFileExists(String path) {
    return getClass().getResource(path) != null;
}

// Spradzenie czy plik istnieje
private boolean isFileExists(String path) {
    return new File(path).exists();
}
