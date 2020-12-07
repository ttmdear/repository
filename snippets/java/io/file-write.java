/**
 * Przykład zapisu do pliku.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NoticeUtil {
    public static void saveVisualizationToHtmlOutputFile(String visualization) {
        try {
            FileWriter fileWriter = new FileWriter("output.html");

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("</section>\t\n" +
                "\n" +
                "</div>\n" +
                "<!-- Content / End -->\n" +
                "\n" +
                "<!-- Aktualny Footer znajduje się w pliku komponenty.html -->\n" +
                "</html>");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
