package spaceShips_LaserGuns;

import mainPacket.MainClass;

// Laser class representing a laser fired from a spaceship
public class Laser {

    // Fields for laser properties
    public int x;
    public int y;
    int Power;

    // Constructor for Laser
    public Laser(int x, int y, int Power) {
        // Adjust the x-coordinate to the center of the spaceship
        this.x = x + MainClass.spaceShipWidth / 2;
        this.y = y;
        this.Power = Power;
    }
}