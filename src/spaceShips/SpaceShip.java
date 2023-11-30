package spaceShips;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import gameSounds.*;
import mainPacket.*;
import spaceShips_LaserGuns.*;


// SpaceShip class implementing the Navigation interface
public class SpaceShip implements Navigation {

    // Fields for spaceship properties
    private final Color laserColor;
    private final int power;
    private final int speed;
    private final String name;
    private final ImageIcon image;

    // Constants for cosmos and spaceship dimensions
    private static final int cosmosHeight = MainClass.cosmosHeight;
    private static final int cosmosWidth = MainClass.cosmosWidth;
    private static final int shipWidth = MainClass.spaceShipWidth;
    private static final int shipHeight = MainClass.spaceShipHeight;

    // Initial coordinates for player and enemy spaceships
    protected int xCoord;
    protected int yCoord;
    protected int starting_x = 0;
    protected int enemy_s_x = cosmosWidth - (3 * shipWidth);
    protected int starting_y = cosmosHeight - shipHeight;
    protected int enemy_s_y =  shipHeight-30;

    // List to store laser shooters
    public LinkedList<Laser> laserShootersLinkedList = new LinkedList<>();

    // Constructor for SpaceShip class
    public SpaceShip(String name, int speed, int power, ImageIcon image, Color laserColor) {
        this.name = name;
        this.speed = speed;
        this.power = power;
        this.image = image;
        this.laserColor = laserColor;

        // Set initial coordinates based on spaceship type
        if (this.name.equals("ENEMY")) {
            this.xCoord = enemy_s_x;
            this.yCoord = enemy_s_y;
        }
        else {
            this.xCoord = starting_x;
            this.yCoord = starting_y;
        }
    }

    // Getter and Setter methods for various properties
    public int getSpeed() {
        return speed;
    }
    public int get_shipWidth() {
        return shipWidth;
    }
    public final int get_cosmosHeight() {
        return cosmosHeight;
    }
    public Color getLaserColor() {
        return laserColor;
    }
    public String getName() {
        return name;
    }
    public ImageIcon getImage() {
        return image;
    }
    public final int get_cosmosWidth() {
        return cosmosWidth;
    }
    public final int get_shipHeight() {
        return shipHeight;
    }
    public final int get_XCoord() {
        return xCoord;
    }
    public final void set_XCoord(int step) {
        this.xCoord = step;
    }
    public final int get_YCoord() {
        return yCoord;
    }
    public final void set_YCoord(int step) {
        this.yCoord = step;
    }

    // Check if the coordinates are within the cosmos boundaries
    public final boolean checkCoords() {
        if (this.xCoord < 0 || this.xCoord > this.get_cosmosWidth()) {
            return false;
        } else if (this.yCoord < 0 || this.yCoord > this.get_cosmosHeight()) {
            return false;
        } else if ((this.xCoord + shipWidth) < 0 || (this.xCoord + shipWidth > this.get_cosmosWidth())) {
            return false;
        } else return (this.yCoord + get_shipHeight()) >= 0 && (this.yCoord + get_shipHeight() <= this.get_cosmosHeight());
    }

    // Override methods from the Navigation interface to implement spaceship movements
    //This method moves the spaceship up, if not possible returns message Invalid Movement
    //Also it does not move the spaceship if not possible
    @Override
    public final int moveUP() {
        this.yCoord += this.speed;
        if (checkCoords()) {
            return this.yCoord;
        } else {
            System.out.println("Invalid Movement!");
            this.yCoord -= this.speed;
        }
        return this.yCoord;
    }
    //This method moves the spaceship Down, if not possible returns message Invalid Movement
    //Also it does not move the spaceship if not possible
    @Override
    public final int moveDown() {
        this.yCoord -= this.speed;
        if (checkCoords()) {
            return this.yCoord;
        } else {
            System.out.println("Invalid Movement!");
            this.yCoord += this.speed;
        }
        return this.yCoord;
    }
    //This method moves the spaceship Left, if not possible returns message Invalid Movement
    //Also it does not move the spaceship if not possible
    @Override
    public final int moveLeft() {
        this.xCoord -= this.speed;
        if (checkCoords()) {
            return this.xCoord;
        } else {
            System.out.println("Invalid Movement!");
            this.xCoord += this.speed;
        }
        return this.xCoord;
    }
    //This method moves the spaceship Right, if not possible returns message Invalid Movement
    //Also it does not move the spaceship if not possible
    @Override
    public final int moveRight() {
        this.xCoord += this.speed;
        if (checkCoords()) {
            return this.xCoord;
        } else {
            System.out.println("Invalid Movement!");
            this.xCoord -= this.speed;
        }
        return this.xCoord;
    }

    // Method to fire lasers and add them to the list
    public final void fireLaser() {
        laserShootersLinkedList.add(laserShootersLinkedList.size(), new Laser(this.xCoord, this.yCoord, this.power));
        @SuppressWarnings("unused")
        LaserSound audioPlayer = new LaserSound();
    }
    // Method to print current coordinates
    public void printCoords() {
        System.out.println(this + ": X: " + this.xCoord + " Y: " + this.yCoord);
        System.out.println("_______________________________");
    }

    public boolean checkIfHit(SpaceShip enemy) {
        boolean[] hit = {false};
        int width = this.get_shipWidth();

        this.laserShootersLinkedList.forEach(tmp -> {
            if (tmp.y > this.get_cosmosHeight()) {
                // Laser is out of bounds, remove it or handle as needed
                return;
            }
            // Check if the laser's coordinates overlap with the spaceship's coordinates
            if (tmp.x >= enemy.get_XCoord() && tmp.x <= (enemy.get_XCoord() + enemy.get_shipWidth())
                    && tmp.y >= enemy.get_YCoord() && tmp.y <= (enemy.get_YCoord() + enemy.get_shipHeight())) {
                System.out.println(tmp + "\t\t\tinside");
                hit[0] = true;
            } else {
                System.out.println(tmp + "\toutside");
            }
            tmp.y = tmp.y + 15;
        });
        return hit[0];
    }
}
