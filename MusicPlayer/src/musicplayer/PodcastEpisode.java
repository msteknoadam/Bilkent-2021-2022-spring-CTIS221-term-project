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
public class PodcastEpisode extends Track {

    private String episode;
    private String description;
    private String podcaster;

    @Override
    public void showCredits() {
        // GUI ?
    }

    public PodcastEpisode(String name, double length, ImageIcon thumbnailImage, File file, String episode, String description, String podcaster) {
        super(name, length, thumbnailImage, file);
        this.episode = episode;
        this.description = description;
        this.podcaster = podcaster;
    }

}
