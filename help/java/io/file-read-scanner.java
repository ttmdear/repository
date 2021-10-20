@Test
public void givenFile_whenUsingScanner_thenExtractedLineIsCorrect() {
    try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
        for (int i = 0; i < 3; i++) {
            scanner.nextLine();
        }

        String extractedLine = scanner.nextLine();
        assertEquals("Line 4", extractedLine);
    }
}
