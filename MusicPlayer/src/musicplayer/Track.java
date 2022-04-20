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
abstract public class Track {
    protected String name;
    protected double length;
    protected ImageIcon thumbnailImage;
    protected File file;
    protected boolean liked;
    
    abstract void showCredits();
    
    public Track(String name, double length, ImageIcon thumbnailImage, File file, boolean liked) {
        this.name = name;
        this.length = length;
        this.thumbnailImage = thumbnailImage;
        this.file = file;
        this.liked = liked;
    }
    
}
