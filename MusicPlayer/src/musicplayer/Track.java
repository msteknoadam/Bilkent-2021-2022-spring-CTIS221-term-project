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
abstract public class Track implements TrackInterface {

    protected String name;
    protected double length;
    protected ImageIcon thumbnailImage;
    protected File file;
    protected boolean liked;

    public Track(String name, double length, ImageIcon thumbnailImage, File file) {
        this.name = name;
        this.length = length;
        this.thumbnailImage = thumbnailImage;
        this.file = file;
        this.liked = false;
    }

    abstract void showCredits();

    @Override
    public String toString() {
        String out = "";
        out += "Name: " + this.name + "\n";
        out += "Length (in seconds): " + this.length + "\n";
        out += "Liked: " + this.liked + "\n";

        return out;
    }

    @Override
    public boolean toggleLike() {
        this.liked = !this.liked;
        return this.liked;
    }

}
