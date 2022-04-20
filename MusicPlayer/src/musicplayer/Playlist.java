/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.util.ArrayList;

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

    public Playlist(String name, String description) {
        this.name = name;
        this.description = description;
        this.trackCount = 0;
        this.totalLength = 0;
        TrackSys.playlists.add(this);
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

}
