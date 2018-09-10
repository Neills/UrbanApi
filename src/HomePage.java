import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;

public class HomePage {

    private String date;
    private String word;
    private String meaning;
    private String example;
    private String tags[];
    private String contributor;
    private int like;
    private int dislike;

    public HomePage(Element e){
        date=e.getElementsByClass("ribbon").first().text();
        word=e.getElementsByClass("word").first().text();
        meaning=e.getElementsByClass("meaning").first().text();
        example=e.getElementsByClass("example").first().text();
        Elements e1 = e.getElementsByClass("tags");
        if(e1.size()>0) {
            e1 = e1.first().getElementsByTag("a");
            tags = new String[e1.size()];
            for (int i = 0; i < e1.size(); i++) {
                tags[i] = e1.get(i).text();
            }
        }
        contributor=e.getElementsByClass("contributor").first().text();
        like=Integer.parseInt(e.getElementsByClass("count").get(0).text());
        dislike=Integer.parseInt(e.getElementsByClass("count").get(1).text());
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "HomePage{" +
                "date='" + date + '\'' +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", example='" + example + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", contributor='" + contributor + '\'' +
                ", like=" + like +
                ", dislike=" + dislike +
                '}';
    }
}
