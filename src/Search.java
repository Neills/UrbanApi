import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Arrays;

public class Search {

    private String query;
    private HomePage panels[];
    private int page;
    private int totalPages=1;

    public String getQuery() {
        return query;
    }

    public int getPanelCount(){
        return panels.length;
    }

    @Override
    public String toString() {
        return "Search{" +
                "query='" + query + '\'' +
                ", panels=" + Arrays.toString(panels) +
                '}';
    }

    public HomePage getPanel(int i){
        return panels[i];
    }

    public Search(String s, int p){
        page=p;
        String url="https://www.urbandictionary.com/define.php?term="+s.replace(' ','+')+"&page="+page;
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("def-panel");
            panels = new HomePage[elements.size()];
            for(int i=0; i<panels.length; i++){
                panels[i]=new HomePage(elements.get(i));
            }
            query=panels[0].getWord();
            Element e1 = doc.getElementsByClass("pagination").first().getElementsByTag("li").last();
            if(e1.hasClass("current")) totalPages=Integer.parseInt(e1.text());
            else{
                e1=e1.getElementsByTag("a").first();
                String t = e1.attr("href");
                totalPages=Integer.parseInt(t.substring(t.lastIndexOf('=')+1));

            }
        } catch (IOException e) {
            e.printStackTrace();
            query=s;
            panels =  new HomePage[0];
        }

    }

}
