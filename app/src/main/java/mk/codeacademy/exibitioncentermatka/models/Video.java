package mk.codeacademy.exibitioncentermatka.models;

import java.util.ArrayList;

public class Video {

    String title , videoPath;
    ArrayList<String> videoImages;

    public Video(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public ArrayList<String> getVideoImages() {
        return videoImages;
    }

    public void setVideoImages(ArrayList<String> videoImages) {
        this.videoImages = videoImages;
    }
}
