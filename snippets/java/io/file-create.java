/**
 * Przykład tworzenia pliku
 */

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

public File createFile(String filePath) throws IOException {
    File file = new File(filePath);

    try (OutputStream outputStream = new FileOutputStream(file)) {
        outputStream.flush();
    }

    return file;
}

