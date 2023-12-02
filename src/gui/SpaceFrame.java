package gui;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;

import gameSounds.GameAudioPlayer;
import mainPacket.MainGUI;

// SpaceFrame class representing the main JFrame for the space shooting game
public class SpaceFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    // Static references to screens and layout
    static int width, height;
    static SelectSpaceShipScreen selectSpaceShipScreen = new SelectSpaceShipScreen();
    static GamePlayScreen gamePlayScreen = new GamePlayScreen();
    static GameOverScreenUser GameOverScreenUser = new GameOverScreenUser();
    static GameOverScreenEnemy GameOverScreenEnemy = new GameOverScreenEnemy();
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
        spaceFramePanel.add(GameOverScreenUser, "Game Over screen");
        spaceFramePanel.add(GameOverScreenEnemy, "Game Over screen");

        this.add(spaceFramePanel);
    }

    static public JButton getButton() {
        JButton button = new JButton("Play Again");
        button.setFont(new Font("Arcade Classic", Font.ITALIC, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }

    static public  JLabel getText(String str){
        JLabel text = new JLabel(str, JLabel.CENTER);
        text.setFont(new Font("Arcade Classic", Font.ITALIC, 15));
        text.setForeground(Color.WHITE);
        return text;
    }
}
