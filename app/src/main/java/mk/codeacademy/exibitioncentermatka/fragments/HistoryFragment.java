package mk.codeacademy.exibitioncentermatka.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.HistoryAdapter;
import mk.codeacademy.exibitioncentermatka.models.HistoryItem;

public class HistoryFragment extends Fragment {

    public static final String TAG = HistoryFragment.class.getSimpleName();

    RecyclerView recyclerView;
    HistoryAdapter adapter;
    ArrayList<HistoryItem> itemList = new ArrayList<>();

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

        adapter = new HistoryAdapter(getActivity(), itemList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void getImages() {
        HistoryItem historyItem1 = new HistoryItem();
        historyItem1.setImg(R.drawable.hystory_one);

        HistoryItem historyItem2 = new HistoryItem();
        historyItem2.setImg(R.drawable.hystory_two);

        HistoryItem historyItem3 = new HistoryItem();
        historyItem3.setImg(R.drawable.hystory_three);

        HistoryItem historyItem4 = new HistoryItem();
        historyItem4.setImg(R.drawable.hystory_four);

        itemList.add(historyItem1);
        itemList.add(historyItem2);
        itemList.add(historyItem3);
        itemList.add(historyItem4);

    }

}