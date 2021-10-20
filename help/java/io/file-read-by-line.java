/**
 * Przykład czytania pliku linia po linii.
 */

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;

import com.lvl.util.DateUtil;

private void loadQuote() {
    try {
        InputStream inputStream = new FileInputStream(file);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Ommit first line with heading
        bufferedReader.readLine();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] splited = line.split(";");

            Date time = DateUtil.parse(splited[0]);

            if (lastQuote != null && !time.after(lastQuote.getTime())) continue;
            if (fromDate != null && time.before(fromDate)) continue;
            if (toDate != null && time.after(toDate)) continue;

            Quote quote = new Quote(
                time,
                Double.parseDouble(splited[2]),
                Double.parseDouble(splited[3]),
                Double.parseDouble(splited[1]),
                Double.parseDouble(splited[4])
            );

            quotes.add(quote);

            lastQuote = quote;
        }
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
}
