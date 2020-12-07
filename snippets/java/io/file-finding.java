/**
 * Przykład przeszukiwania katalogu
 */

import java.io.File;
import java.io.FilenameFilter;

public File findFile(File directory, String name) {
    File[] files = directory.listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File file, String fileName) {
            return fileName.equals(name);
        }
    });

    if (files.length == 0) {
        return null;
    }

    return files[0];
}
