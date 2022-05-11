/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SysAndMain;

import Inheritance.Track;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import HasA.Playlist;

/**
 *
 * @author TEKNO
 */
public class TrackSys {

    public static ArrayList<Track> tracks = new ArrayList();
    public static HashSet<Playlist> playlists = new HashSet();
    public static TreeSet<String> trackPaths = new TreeSet();
    public static TreeSet<String> imagePaths = new TreeSet();

    public static void updateTrackPaths(ArrayList<String> list) {
        trackPaths.addAll(list);
    }

    public static void updateImagePaths(ArrayList<String> list) {
        imagePaths.addAll(list);
    }

    public static boolean addTrack(Track track) {
        for (Track t : tracks) {
            if (t.getName().equalsIgnoreCase(track.getName())) {
                return false;
            }
        }

        tracks.add(track);
        return true;
    }

    public static boolean deleteTrack(String trackName) {
        for (Track t : tracks) {
            if (t.getName().equalsIgnoreCase(trackName)) {
                tracks.remove(t);

                for (Playlist p : playlists) {
                    p.removeTrack(trackName);
                }

                TrackSys.calculatePlaylistTotals();
                TrackSys.calculateTotalLength();
                return true;
            }
        }

        return false;
    }

    public static Track searchTrack(String trackName) {
        for (Track t : tracks) {
            if (t.getName().equalsIgnoreCase(trackName)) {
                return t;
            }
        }

        return null;
    }

    public static Playlist searchPlaylist(String playlistName) {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(playlistName)) {
                return p;
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
            total += t.getLength();
        }

        return total;
    }

    public static void calculatePlaylistTotals() {
        for (Playlist p : playlists) {
            int trackCount = 0;
            double totalLength = 0;
            ArrayList<Track> ptracks = p.getTracks();

            for (Track t : ptracks) {
                trackCount++;
                totalLength += t.getLength();
            }

            p.setTrackCount(trackCount);
            p.setTotalLength(totalLength);
        }
    }

}
