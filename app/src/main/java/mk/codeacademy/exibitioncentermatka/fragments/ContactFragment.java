package mk.codeacademy.exibitioncentermatka.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.WebActivity;

import static android.content.Intent.ACTION_VIEW;

public class ContactFragment extends Fragment {

    public static final String TAG = ContactFragment.class.getSimpleName();
    public static final String URL = "url";

    ImageView map;
    TextView phone_number;
    ImageView to_matka_bus;
    ImageView to_matka_taxi;
    ImageView to_skopje_plane;
    ImageView to_skopje_bus;
    ImageView to_skopje_train;
    ImageView evn;

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }

    public ContactFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conntact, container, false);

        map = view.findViewById(R.id.contact_top_map);
        phone_number = view.findViewById(R.id.phone_number);
        to_matka_bus = view.findViewById(R.id.fromMatka_bus);
        to_matka_taxi = view.findViewById(R.id.fromMatka_taxi);
        to_skopje_plane = view.findViewById(R.id.toSkopjePlane);
        to_skopje_bus = view.findViewById(R.id.toSkopjeBus);
        to_skopje_train = view.findViewById(R.id.toSkopjeTrain);
        evn = view.findViewById(R.id.evn);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com/maps/search/matka/@41.9528457,21.2979605,328m/data=!3m1!1e3";
                Intent i = new Intent(ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        phone_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "072935105";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(i);
            }

        });

        to_matka_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.jsp.com.mk/PlanskiVozenRed.aspx";
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra( URL ,url);
                startActivity(i);
            }
        });

        to_matka_taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://zk.mk/taksi-kompanii/skopje";
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra( URL ,url);
                startActivity(i);
            }
        });

        to_skopje_plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://skp.airports.com.mk/default.aspx?ItemID=345";
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra( URL ,url);
                startActivity(i);
            }
        });

        to_skopje_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://sas.com.mk/VozenRed.aspx";
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra( URL ,url);
                startActivity(i);
            }
        });

        to_skopje_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://mzt.mk/pristigane-vo-skopje/?lang=mk";
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra( URL ,url);
                startActivity(i);
            }
        });

        evn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://mzt.mk";
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra( URL ,url);
                startActivity(i);
            }
        });

        return view;
    }

}
