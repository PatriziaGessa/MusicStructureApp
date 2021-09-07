package com.example.android.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AustriaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        // Create a list of Music
        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Rise like a phoenix", "Conchita Wurst"));
        musics.add(new Music("Rock me Amadeus", "Falco"));
        musics.add(new Music("Der Kommissar", "Falco"));
        musics.add(new Music("An der schönen blauen Donau ", "Strauss"));
        musics.add(new Music("Brenna tuats guat", "Hubert von Goisern"));
        musics.add(new Music("Radetzky-Marsch", "Johann Strauss "));
        musics.add(new Music("Kitzbüheler Feischtagmusig", "Folk music"));
        musics.add(new Music("Eine Kleine Nachtmusik", "Wolfgang Amadeus Mozart"));
        musics.add(new Music("Ich liebe dich", "Eric Papilaya"));
        musics.add(new Music("Ein ins leben", "Pizzera & Jaus"));
        musics.add(new Music("Cordula Grün", "Josh"));


        // Create an {@link MusicAdapter}, whose data source is a list of {@link Music}.
        // The adapter knows how to create list items for each item in the list.
        MusicAdapter adapter = new MusicAdapter(this, musics);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // play_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Music} in the list.
        listView.setAdapter(adapter);


        /**
         * Method to identify ListView item clicked and launch PlayerActivity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected Music.
                Music currentSong = (Music) parent.getItemAtPosition(position);
                String song = currentSong.getSongTitle();
                String singer = currentSong.getSingerName();

                // Sending the title of the song and her/his singer to PlayerActivity.
                Intent intent = new Intent(AustriaActivity.this, PlayerActivity.class);
                intent.putExtra("Song", song);
                intent.putExtra("Singer", singer);
                startActivity(intent);
            }
        });

    }
}
