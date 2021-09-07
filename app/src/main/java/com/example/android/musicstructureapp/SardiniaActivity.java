package com.example.android.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SardiniaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        // Create a list of Music
        final ArrayList<Music> musics = new ArrayList<Music>();
        musics.add(new Music("Cuore e vento", "Modà feat. Tezenda"));
        musics.add(new Music("No potho reposare", "Andre Parodi"));
        musics.add(new Music("Dimonios", "Brigata Sassari"));
        musics.add(new Music("Trallalera", "Folk music"));
        musics.add(new Music("Domo mea", "Tazenda"));
        musics.add(new Music("Nanneddu meu", "Folk music"));
        musics.add(new Music("Spunta la luna dal monte", "Tezenda"));
        musics.add(new Music("Ballu tundu", "Folk music"));
        musics.add(new Music("Dillo", "Maria Carta"));
        musics.add(new Music("Janas", "Anninora"));
        musics.add(new Music("Barritas", "Gambale Twist"));


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
                Intent intent = new Intent(SardiniaActivity.this, PlayerActivity.class);
                intent.putExtra("Song", song);
                intent.putExtra("Singer", singer);
                startActivity(intent);
            }
        });



    }
}
