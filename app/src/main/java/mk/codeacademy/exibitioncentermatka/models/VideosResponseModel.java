package mk.codeacademy.exibitioncentermatka.models;

import java.util.ArrayList;

public class VideosResponseModel {
    int numberOfItems;
    ArrayList<Video> videos;

    public VideosResponseModel(){}

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
}
