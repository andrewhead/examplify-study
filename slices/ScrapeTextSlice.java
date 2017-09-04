import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScrapeImageLinksSlice {

    public static void main(String[] args) throws IOException {
        args = new String[]{"electric bike", "openairandrew@gmail.com"};
        String query = URLEncoder.encode(args[0], "utf-8");
        String destination = args[1];
        URL url = new URL("https://sfbay.craigslist.org/search/bia?query=" + query);
        Document doc = Jsoup.parse(url, 3*1000);
        Elements rows = doc.select("li.result-row");
        for (Iterator rowsIterator = rows.iterator(); rowsIterator.hasNext();) {
            Element row = (Element) rowsIterator.next();
            String title = row.select("a.result-title.hdrlnk").text();
        }
    }
}
