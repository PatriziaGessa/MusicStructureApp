package com.example.android.musicstructureapp;

import java.util.Objects;

/**
 * {@link Music} represents a musical composition.
 * It contains the title of the song and the name of the singer.
 */
public class Music {
    // Song's title.
    private String songTitle;
    // Singer's name.
    private String singerName;


    /**
     * Create a Music constructor.
     *
     * @param songTitle  is the title of the song.
     * @param singerName the name of the singer.
     */
    public Music(String songTitle, String singerName) {
        this.songTitle = songTitle;
        this.singerName = singerName;

    }


    // Get the title of the song.
    public String getSongTitle() {
        return songTitle;
    }

    // Get the name of the singer.
    public String getSingerName() {
        return singerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(songTitle, music.songTitle) &&
                Objects.equals(singerName, music.singerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songTitle, singerName);
    }
}
