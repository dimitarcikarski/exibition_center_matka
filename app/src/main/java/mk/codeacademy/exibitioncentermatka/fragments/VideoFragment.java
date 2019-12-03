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

import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.VideoAdapter;
import mk.codeacademy.exibitioncentermatka.interfaces.VideoListener;
import mk.codeacademy.exibitioncentermatka.models.Video;

public class VideoFragment extends Fragment implements VideoListener {

    public static final String TAG = VideoFragment.class.getSimpleName();

    RecyclerView recyclerView;
    VideoAdapter adapter;
    ArrayList<Video> videoList = new ArrayList<>();
    ImageView play_button;
    String videoId = "ui2-ca-Cr7o";

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

        getVideos();
        
        adapter = new VideoAdapter(getActivity(),videoList,this);
        recyclerView.setAdapter(adapter);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYoutube(videoId);
            }
        });


        return view;
    }

    public void openYoutube(String videoId){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
        intent.putExtra("VIDEO_ID", videoId);
        intent.putExtra("force_fullscreen",true);
        startActivity(intent);
    }

    private void getVideos() {
        Video video1 = new Video();
        video1.setImage(R.drawable.tesla_den);
        video1.setTitle("Денот на Тесла");
        video1.setVideoPath("ui2-ca-Cr7o");

        Video video2 = new Video();
        video2.setImage(R.drawable.matka_den);
        video2.setTitle("Денот на Тесла - Цртежи");
        video2.setVideoPath("g28xG1R15Lo");

        Video video3 = new Video();
        video3.setImage(R.drawable.istorija_naelekktrifikacija_na_makedonija);
        video3.setTitle("Историја на електрификација во Македонија");
        video3.setVideoPath("ci93H59m2IY");

        Video video4 = new Video();
        video4.setImage(R.drawable.energetska_efikasnost);
        video4.setTitle("Енергетска ефикасност");
        video4.setVideoPath("u8Yr9vqyU_8");

        Video video5 = new Video();
        video5.setImage(R.drawable.patot_na_strujata);
        video5.setTitle("Патот на струјата");
        video5.setVideoPath("mXEulg0a1Yk");

        Video video6 = new Video();
        video6.setImage(R.drawable.kako_se_prenesuva_struja);
        video6.setTitle("Како се пренесува струјата?");
        video6.setVideoPath("Y0roxYTwLwQ");

        Video video7 = new Video();
        video7.setImage(R.drawable.obnovlivi_izvori);
        video7.setTitle("Обновливи извори на енергија");
        video7.setVideoPath("qwkQVShCklw");

        Video video8 = new Video();
        video8.setImage(R.drawable.sto_e_struja);
        video8.setTitle("Што е струја?");
        video8.setVideoPath("ohWQvr7y93k");

        videoList.add(video1);
        videoList.add(video2);
        videoList.add(video3);
        videoList.add(video4);
        videoList.add(video5);
        videoList.add(video6);
        videoList.add(video7);
        videoList.add(video8);
    }


    @Override
    public void videoSwitch(Video video) {
        video_top_image.setImageResource(video.getImage());
        videoId = video.getVideoPath();
    }
}
