package spaceShips;

import java.awt.Color;
import javax.swing.ImageIcon;

// SpaceShipDELTA class, extending the SpaceShip class
public class SpaceShipDELTA extends SpaceShip {

    // ImageIcon for the DELTA spaceship
    static ImageIcon icon = new ImageIcon("./Resources/images/DELTA.png");

    // Constructor for SpaceShipDELTA
    public SpaceShipDELTA() {
        // Call the constructor of the base class (SpaceShip) with specific parameters
        super("DELTA", 40, 5, icon, Color.MAGENTA);
    }
}
