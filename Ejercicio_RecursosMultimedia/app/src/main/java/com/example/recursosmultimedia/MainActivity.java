package com.example.recursosmultimedia;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.VideoView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private VideoView videoView;
    private Button playAudioBtn;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        playAudioBtn = findViewById(R.id.playAudioBtn);

        imageView.setImageResource(R.drawable.logo_app);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample_video);
        videoView.setVideoURI(videoUri);
        videoView.setOnPreparedListener(mp -> videoView.start());

        mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        playAudioBtn.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Toast.makeText(this, "Reproduciendo sonido...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}