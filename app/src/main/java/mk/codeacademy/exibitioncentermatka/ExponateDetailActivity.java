package mk.codeacademy.exibitioncentermatka;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mk.codeacademy.exibitioncentermatka.R;
import mk.codeacademy.exibitioncentermatka.adapters.DetailAdapter;
import mk.codeacademy.exibitioncentermatka.adapters.TopItemAdapter;
import mk.codeacademy.exibitioncentermatka.interfaces.HistoryListener;
import mk.codeacademy.exibitioncentermatka.models.Exponate;
import mk.codeacademy.exibitioncentermatka.models.TopItem;

public class ExponateDetailActivity extends AppCompatActivity implements HistoryListener {

    public static final String EXPONATE = "EXPONATE";

    RecyclerView recyclerView;
    DetailAdapter adapter;
    ArrayList<String> itemList = new ArrayList<>();

    ImageView top_image_view;
    TextView content_detail;
    TextView title_detail;

    Exponate exponate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exponate_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.color_white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        top_image_view = findViewById(R.id.exponate_top_image);
        content_detail = findViewById(R.id.details);
        title_detail = findViewById(R.id.exponate_title);

        exponate = getIntent().getParcelableExtra(EXPONATE);
        itemList = exponate.getImages();

        String mDrawableName = exponate.getImages().get(0);
        int resID = this.getResources().getIdentifier(mDrawableName , "drawable", this.getPackageName());
        top_image_view.setImageResource(resID);

        content_detail.setText(exponate.getContent());
        title_detail.setText(exponate.getTitle());

        recyclerView = findViewById(R.id.exponate_detail_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL , false));

        adapter = new DetailAdapter(this, itemList , this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void viewImages(int position) {
        new StfalconImageViewer.Builder<>(ExponateDetailActivity.this, itemList, new ImageLoader<String>() {
            @Override
            public void loadImage(ImageView imageView, String drawableRes) {
                String mDrawableName = drawableRes;
                int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
                imageView.setImageResource(resID);
                imageView.setBackgroundColor(getResources().getColor(R.color.color_black));
            }
        }).withStartPosition(position).show();
    }
}
