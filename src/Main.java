import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class Main {
    public static void main(String args[]){
        try {
            Document doc = Jsoup.connect("https://www.urbandictionary.com").get();
            for(Element e:doc.getElementsByClass("def-panel")){
                new HomePage(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
