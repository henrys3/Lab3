
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Li
 *
 */
public class Lab3 {
    /**
     *
     * @param args argument
     */
    public static void main(final String[] args) {
        String text = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        int wordCount = 1;
        for (int i = 1; i < text.length(); i++) {
            if ((text.substring(i, i + 1).equals(" ") || text.substring(i, i + 1).equals("\t"))) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
    /**
     *
     * @param url the text in the url
     * @return contents
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
