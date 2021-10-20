/**
 * In this examples there is read file content with some offset.
 * It uses RandomAccessFile.seek method to set file pointer to specific place.
 */
package com.lvl.quotations;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.lvl.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MT4QuotesProvider {

    private void loadQuote() {
        log.info("Start loading quotes.");

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("test.txt"), "r");

            // Move file pointer to specific offset.
            randomAccessFile.seek(quotesFileOffset);

            String line;

            // while ((line = bufferedReader.readLine()) != null) {
            while ((line = randomAccessFile.readLine()) != null) {
                log.info("Read line '{}'.", line);

            }
        } catch (IOException) {
            e.printStackTrace();
        }
    }
}
