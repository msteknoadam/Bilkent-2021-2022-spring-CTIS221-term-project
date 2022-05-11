/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author TEKNO
 */
public class MainFrame extends javax.swing.JFrame {

    AddTrackFrame add = new AddTrackFrame(this);
    CreatePlaylistFrame createP = new CreatePlaylistFrame(this);

    Track currentlyPlayingTrack = null;
    int progressSecondsPassed = 0;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.NotPlayingPanel.setVisible(true);
        this.TrackPlayingPanel.setVisible(false);
        this.SongDetailsPanel.setVisible(false);
        this.PodcastDetailsPanel.setVisible(false);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(() -> this.updateProgressBar(), 0, 1, TimeUnit.SECONDS);
    }

    public void updateProgressBar() {
        if (this.currentlyPlayingTrack != null && this.PlayPauseButton.isSelected()) {
            if (this.progressSecondsPassed < this.currentlyPlayingTrack.length) {
                this.progressSecondsPassed++;
                this.TrackProgressBar.setValue((int) Math.round(this.progressSecondsPassed / this.currentlyPlayingTrack.length * 100));
            } else {
                this.PlayPauseButton.setSelected(false);
                this.TrackProgressBar.setValue(100);
            }
        }
    }

    public void setTrackFilesCombobox() {
        String[] arr = new String[TrackSys.trackPaths.size()];

        int i = 0;
        for (String file : TrackSys.trackPaths) {
            arr[i] = file.split("/")[1]; // so that directory part is removed
            i++;
        }

        this.add.getTrackFileCombobox().setModel(new DefaultComboBoxModel(arr));
    }

    public void setImageFilesCombobox() {
        String[] arr = new String[TrackSys.imagePaths.size()];

        int i = 0;
        for (String file : TrackSys.imagePaths) {
            arr[i] = file.split("/")[1]; // so that directory part is removed
            i++;
        }

        this.add.getImageFileCombobox().setModel(new DefaultComboBoxModel(arr));
    }

    public void updateTracksList() {
        DefaultListModel model = new DefaultListModel();

        for (Track t : TrackSys.tracks) {
            model.addElement(t.name);
        }

        this.TracksList.setModel(model);

        int totalSeconds = (int) TrackSys.calculateTotalLength();
        int minutes = totalSeconds / 60;
        int leftoverSeconds = totalSeconds % 60;
        this.TotalTracksLengthTextField.setText(minutes + " minutes " + leftoverSeconds + " seconds");
    }

    public void updatePlaylistsList() {
        DefaultListModel model = new DefaultListModel();

        for (Playlist p : TrackSys.playlists) {
            model.addElement(p.getName());
        }

        this.PlaylistsList.setModel(model);

        this.NonUniquePlaylistCountTextField.setText(String.valueOf(Playlist.getPlaylistCount()));
        this.UniquePlaylistCountTextField.setText(String.valueOf(TrackSys.playlists.size()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NotPlayingPanel = new javax.swing.JPanel();
        notPlayingLabel = new javax.swing.JLabel();
        TrackPlayingPanel = new javax.swing.JPanel();
        TrackThumbLabel = new javax.swing.JLabel();
        TrackProgressBar = new javax.swing.JProgressBar();
        ShowCreditsButton = new javax.swing.JButton();
        SeekTrackStartButton = new javax.swing.JButton();
        SeekTrackEndButton = new javax.swing.JButton();
        PlayPauseButton = new javax.swing.JToggleButton();
        LikeDislikeButton = new javax.swing.JToggleButton();
        StopButton = new javax.swing.JButton();
        SongDetailsPanel = new javax.swing.JPanel();
        ArtistLabel = new javax.swing.JLabel();
        AlbumNameLabel = new javax.swing.JLabel();
        GenreLabel = new javax.swing.JLabel();
        ArtistTextField = new javax.swing.JTextField();
        AlbumNameTextField = new javax.swing.JTextField();
        GenreTextField = new javax.swing.JTextField();
        PodcastDetailsPanel = new javax.swing.JPanel();
        EpisodeLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        PodcasterLabel = new javax.swing.JLabel();
        EpisodeTextField = new javax.swing.JTextField();
        DescriptionTextField = new javax.swing.JTextField();
        PodcasterTextField = new javax.swing.JTextField();
        addTrackButton = new javax.swing.JButton();
        trackListScrollPane = new javax.swing.JScrollPane();
        TracksList = new javax.swing.JList<>();
        playlistListScrollPane = new javax.swing.JScrollPane();
        PlaylistsList = new javax.swing.JList<>();
        createPlaylistButton = new javax.swing.JButton();
        TotalTracksLengthLabel = new javax.swing.JLabel();
        TotalTracksLengthTextField = new javax.swing.JTextField();
        NonUniquePlaylistCountLabel = new javax.swing.JLabel();
        NonUniquePlaylistCountTextField = new javax.swing.JTextField();
        UniquePlaylistCountLabel = new javax.swing.JLabel();
        UniquePlaylistCountTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notPlayingLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        notPlayingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notPlayingLabel.setText("NOTHING IS PLAYING");

        javax.swing.GroupLayout NotPlayingPanelLayout = new javax.swing.GroupLayout(NotPlayingPanel);
        NotPlayingPanel.setLayout(NotPlayingPanelLayout);
        NotPlayingPanelLayout.setHorizontalGroup(
            NotPlayingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotPlayingPanelLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(notPlayingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        NotPlayingPanelLayout.setVerticalGroup(
            NotPlayingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotPlayingPanelLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(notPlayingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jPanel1.add(NotPlayingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 160));

        TrackPlayingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TrackThumbLabel.setText("TrackThumbnail");
        TrackPlayingPanel.add(TrackThumbLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 120));
        TrackThumbLabel.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        TrackPlayingPanel.add(TrackProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 540, -1));
        TrackProgressBar.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        ShowCreditsButton.setText("Show Credits");
        ShowCreditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCreditsButtonActionPerformed(evt);
            }
        });
        TrackPlayingPanel.add(ShowCreditsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));
        ShowCreditsButton.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        SeekTrackStartButton.setText("<");
        SeekTrackStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeekTrackStartButtonActionPerformed(evt);
            }
        });
        TrackPlayingPanel.add(SeekTrackStartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));
        SeekTrackStartButton.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        SeekTrackEndButton.setText(">");
        SeekTrackEndButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeekTrackEndButtonActionPerformed(evt);
            }
        });
        TrackPlayingPanel.add(SeekTrackEndButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));
        SeekTrackEndButton.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        PlayPauseButton.setText("PLAY");
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });
        TrackPlayingPanel.add(PlayPauseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));
        PlayPauseButton.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        LikeDislikeButton.setText("LIKE");
        LikeDislikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LikeDislikeButtonActionPerformed(evt);
            }
        });
        TrackPlayingPanel.add(LikeDislikeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));
        LikeDislikeButton.getAccessibleContext().setAccessibleParent(TrackPlayingPanel);

        StopButton.setText("STOP");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
        TrackPlayingPanel.add(StopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        ArtistLabel.setText("Artist:");

        AlbumNameLabel.setText("Album Name:");

        GenreLabel.setText("Genre:");

        ArtistTextField.setEditable(false);
        ArtistTextField.setText("ArtistTextField");

        AlbumNameTextField.setEditable(false);
        AlbumNameTextField.setText("AlbumNameTextField");

        GenreTextField.setEditable(false);
        GenreTextField.setText("GenreTextField");

        javax.swing.GroupLayout SongDetailsPanelLayout = new javax.swing.GroupLayout(SongDetailsPanel);
        SongDetailsPanel.setLayout(SongDetailsPanelLayout);
        SongDetailsPanelLayout.setHorizontalGroup(
            SongDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SongDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(ArtistLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ArtistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AlbumNameLabel)
                .addGap(18, 18, 18)
                .addComponent(AlbumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenreLabel)
                .addGap(18, 18, 18)
                .addComponent(GenreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        SongDetailsPanelLayout.setVerticalGroup(
            SongDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SongDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SongDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArtistLabel)
                    .addComponent(AlbumNameLabel)
                    .addComponent(GenreLabel)
                    .addComponent(ArtistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlbumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TrackPlayingPanel.add(SongDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 160));

        EpisodeLabel.setText("Episode:");

        DescriptionLabel.setText("Description:");

        PodcasterLabel.setText("Podcaster:");

        EpisodeTextField.setEditable(false);
        EpisodeTextField.setText("EpisodeTextField");

        DescriptionTextField.setEditable(false);
        DescriptionTextField.setText("DescriptionTextField");

        PodcasterTextField.setEditable(false);
        PodcasterTextField.setText("PodcasterTextField");

        javax.swing.GroupLayout PodcastDetailsPanelLayout = new javax.swing.GroupLayout(PodcastDetailsPanel);
        PodcastDetailsPanel.setLayout(PodcastDetailsPanelLayout);
        PodcastDetailsPanelLayout.setHorizontalGroup(
            PodcastDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PodcastDetailsPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(EpisodeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EpisodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(DescriptionLabel)
                .addGap(3, 3, 3)
                .addComponent(DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PodcasterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PodcasterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        PodcastDetailsPanelLayout.setVerticalGroup(
            PodcastDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PodcastDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PodcastDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EpisodeLabel)
                    .addComponent(DescriptionLabel)
                    .addComponent(PodcasterLabel)
                    .addComponent(EpisodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PodcasterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TrackPlayingPanel.add(PodcastDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 160));

        jPanel1.add(TrackPlayingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 160));

        addTrackButton.setText("Add Track");
        addTrackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrackButtonActionPerformed(evt);
            }
        });

        TracksList.setBorder(javax.swing.BorderFactory.createTitledBorder("Added Tracks"));
        TracksList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TracksList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TracksListValueChanged(evt);
            }
        });
        trackListScrollPane.setViewportView(TracksList);

        PlaylistsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Playlists"));
        PlaylistsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PlaylistsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                PlaylistsListValueChanged(evt);
            }
        });
        playlistListScrollPane.setViewportView(PlaylistsList);

        createPlaylistButton.setText("Create Playlist");
        createPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlaylistButtonActionPerformed(evt);
            }
        });

        TotalTracksLengthLabel.setText("Total Tracks Length:");

        TotalTracksLengthTextField.setEditable(false);
        TotalTracksLengthTextField.setText("0 minutes 0 seconds");

        NonUniquePlaylistCountLabel.setText("Non-Unique Playlist Count:");

        NonUniquePlaylistCountTextField.setEditable(false);
        NonUniquePlaylistCountTextField.setText("0");

        UniquePlaylistCountLabel.setText("Unique Playlist Count:");

        UniquePlaylistCountTextField.setEditable(false);
        UniquePlaylistCountTextField.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(trackListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(playlistListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createPlaylistButton)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addTrackButton)
                                .addGap(10, 10, 10)))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TotalTracksLengthLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalTracksLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NonUniquePlaylistCountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NonUniquePlaylistCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UniquePlaylistCountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UniquePlaylistCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(addTrackButton)
                        .addGap(18, 18, 18)
                        .addComponent(createPlaylistButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(trackListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playlistListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalTracksLengthLabel)
                    .addComponent(TotalTracksLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NonUniquePlaylistCountLabel)
                    .addComponent(NonUniquePlaylistCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UniquePlaylistCountLabel)
                    .addComponent(UniquePlaylistCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTrackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrackButtonActionPerformed
        this.setTrackFilesCombobox();
        this.setImageFilesCombobox();
        this.add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addTrackButtonActionPerformed

    private void TracksListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TracksListValueChanged
        if (!evt.getValueIsAdjusting() && this.TracksList.getSelectedValue() != null) {
            Track found = TrackSys.searchTrack(this.TracksList.getSelectedValue());

            if (found != null) {
                this.currentlyPlayingTrack = found;
                this.progressSecondsPassed = 0;
                this.TrackProgressBar.setValue(0);
                this.NotPlayingPanel.setVisible(false);
                this.TrackPlayingPanel.setVisible(true);
                this.LikeDislikeButton.setSelected(found.liked);
                this.TrackThumbLabel.setIcon(found.thumbnailImage);

                if (found instanceof Song) {
                    this.SongDetailsPanel.setVisible(true);
                    this.PodcastDetailsPanel.setVisible(false);

                    this.ArtistTextField.setText(((Song) found).getArtist());
                    this.AlbumNameTextField.setText(((Song) found).getAlbumName());
                    this.GenreTextField.setText(((Song) found).getGenre());
                } else if (found instanceof PodcastEpisode) {
                    this.PodcastDetailsPanel.setVisible(true);
                    this.SongDetailsPanel.setVisible(false);

                    this.EpisodeTextField.setText(((PodcastEpisode) found).getEpisode());
                    this.DescriptionTextField.setText(((PodcastEpisode) found).getDescription());
                    this.PodcasterTextField.setText(((PodcastEpisode) found).getPodcaster());
                }
            }
        }
    }//GEN-LAST:event_TracksListValueChanged

    private void LikeDislikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LikeDislikeButtonActionPerformed
        if (this.currentlyPlayingTrack != null) {
            this.LikeDislikeButton.setSelected(this.currentlyPlayingTrack.toggleLike());
        }
    }//GEN-LAST:event_LikeDislikeButtonActionPerformed

    private void ShowCreditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCreditsButtonActionPerformed
        if (this.currentlyPlayingTrack != null) {
            this.currentlyPlayingTrack.showCredits();
        }
    }//GEN-LAST:event_ShowCreditsButtonActionPerformed

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        this.currentlyPlayingTrack = null;
        this.PlayPauseButton.setSelected(false);
        this.TracksList.clearSelection();
        this.NotPlayingPanel.setVisible(true);
        this.TrackPlayingPanel.setVisible(false);
        this.SongDetailsPanel.setVisible(false);
        this.PodcastDetailsPanel.setVisible(false);
    }//GEN-LAST:event_StopButtonActionPerformed

    private void SeekTrackStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeekTrackStartButtonActionPerformed
        this.progressSecondsPassed = 0;
        this.TrackProgressBar.setValue(0);
    }//GEN-LAST:event_SeekTrackStartButtonActionPerformed

    private void SeekTrackEndButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeekTrackEndButtonActionPerformed
        if (this.currentlyPlayingTrack != null) {
            this.progressSecondsPassed = (int) this.currentlyPlayingTrack.length;
        }
    }//GEN-LAST:event_SeekTrackEndButtonActionPerformed

    private void PlayPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseButtonActionPerformed
        if (this.TrackProgressBar.getValue() == 100) {
            this.progressSecondsPassed = 0;
        }
    }//GEN-LAST:event_PlayPauseButtonActionPerformed

    private void createPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlaylistButtonActionPerformed
        this.createP.updateTracksList();
        this.createP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createPlaylistButtonActionPerformed

    private void PlaylistsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_PlaylistsListValueChanged
        if (!evt.getValueIsAdjusting() && this.PlaylistsList.getSelectedValue() != null) {
            Playlist found = TrackSys.searchPlaylist(this.PlaylistsList.getSelectedValue());

            if (found != null) {
                CreditsFrame frame = new CreditsFrame(found.toString());
                frame.setVisible(true);
            }
        }
    }//GEN-LAST:event_PlaylistsListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumNameLabel;
    private javax.swing.JTextField AlbumNameTextField;
    private javax.swing.JLabel ArtistLabel;
    private javax.swing.JTextField ArtistTextField;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextField DescriptionTextField;
    private javax.swing.JLabel EpisodeLabel;
    private javax.swing.JTextField EpisodeTextField;
    private javax.swing.JLabel GenreLabel;
    private javax.swing.JTextField GenreTextField;
    private javax.swing.JToggleButton LikeDislikeButton;
    private javax.swing.JLabel NonUniquePlaylistCountLabel;
    private javax.swing.JTextField NonUniquePlaylistCountTextField;
    private javax.swing.JPanel NotPlayingPanel;
    private javax.swing.JToggleButton PlayPauseButton;
    private javax.swing.JList<String> PlaylistsList;
    private javax.swing.JPanel PodcastDetailsPanel;
    private javax.swing.JLabel PodcasterLabel;
    private javax.swing.JTextField PodcasterTextField;
    private javax.swing.JButton SeekTrackEndButton;
    private javax.swing.JButton SeekTrackStartButton;
    private javax.swing.JButton ShowCreditsButton;
    private javax.swing.JPanel SongDetailsPanel;
    private javax.swing.JButton StopButton;
    private javax.swing.JLabel TotalTracksLengthLabel;
    private javax.swing.JTextField TotalTracksLengthTextField;
    private javax.swing.JPanel TrackPlayingPanel;
    private javax.swing.JProgressBar TrackProgressBar;
    private javax.swing.JLabel TrackThumbLabel;
    private javax.swing.JList<String> TracksList;
    private javax.swing.JLabel UniquePlaylistCountLabel;
    private javax.swing.JTextField UniquePlaylistCountTextField;
    private javax.swing.JButton addTrackButton;
    private javax.swing.JButton createPlaylistButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel notPlayingLabel;
    private javax.swing.JScrollPane playlistListScrollPane;
    private javax.swing.JScrollPane trackListScrollPane;
    // End of variables declaration//GEN-END:variables
}
