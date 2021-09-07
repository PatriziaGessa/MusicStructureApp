package com.example.android.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        playing();
    }

    public void playing() {
        // Get extras from Intent.
        Intent i = getIntent();

        // Set the title of the song for playing.
        TextView nowPlayingSongText = (TextView) findViewById(R.id.song_player);
        String nowPlayingSong = i.getStringExtra("Song");
        nowPlayingSongText.setText(nowPlayingSong);

        // Set the name of the singer for playing.
        TextView nowPlayingArtistText = (TextView) findViewById(R.id.artist_player);
        String nowPlayingArtist = i.getStringExtra("Singer");
        nowPlayingArtistText.setText(nowPlayingArtist);


    }
}