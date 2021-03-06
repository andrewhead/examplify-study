import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class ScrapeTextSlice {

  public static void main(String[] args) throws IOException {

    String arg0 = "electric bike";
    String query = URLEncoder.encode(arg0, "utf-8");
    URL url = new URL("https://sfbay.craigslist.org/search/bia?query=" + query);
    Document doc = Jsoup.parse(url, 3*1000);
    Elements rows = doc.select("li.result-row");
    for (Iterator rowsIterator = rows.iterator(); rowsIterator.hasNext();) {
      Element row = (Element) rowsIterator.next();
      String title = row.select("a.result-title.hdrlnk").text();
    }

  }

}
