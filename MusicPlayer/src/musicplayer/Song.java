/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

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

    public void showCredits() {
        // GUI ?
    }

    public Song(String name, double length, ImageIcon thumbnailImage, File file, String artist, String albumName, String genre) {
        super(name, length, thumbnailImage, file);
        this.artist = artist;
        this.albumName = albumName;
        this.genre = genre;
    }

}