package spaceShips;

import java.awt.Image;
import java.awt.Color;
import java.util.Random;
import java.util.random.RandomGenerator;
import javax.swing.ImageIcon;

// SpaceShipENEMY class inherits from SpaceShip
public class SpaceShipENEMY extends SpaceShip {

    // ImageIcon for the ENEMY spaceship
    static ImageIcon tmp = new ImageIcon("./Resources/images/ENEMY.png");
    static Image enemyImage= tmp.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    static ImageIcon icon = new ImageIcon(enemyImage);
    // Constructor for SpaceShipENEMY
    public SpaceShipENEMY() {
        // Call the constructor of the base class (SpaceShip) with specific parameters
        super("ENEMY", 15, 1, icon, Color.CYAN);
    }

    // Method for randomizing enemy movements
    public void huntUserSpaceShip(SpaceShip userSpaceShip){
        int limit = 20;
        if (userSpaceShip.getSpeed() >25) limit = 10;
        RandomGenerator random = new Random();
        int mv = random.nextInt(limit);
        if(mv == 0 || mv == 1) this.fireLaser();
        int rnum = random.nextInt(150);
        if(userSpaceShip.get_XCoord() > this.get_XCoord()) {

            this.set_XCoord(userSpaceShip.get_XCoord() + rnum);
            if (!this.checkCoords()){
                this.set_XCoord(userSpaceShip.get_XCoord() - rnum);
            }
        }else {
            this.set_XCoord(userSpaceShip.get_XCoord() - rnum);
            if (!this.checkCoords()){
                this.set_XCoord(userSpaceShip.get_XCoord() + rnum);
            }
        }

        int res  = random.nextInt(4);
        if(res == 2) this.moveLeft();
        if(res == 3) this.moveRight();
    }
}
