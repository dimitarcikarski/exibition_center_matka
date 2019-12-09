package mk.codeacademy.exibitioncentermatka.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.VideoAdapter;
import mk.codeacademy.exibitioncentermatka.interfaces.VideoListener;
import mk.codeacademy.exibitioncentermatka.models.ResponseExponateModel;
import mk.codeacademy.exibitioncentermatka.models.Video;
import mk.codeacademy.exibitioncentermatka.models.VideosResponseModel;

public class VideoFragment extends Fragment implements VideoListener {

    public static final String TAG = VideoFragment.class.getSimpleName();

    RecyclerView recyclerView;
    VideoAdapter adapter;
    ArrayList<Video> videoList = new ArrayList<>();
    ImageView play_button;
    String videoId = "qwkQVShCklw";
    Gson gson;

    ImageView video_top_image;

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }


    public VideoFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        play_button = view.findViewById(R.id.play_button);
        video_top_image = view.findViewById(R.id.video_top_image);

        recyclerView = view.findViewById(R.id.video_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));

        gson = new Gson();
        loadVideos();

        
        adapter = new VideoAdapter(getActivity(),videoList,this);
        recyclerView.setAdapter(adapter);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
                intent.putExtra("VIDEO_ID", videoId);
                intent.putExtra("force_fullscreen",true);
                startActivity(intent);
            }
        });


        return view;
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getActivity().getAssets().open("videos.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void loadVideos() {

        String jsonString = loadJSONFromAsset();

        VideosResponseModel videosResponseModel = gson.fromJson(jsonString , VideosResponseModel.class);
        videoList = videosResponseModel.getVideos();

    }

    @Override
    public void videoSwitch(Video video) {
        String videoId = video.getVideoPath();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
        intent.putExtra("VIDEO_ID", videoId);
        intent.putExtra("force_fullscreen",true);
        startActivity(intent);
    }
}
