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
public class TrackSys {

    public static ArrayList<Track> tracks = new ArrayList();
//    public Set<Playlist> playlists = new Set(); // uncomment when Playlist implemented

    public static boolean addTrack(Track track) {
        for (Track t : tracks) {
            if (t.name.equalsIgnoreCase(track.name)) {
                return false;
            }
        }

        tracks.add(track);
        return true;
    }

    public static boolean deleteTrack(String trackName) {
        for (Track t : tracks) {
            if (t.name.equalsIgnoreCase(trackName)) {
                tracks.remove(t);
                return true;
            }
        }

        return false;
    }

    public static Track searchTrack(String trackName) {
        for (Track t : tracks) {
            if (t.name.equalsIgnoreCase(trackName)) {
                return t;
            }
        }

        return null;
    }

    public static String display() {
        String out = "";

        for (Track t : tracks) {
            out += t.toString() + "\n";
        }

        return out;
    }

    public static double calculateTotalLength() {
        double total = 0;

        for (Track t : tracks) {
            total += t.length;
        }

        return total;
    }

}
