// Small file

@Test
public void givenSmallFile_whenUsingFilesAPI_thenExtractedLineIsCorrect() {
    String extractedLine = Files.readAllLines(Paths.get(FILE_PATH)).get(4);

    assertEquals("Line 5", extractedLine);
}

// Large file
@Test
public void givenLargeFile_whenUsingFilesAPI_thenExtractedLineIsCorrect() {
    try (Stream lines = Files.lines(Paths.get(FILE_PATH))) {
        String extractedLine = lines.skip(4).findFirst().get();

        assertEquals("Line 5", extractedLine);
    }
}