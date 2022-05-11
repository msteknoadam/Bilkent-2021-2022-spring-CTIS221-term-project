/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author TEKNO
 */
public class MusicPlayerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> trackFiles = listSpecificFiles("tracks", ".mp3");
        ArrayList<String> imageFiles = listSpecificFiles("images", ".jpg");

        TrackSys.updateTrackPaths(trackFiles);
        TrackSys.updateImagePaths(imageFiles);

        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }

    public static ArrayList<String> listSpecificFiles(String dir, String suffix) {
        ArrayList<String> out = new ArrayList();
        try (Stream<Path> stream = Files.walk(Paths.get(dir), 1)) {
            Set<String> files = stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());

            for (String file : files) {
                if (file.endsWith(suffix)) {
                    out.add(dir + "/" + file);
                }
            }

            return out;
        } catch (IOException ex) {
            System.err.printf("Couldn't find any files ending with suffix '%s' in directory '%s'.", suffix, dir);
            return out;
        }
    }

}
