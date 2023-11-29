package spaceShips;

import java.awt.Color;

import javax.swing.ImageIcon;

//SpaceShipZERO class, extending the SpaceShip class
public class SpaceShipZERO extends SpaceShip{

    // ImageIcon for the ZERO spaceship
    static ImageIcon  icon = new ImageIcon("./Resources/images/ZERO.png");

    // Constructor for SpaceShipZERO
    public SpaceShipZERO () {

        // Call the constructor of the base class (SpaceShip) with specific parameters
        super("ZERO", 5, 1,icon, Color.MAGENTA );

    }


}
