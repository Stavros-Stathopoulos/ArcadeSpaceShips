package spaceShips_LaserGuns;

import java.awt.Color;
import java.util.LinkedList;

// LaserGun class representing a gun that can fire lasers
public class LaserGun {

    // Fields for laser gun properties
    public Color laserColor;
    public int Power;
    public LinkedList<Laser> laserShootersLinkedList = new LinkedList<Laser>();

    // Constructor for LaserGun
    public LaserGun(Color laserColor, int Power) {
        this.laserColor = laserColor;
        this.Power = Power;
    }

    // Method to fire a laser and add it to the list
    public void fire(int x, int y) {
        laserShootersLinkedList.add(laserShootersLinkedList.size(), new Laser(x, y, Power));
    }
}
