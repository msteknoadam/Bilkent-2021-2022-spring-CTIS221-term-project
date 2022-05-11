/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import HasA.Playlist;
import Inheritance.Track;
import SysAndMain.TrackSys;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author TEKNO
 */
public class CreatePlaylistFrame extends javax.swing.JFrame {

    MainFrame mf;

    /**
     * Creates new form CreatePlaylistFrame
     */
    public CreatePlaylistFrame(MainFrame mf) {
        initComponents();
        this.mf = mf;
    }

    public void updateTracksList() {
        DefaultListModel model = new DefaultListModel();

        for (Track t : TrackSys.tracks) {
            model.addElement(t.getName());
        }

        this.TracksList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlaylistNameLabel = new javax.swing.JLabel();
        PlaylistDescriptionLabel = new javax.swing.JLabel();
        PlaylistNameTextField = new javax.swing.JTextField();
        PlaylistDescriptionTextField = new javax.swing.JTextField();
        TracksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TracksList = new javax.swing.JList<>();
        StatusLabel = new javax.swing.JLabel();
        CloseButton = new javax.swing.JButton();
        InfoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PlaylistNameLabel.setText("Playlist Name:");

        PlaylistDescriptionLabel.setText("Playlist Description:");

        PlaylistNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PlaylistNameTextFieldKeyPressed(evt);
            }
        });

        TracksLabel.setText("Tracks:");

        jScrollPane1.setViewportView(TracksList);

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        InfoLabel.setText("Press Enter on Playlist Name Input to Create Playlist!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PlaylistNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PlaylistNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PlaylistDescriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlaylistDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TracksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(InfoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(CloseButton))
                    .addComponent(StatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlaylistNameLabel)
                    .addComponent(PlaylistNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlaylistDescriptionLabel)
                    .addComponent(PlaylistDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TracksLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(StatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseButton)
                    .addComponent(InfoLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        this.PlaylistNameTextField.setText("");
        this.PlaylistDescriptionTextField.setText("");
        this.StatusLabel.setText("");
        this.TracksList.clearSelection();
        TrackSys.calculatePlaylistTotals();
        this.mf.updatePlaylistsList();
        this.mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void PlaylistNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlaylistNameTextFieldKeyPressed
        if (evt.getKeyCode() == 10) { // keycode 10 is Enter
            String playlistName = this.PlaylistNameTextField.getText();
            String playlistDescription = this.PlaylistDescriptionTextField.getText();

            List<String> selected = this.TracksList.getSelectedValuesList();

            if (playlistName.equals("") || playlistDescription.equals("")) {
                this.StatusLabel.setText("Please fill in all of the fields.");
                return;
            }

            if (selected.isEmpty()) {
                this.StatusLabel.setText("Please select at least one track to be included in the playlist.");
                return;
            }

            // duplicate playlists are handled by HashSet
            Playlist p = new Playlist(playlistName, playlistDescription);

            for (String trackName : selected) {
                Track found = TrackSys.searchTrack(trackName);

                if (found != null) {
                    p.addTrack(found);
                }
                // technically it's not possible for found to be null but just to be safe
            }

            this.StatusLabel.setText("Playlist added successfully!");
        }
    }//GEN-LAST:event_PlaylistNameTextFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel PlaylistDescriptionLabel;
    private javax.swing.JTextField PlaylistDescriptionTextField;
    private javax.swing.JLabel PlaylistNameLabel;
    private javax.swing.JTextField PlaylistNameTextField;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel TracksLabel;
    private javax.swing.JList<String> TracksList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
