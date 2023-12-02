package spaceShips;

import java.awt.Color;
import javax.swing.ImageIcon;

//SpaceShipALPHA class, extending the SpaceShip class
public class SpaceShipALPHA extends SpaceShip{

    // ImageIcon for the ALPHA spaceship
    static ImageIcon  icon = new ImageIcon("./Resources/images/ALPHA.png");

    // Constructor for SpaceShipALPHA
    public SpaceShipALPHA () {

        // Call the constructor of the base class (SpaceShip) with specific parameters
        super("ALPHA", 10, 2,icon, Color.MAGENTA );

    }



}
