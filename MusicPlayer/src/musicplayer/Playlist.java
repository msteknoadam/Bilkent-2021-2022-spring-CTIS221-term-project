/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author TEKNO
 */
public class Playlist {

    private String name;
    private String description;
    private int trackCount;
    private double totalLength;
    private ArrayList<Track> tracks = new ArrayList();
    private static int playlistCount = 0;

    public Playlist(String name, String description) {
        this.name = name;
        this.description = description;
        this.trackCount = 0;
        this.totalLength = 0;
        TrackSys.playlists.add(this);
        playlistCount++;
    }

    @Override
    public String toString() {
        String out = "Playlist\n";
        out += "Name: " + this.name + "\n";
        out += "Description: " + this.description + "\n";
        out += "Track Count: " + this.trackCount + "\n";
        out += "Total Length: " + this.totalLength + "\n";
        out += "Tracks:\n";

        for (Track t : this.tracks) {
            out += "\t" + t.toString() + "\n";
        }

        return out;
    }

    public boolean addTrack(Track track) {
        for (Track t : tracks) {
            if (t.name.equalsIgnoreCase(track.name)) {
                return false;
            }
        }

        tracks.add(track);
        return true;
    }

    public boolean removeTrack(String trackName) {
        for (Track t : tracks) {
            if (t.name.equalsIgnoreCase(trackName)) {
                tracks.remove(t);
                return true;
            }
        }

        return false;
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public void setTotalLength(double totalLength) {
        this.totalLength = totalLength;
    }

    public static int getPlaylistCount() {
        return playlistCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Playlist other = (Playlist) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

}
