package mk.codeacademy.exibitioncentermatka.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Exponate implements Parcelable {

    String title , content;
    ArrayList<String> images;

    public Exponate(){}

    protected Exponate(Parcel in) {
        title = in.readString();
        content = in.readString();
        images = in.createStringArrayList();
    }

    public static final Creator<Exponate> CREATOR = new Creator<Exponate>() {
        @Override
        public Exponate createFromParcel(Parcel in) {
            return new Exponate(in);
        }

        @Override
        public Exponate[] newArray(int size) {
            return new Exponate[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeStringList(images);
    }
}
