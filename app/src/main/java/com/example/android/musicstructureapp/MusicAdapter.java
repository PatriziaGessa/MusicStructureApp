package com.example.android.musicstructureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * {@link MusicAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * * based on a data source, which is a list of {@link Music} objects.
 */
public class MusicAdapter extends ArrayAdapter<Music> {


    /**
     * Create a new {@link MusicAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param musics  is the list of {@link Music} to be displayed.
     */
    public MusicAdapter(Context context, ArrayList<Music> musics) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, musics);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        // Get the {@link Music} object located at this position in the list.
        Music currentMusic = getItem(position);

        // Find the TextView in the item_list.xml layout with the ID song_title.
        TextView songTextView = listItemView.findViewById(R.id.song_name);
        // Get the version name from the current Music object and
        // set this text on the name TextView.
        songTextView.setText(currentMusic.getSongTitle());

        // Find the TextView in the item_list.xml layout with the ID artist_name.
        TextView artistNameTextView = listItemView.findViewById(R.id.artist_name);

        // Get the name of the singer from current Music object and
        // set this text on the name TextView.
        artistNameTextView.setText(currentMusic.getSingerName());


        // Return the whole item list layout (containing two TextViews)
        // so that it can show in the ListView.
        return listItemView;

    }
}
