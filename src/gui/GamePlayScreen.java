package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import spaceShips.SpaceShip;
import spaceShips.SpaceShipENEMY;

// GamePlayScreen class for the gameplay screen
public class GamePlayScreen extends JPanel implements KeyListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private SpaceShip userSpaceShip;
    private final SpaceShipENEMY enemy = new SpaceShipENEMY();

    // Constructor for GamePlayScreen
    GamePlayScreen() {
        addKeyListener(this);
        this.setVisible(true);
        this.add(createCenterPanel(), BorderLayout.CENTER);
        this.setBackground(Color.BLACK);
        createDaemon();
    }

    // Method to create a daemon for periodic updates
    private void createDaemon() {
        Timer timer = new Timer();
        TimerTask task = new MonitorDaemonGame();
        timer.schedule(task, 200, 200);
    }

    // Inner class for the monitoring daemon
    class MonitorDaemonGame extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }

    // Method to create the center panel
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBackground(Color.BLACK);
        return panel;
    }

    // Method to paint the component
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon enemyImage;


        enemy.huntUserSpaceShip(userSpaceShip);
        super.paintComponent(g);

        // Set the user icon based on the user's spaceship selection
        ImageIcon user= userSpaceShip.getImage();


        // Draw the user's spaceship
        user.paintIcon(this, g, userSpaceShip.get_XCoord(), userSpaceShip.get_YCoord());

        // Draw the enemy spaceship
        enemyImage = enemy.getImage();
        enemyImage.paintIcon(this, g, enemy.get_XCoord(), enemy.get_YCoord());

        // Show laser shootings for both player and enemy
        showLaserShootings(g, enemy);
        showLaserShootings(g, userSpaceShip);




        if(userSpaceShip.checkIfHit(enemy)){
            //System.out.println("User hit enemy");
            enemy.setLifes(enemy.getPower()-userSpaceShip.getPower());
        }
        else if (enemy.checkIfHit(userSpaceShip)){
            //System.out.println("Enemy hit user");
            userSpaceShip.setLifes(userSpaceShip.getLifes()-enemy.getPower());
        }
        if(enemy.getLifes()<=0){
            System.out.println("Enemy died User Won!");
            SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);

        }else if (userSpaceShip.getLifes()<=0){
            System.out.println("User died Enemy Won!");
            SpaceFrame.cardLayout.last(SpaceFrame.spaceFramePanel);
        }

    }

    // Method to handle key pressed events
    @Override
    public void keyPressed(KeyEvent e) {
        // Handle different key presses to control the user's spaceship
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            userSpaceShip.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            userSpaceShip.moveUP();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            userSpaceShip.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            userSpaceShip.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_B) {
            // Switch to the next card in the card layout
            SpaceFrame.cardLayout.first(SpaceFrame.spaceFramePanel);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Fire a laser from the user's  spaceship
            userSpaceShip.fireLaser();
        }
    }

    // Method to handle key released events
    @Override
    public void keyReleased(KeyEvent e) {}

    // Method to handle key typed events
    @Override
    public void keyTyped(KeyEvent e) {}

    // Method to set the user's spaceship
    void setUserSpaceShip(SpaceShip userSpaceShip) {
        this.userSpaceShip = userSpaceShip;
    }

    // Method to show laser shootings
    private void showLaserShootings(Graphics g, SpaceShip s) {
        s.laserShootersLinkedList.forEach((tmp) -> {
            g.setColor(s.getLaserColor());
            if (s.getName().equals("ENEMY")) {
                g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y + 15);
                tmp.y = tmp.y + 15;
            }
            else {
                g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y - 15);
                tmp.y = tmp.y - 15;
            }
        });
    }
}
