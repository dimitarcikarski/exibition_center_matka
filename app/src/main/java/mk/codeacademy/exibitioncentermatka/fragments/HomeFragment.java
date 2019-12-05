package mk.codeacademy.exibitioncentermatka.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import mk.codeacademy.exibitioncentermatka.ExponateDetailActivity;
import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.ExponateAdapter;
import mk.codeacademy.exibitioncentermatka.interfaces.ExponateListener;
import mk.codeacademy.exibitioncentermatka.models.Exponate;
import mk.codeacademy.exibitioncentermatka.models.ResponseExponateModel;

public class HomeFragment extends Fragment implements ExponateListener{

    public static final String TAG = HomeFragment.class.getSimpleName();


    RecyclerView recyclerView;
    ExponateAdapter adapter;
    ArrayList<Exponate> exponateList = new ArrayList<>();
    ImageView home_top_image;

    Gson gson;

    public static HomeFragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }


    public HomeFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.exponates_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        gson = new Gson();
        loadExponates();

        adapter = new ExponateAdapter(getActivity() , exponateList , this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        home_top_image = view.findViewById(R.id.home_top_image);
        home_top_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] RESOURCES = new Integer[]{R.drawable.home_exponat_img};

                new StfalconImageViewer.Builder<>(getActivity(), RESOURCES, new ImageLoader<Integer>() {
                    @Override
                    public void loadImage(ImageView imageView, Integer drawableRes) {
                        imageView.setImageResource(drawableRes);
                        imageView.setBackgroundColor(getResources().getColor(R.color.color_black));
                    }
                }).show();
            }
        });

        return view;
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getActivity().getAssets().open("eksponati.json");
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

    private void loadExponates() {

        String jsonString = loadJSONFromAsset();

        ResponseExponateModel responseExponateModel = gson.fromJson(jsonString , ResponseExponateModel.class);
        exponateList = responseExponateModel.getEksponati();

    }

    @Override
    public void viewExponate(Exponate exponate) {
        Intent i = new Intent(getActivity(), ExponateDetailActivity.class);
        i.putExtra(ExponateDetailActivity.EXPONATE , exponate);
        startActivity(i);
    }
}
