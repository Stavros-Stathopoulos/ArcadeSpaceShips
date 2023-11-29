package spaceShips;

import java.awt.Color;
import javax.swing.ImageIcon;

// SpaceShipBETA class, extending the SpaceShip class
public class SpaceShipBETA extends SpaceShip {

    // ImageIcon for the BETA spaceship
    public static ImageIcon icon = new ImageIcon("./Resources/images/BETA.png");

    // Constructor for SpaceShipBETA
    public SpaceShipBETA() {
        // Call the constructor of the base class (SpaceShip) with specific parameters
        super("BETA", 20, 1, icon, Color.MAGENTA);
    }
}