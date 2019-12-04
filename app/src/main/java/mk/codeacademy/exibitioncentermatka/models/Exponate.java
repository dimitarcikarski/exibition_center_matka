package mk.codeacademy.exibitioncentermatka.models;

import java.util.ArrayList;

public class Exponate {

    String title , content;
    ArrayList<String> images;

    public Exponate(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
