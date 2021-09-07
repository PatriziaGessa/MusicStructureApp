package com.example.android.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItalyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        // Create a list of Music
        final ArrayList<Music> musics = new ArrayList<Music>();
        musics.add(new Music("Felicità", "Al Bano & Romina Power,"));
        musics.add(new Music("Lasciatemi Cantare", "Toto Cotugno"));
        musics.add(new Music("Vivo per lei", "Andrea Bocelli"));
        musics.add(new Music("O sole mio", "Luciano Pavarotti"));
        musics.add(new Music("Il cielo in una stanza", "Gino Paoli"));
        musics.add(new Music("Nessun dorma", "Luciano Pavarotti"));
        musics.add(new Music("Tu vuò fà l'americano", "Renato Carosone"));
        musics.add(new Music("Malafemmena", "Renato Carosone"));
        musics.add(new Music("Azzurro", "Adriano Celentano"));
        musics.add(new Music("Ti amo", "Umberto Tozzi"));
        musics.add(new Music("Bella ciao", "Unknown"));


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
                Intent intent = new Intent(ItalyActivity.this, PlayerActivity.class);
                intent.putExtra("Song", song);
                intent.putExtra("Singer", singer);
                startActivity(intent);
            }
        });
    }
}