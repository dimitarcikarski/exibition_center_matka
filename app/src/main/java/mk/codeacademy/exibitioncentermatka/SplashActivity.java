package mk.codeacademy.exibitioncentermatka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {

    VideoView video;
    String path = "android.resource://mk.codeacademy.exibitioncentermatka/" + R.raw.splash_screen_video;
    TextView continue_splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        video = findViewById(R.id.video);
        video.setVideoURI(Uri.parse(path));
        video.start();

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.setLooping(true);
            }
        });

        continue_splash = findViewById(R.id.continue_splash);

        continue_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}