package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gameSounds.SelectionSound;
import spaceShips.*;

// SelectSpaceShipScreen class for the spaceship selection screen
public class SelectSpaceShipScreen extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;

    // Panels for layout
    public static JPanel southPanel = createSouthPanel();
    public static ArrayList<SpaceShip> spaceShips;

    // Constructor for SelectSpaceShipScreen
    public SelectSpaceShipScreen() {
        // Initialize the list of spaceships
        spaceShips = new ArrayList<>();
        spaceShips.add(new SpaceShipZERO());
        spaceShips.add(new SpaceShipALPHA());
        spaceShips.add(new SpaceShipBETA());
        spaceShips.add(new SpaceShipGAMA());
        spaceShips.add(new SpaceShipDELTA());

        // Set the layout and add panels to the screen
        this.setLayout(new BorderLayout(0, 0));
        this.add(createNorthPanel(), BorderLayout.NORTH);
        this.add(createCenterPanel(), BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);


    }

    // Method to create the south panel
    private static JPanel createSouthPanel() {
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setLayout(new GridLayout());
        southPanel.setBackground(Color.BLACK);
        JLabel text = new JLabel("Right click: select your spacecraft \n Left click: Info about your spacecraft", JLabel.CENTER);
        text.setFont(new Font("Arcade Classic", Font.ITALIC, 10));
        text.setForeground(Color.WHITE);
        southPanel.add(text);

        return southPanel;
    }

    // Method to create the center panel with spaceship selection buttons
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBackground(Color.BLACK);

        // Button for SpaceShipZERO
        JButton buttonZero = new JButton();
        buttonZero.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    new RightClickPressed(spaceShips.get(0).getName());
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    updateSouthPanel(spaceShips.get(0));
                }
            }
        });
        buttonZero.setBackground(Color.BLACK);
        buttonZero.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonZero.setIcon(spaceShips.get(0).getImage());

        // Button for SpaceShipALPHA
        JButton buttonAlpha = new JButton();
        buttonAlpha.setBackground(Color.BLACK);
        buttonAlpha.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonAlpha.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    new RightClickPressed(spaceShips.get(1).getName());
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    updateSouthPanel(spaceShips.get(1));
                }
            }
        });
        buttonAlpha.setIcon(spaceShips.get(1).getImage());

        // Button for SpaceShipBETA
        JButton buttonBeta = new JButton();
        buttonBeta.setBackground(Color.BLACK);
        buttonBeta.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonBeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    new RightClickPressed(spaceShips.get(2).getName());
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    updateSouthPanel(spaceShips.get(2));
                }
            }
        });
        buttonBeta.setIcon(spaceShips.get(2).getImage());

        // Button for SpaceShipGAMA
        JButton buttonGama = new JButton();
        buttonGama.setBackground(Color.BLACK);
        buttonGama.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonGama.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    new RightClickPressed(spaceShips.get(3).getName());
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    updateSouthPanel(spaceShips.get(3));
                }
            }
        });
        buttonGama.setIcon(spaceShips.get(3).getImage());

        // Button for SpaceShipDELTA
        JButton buttonDelta = new JButton();
        buttonDelta.setBackground(Color.BLACK);
        buttonDelta.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonDelta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    new RightClickPressed(spaceShips.get(4).getName());
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    updateSouthPanel(spaceShips.get(4));
                }
            }
        });
        buttonDelta.setIcon(spaceShips.get(4).getImage());

        // Add buttons to the panel
        panel.add(buttonZero);
        panel.add(buttonAlpha);
        panel.add(buttonBeta);
        panel.add(buttonGama);
        panel.add(buttonDelta);

        return panel;
    }

    // Method to create the north panel with a label
    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel("Choose Your Spaceship... ", JLabel.CENTER);
        label.setFont(new Font("Arcade Classic", Font.ITALIC, 25));
        label.setForeground(Color.WHITE);

        panel.add(label);
        return panel;
    }

    // Inner class to handle right-click events on spaceship buttons
    static class RightClickPressed {
        String name;

        public RightClickPressed(String x) {
            name = x;
            @SuppressWarnings("unused")
            SelectionSound AudioPlayer = new SelectionSound();
            SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
            SpaceFrame.gamePlayScreen.setFocusable(true);
            SpaceFrame.gamePlayScreen.requestFocus();
            if (name.equalsIgnoreCase(spaceShips.get(0).getName())) SpaceFrame.gamePlayScreen.setUserSpaceShip(spaceShips.get(0));
            if (name.equalsIgnoreCase(spaceShips.get(1).getName())) SpaceFrame.gamePlayScreen.setUserSpaceShip(spaceShips.get(1));
            if (name.equalsIgnoreCase(spaceShips.get(2).getName())) SpaceFrame.gamePlayScreen.setUserSpaceShip(spaceShips.get(2));
            if (name.equalsIgnoreCase(spaceShips.get(3).getName())) SpaceFrame.gamePlayScreen.setUserSpaceShip(spaceShips.get(3));
            if (name.equalsIgnoreCase(spaceShips.get(4).getName())) SpaceFrame.gamePlayScreen.setUserSpaceShip(spaceShips.get(4));
        }
    }

    // Method to update the south panel with selected spaceship information
    public static void updateSouthPanel(SpaceShip ship) {
        southPanel.removeAll();
        @SuppressWarnings("unused")
        SelectionSound AudioPlayer = new SelectionSound();
        JLabel labelSpeed = new JLabel("Speed:" + ship.getSpeed() + " KM/Sec", JLabel.CENTER);
        labelSpeed.setFont(new Font("Arcade Classic", Font.ITALIC, 15));
        labelSpeed.setForeground(Color.WHITE);
        southPanel.add(labelSpeed);
        southPanel.revalidate();
        southPanel.repaint();
    }
}
