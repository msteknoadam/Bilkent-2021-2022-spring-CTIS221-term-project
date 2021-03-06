/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inheritance;

import GUI.CreditsFrame;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author TEKNO
 */
public class Song extends Track {

    private String artist;
    private String albumName;
    private String genre;

    public Song(String name, double length, ImageIcon thumbnailImage, File file, String artist, String albumName, String genre) {
        super(name, length, thumbnailImage, file);
        this.artist = artist;
        this.albumName = albumName;
        this.genre = genre;
    }

    @Override
    public void showCredits() {
        CreditsFrame frame = new CreditsFrame(this.toString());
        frame.setVisible(true);
    }

    @Override
    public String toString() {
        String out = "Song\n" + super.toString();
        out += "Artist: " + this.artist + "\n";
        out += "Album Name: " + this.albumName + "\n";
        out += "Genre: " + this.genre + "\n";

        return out;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getGenre() {
        return genre;
    }

}
