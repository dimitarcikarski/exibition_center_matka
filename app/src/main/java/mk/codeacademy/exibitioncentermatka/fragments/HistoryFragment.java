package mk.codeacademy.exibitioncentermatka.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;

import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.TopItemAdapter;
import mk.codeacademy.exibitioncentermatka.interfaces.HistoryListener;
import mk.codeacademy.exibitioncentermatka.models.TopItem;

public class HistoryFragment extends Fragment implements HistoryListener {

    public static final String TAG = HistoryFragment.class.getSimpleName();

    RecyclerView recyclerView;
    TopItemAdapter adapter;
    ArrayList<TopItem> itemList = new ArrayList<>();
    ImageView top_image_history;

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }


    public HistoryFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL , false));

        getImages();

        adapter = new TopItemAdapter(getActivity(), itemList , this);
        recyclerView.setAdapter(adapter);

        top_image_history = view.findViewById(R.id.history_top_image);
        top_image_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new StfalconImageViewer.Builder<>(getActivity(), itemList, new ImageLoader<TopItem>() {
                    @Override
                    public void loadImage(ImageView imageView, TopItem drawableRes) {
                        imageView.setImageResource(drawableRes.getImg());
                        imageView.setBackgroundColor(getResources().getColor(R.color.color_black));
                    }
                }).withStartPosition(0).show();
            }
        });

        return view;
    }

    private void getImages() {
        TopItem topItem0 = new TopItem();
        topItem0.setImg(R.drawable.hystory_top_image);

        TopItem topItem1 = new TopItem();
        topItem1.setImg(R.drawable.hystory_one);

        TopItem topItem2 = new TopItem();
        topItem2.setImg(R.drawable.hystory_two);

        TopItem topItem3 = new TopItem();
        topItem3.setImg(R.drawable.hystory_three);

        TopItem topItem4 = new TopItem();
        topItem4.setImg(R.drawable.hystory_four);

        itemList.add(topItem0);
        itemList.add(topItem1);
        itemList.add(topItem2);
        itemList.add(topItem3);
        itemList.add(topItem4);

    }

    @Override
    public void viewImages(int position) {

        new StfalconImageViewer.Builder<>(getActivity(), itemList, new ImageLoader<TopItem>() {
            @Override
            public void loadImage(ImageView imageView, TopItem drawableRes) {
                imageView.setImageResource(drawableRes.getImg());
                imageView.setBackgroundColor(getResources().getColor(R.color.color_black));
            }
        }).withStartPosition(position).show();
    }
}
