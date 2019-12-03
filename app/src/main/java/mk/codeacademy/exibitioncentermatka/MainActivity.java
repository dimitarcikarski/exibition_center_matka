package mk.codeacademy.exibitioncentermatka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import mk.codeacademy.exibitioncentermatka.fragments.ContactFragment;
import mk.codeacademy.exibitioncentermatka.fragments.HistoryFragment;
import mk.codeacademy.exibitioncentermatka.fragments.HomeFragment;
import mk.codeacademy.exibitioncentermatka.fragments.VideoFragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(this);
        bottomNav.setSelectedItemId(R.id.menu_home);

        BigImageViewer.initialize(GlideImageLoader.with(getApplicationContext()));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (menuItem.getItemId()){
            case R.id.menu_home:
                ft.replace(R.id.fragment_container, HomeFragment.newInstance() , HomeFragment.TAG );
                ft.commit();
                return true;
            case R.id.menu_video:
                ft.replace(R.id.fragment_container, VideoFragment.newInstance() , VideoFragment.TAG );
                ft.commit();
                return true;
            case R.id.menu_history:
                ft.replace(R.id.fragment_container, HistoryFragment.newInstance() , HistoryFragment.TAG );
                ft.commit();
                return true;
            case R.id.menu_contact:
                ft.replace(R.id.fragment_container, ContactFragment.newInstance() , ContactFragment.TAG );
                ft.commit();
                return true;
        }
        return false;
    }
}
