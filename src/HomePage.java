import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;

public class HomePage {

    private final String date;
    private final String word;
    private final String meaning;
    private final String example;
    private final String tags[];
    private final String contributor;
    private final int like;
    private final int dislike;
    /**
     * @param e A div with "def-panel" class taken from the homepage
     * */
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
                tags[i] = e1.get(i).text().substring(1);
            }
        }
        contributor=e.getElementsByClass("contributor").first().text();
        e1=e.getElementsByClass("count");
        like=Integer.parseInt(e1.get(0).text());
        dislike=Integer.parseInt(e1.get(1).text());
    }

    public String getDate() {
        return date;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }

    public String getContributor() {
        return contributor;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
    }

    public int getTagCount(){
        return tags.length;
    }

    public String getTag(int i){
        return tags[i];
    }



    @java.lang.Override
    public java.lang.String toString() {
        return "HomePage{" +
                "date='" + date + '\'' +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", example='" + example + '\'' +
                ", tags=" + java.util.Arrays.toString(tags) +
                ", contributor='" + contributor + '\'' +
                ", like=" + like +
                ", dislike=" + dislike +
                '}';
    }
}
