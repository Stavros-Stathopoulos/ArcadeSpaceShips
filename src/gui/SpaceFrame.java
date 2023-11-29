package gui;

import java.awt.CardLayout;
import java.io.Serial;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gameSounds.GameAudioPlayer;

// SpaceFrame class representing the main JFrame for the space shooting game
public class SpaceFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    // Static references to screens and layout
    static int width, height;
    static SelectSpaceShipScreen selectSpaceShipScreen = new SelectSpaceShipScreen();
    static GamePlayScreen gamePlayScreen = new GamePlayScreen();
    static CardLayout cardLayout = new CardLayout();
    static JPanel spaceFramePanel = new JPanel();

    // Constructor for SpaceFrame
    public SpaceFrame(int width, int height) {
        SpaceFrame.width = width;
        SpaceFrame.height = height;

        // Initialize the game audio player
        @SuppressWarnings("unused")
        GameAudioPlayer audioPlayer = new GameAudioPlayer();

        // Set icon image and frame properties
        this.setIconImage(new ImageIcon("./Resources/images/ENEMY.png").getImage());
        this.setSize(width, height);
        this.setTitle("Spaceship Shooting Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setupMasterPanel();
        this.setResizable(false);
        this.setVisible(true);
    }

    // Method to set up the master panel with card layout
    private void setupMasterPanel() {
        spaceFramePanel.setLayout(cardLayout);
        spaceFramePanel.add(selectSpaceShipScreen, "Selection screen");
        spaceFramePanel.add(gamePlayScreen, "GamePlay screen");

        this.add(spaceFramePanel);
    }
}
