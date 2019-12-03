package mk.codeacademy.exibitioncentermatka.fragments;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.indicator.ProgressIndicator;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;

import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.ExponateAdapter;
import mk.codeacademy.exibitioncentermatka.interfaces.ExponateListener;
import mk.codeacademy.exibitioncentermatka.models.Exponate;

public class HomeFragment extends Fragment implements ExponateListener{

    public static final String TAG = HomeFragment.class.getSimpleName();


    RecyclerView recyclerView;
    ExponateAdapter adapter;
    ArrayList<Exponate> exponateList = new ArrayList<>();
    BigImageView bigImageView;

    //Gson gson;

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

        loadExponates();

        adapter = new ExponateAdapter(getActivity() , exponateList , this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        bigImageView = view.findViewById(R.id.mBigImage);

        return view;
    }

    /*public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getActivity().getAssets().open("exponates.json");
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

        adapter = new ExponateAdapter(getActivity() , exponateList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }*/

    public void loadExponates(){
        Exponate exponate1 = new Exponate();
        exponate1.setImages(R.drawable.plazma_topka);
        exponate1.setTitle("ПЛАЗМА ТОПКА");

        Exponate exponate2 = new Exponate();
        exponate2.setImages(R.drawable.plazma_paneli);
        exponate2.setTitle("ПЛАЗМА ПАНЕЛИ");

        Exponate exponate3 = new Exponate();
        exponate3.setImages(R.drawable.citati_na_naucnici);
        exponate3.setTitle("ЦИТАТИ НА НАУЧНИЦИ");

        Exponate exponate4 = new Exponate();
        exponate4.setImages(R.drawable.kontrolna_soba);
        exponate4.setTitle("КОНТРОЛНА СОБА");

        Exponate exponate5 = new Exponate();
        exponate5.setImages(R.drawable.kontrolna_soba_odnadvor);
        exponate5.setTitle("КОНТРОЛНА СОБА - ОДНАДВОР");

        Exponate exponate6 = new Exponate();
        exponate6.setImages(R.drawable.originalen_alat);
        exponate6.setTitle("ОРИГИНАЛЕН АЛАТ");

        Exponate exponate7 = new Exponate();
        exponate7.setImages(R.drawable.elektrifikacija_na_mak_test);
        exponate7.setTitle("ЕЛЕКТРИФИКАЦИЈА НА МАКЕДОНИЈА - ТЕСТ");

        Exponate exponate8 = new Exponate();
        exponate8.setImages(R.drawable.dispecerska_tabla_od_sedumdesetite);
        exponate8.setTitle("ДИСПЕЧЕРСКА СОБА ОД СЕДУМДЕСЕТИТЕ");

        Exponate exponate9 = new Exponate();
        exponate9.setImages(R.drawable.masinska_sala);
        exponate9.setTitle("МАШИНСКА САЛА");

        Exponate exponate10 = new Exponate();
        exponate10.setImages(R.drawable.transformator);
        exponate10.setTitle("ТРАНСФОРМАТОР");

        Exponate exponate11 = new Exponate();
        exponate11.setImages(R.drawable.veternica);
        exponate11.setTitle("ВЕТЕРНИЦА");

        Exponate exponate12 = new Exponate();
        exponate12.setImages(R.drawable.maketa_na_sistem);
        exponate12.setTitle("МАКЕТА НА СИСТЕМ: ПРОИЗВОДСТВВО, ПРЕНОС, ДИСТРИБУЦИЈА");

        Exponate exponate13 = new Exponate();
        exponate13.setImages(R.drawable.elektrifikacija_na_makedonija);
        exponate13.setTitle("ЕЛЕКТРИФИКАЦИЈА НА МАКЕДОНИЈА");

        Exponate exponate14 = new Exponate();
        exponate14.setImages(R.drawable.upotreba_na_elektricnata_energija_vo_svetot);
        exponate14.setTitle("УПОТРЕБА НА ЕЛЕКТРИЧНАТА ЕНЕРГИЈА ВО СВЕТОТ");

        Exponate exponate15 = new Exponate();
        exponate15.setImages(R.drawable.transformator2);
        exponate15.setTitle("ТРАНСФОРМАТОР");

        exponateList.add(exponate1);
        exponateList.add(exponate2);
        exponateList.add(exponate3);
        exponateList.add(exponate4);
        exponateList.add(exponate5);
        exponateList.add(exponate6);
        exponateList.add(exponate7);
        exponateList.add(exponate8);
        exponateList.add(exponate9);
        exponateList.add(exponate10);
        exponateList.add(exponate11);
        exponateList.add(exponate12);
        exponateList.add(exponate13);
        exponateList.add(exponate14);
        exponateList.add(exponate15);
    }

    @Override
    public void viewExponate(Exponate exponate) {

        bigImageView.showImage(
                Uri.parse("android.resource://mk.codeacademy.exibitioncentermatka/" + exponate.getImages()));
        bigImageView.setTapToRetry(true);
    }



    /*@Override
    public void viewExponate(int position , Exponate exponate) {

        List<Integer> list = new ArrayList<>();
        int x = exponate.getImages();
        list.add(x);

        new ImageViewer.Builder(getContext(), list)
                .setStartPosition(position)
                .show();

    }*/
}
