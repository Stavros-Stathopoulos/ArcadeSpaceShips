package mainPacket;

import gui.*;

// MainGUI class for initializing and launching the space shooting game
public class MainGUI {

    // Constants for cosmos and spaceship dimensions
    public static int cosmosWidth = 800;
    public static int cosmosHeight = 650;
    //public static int spaceShipWidth = 100;
    //public static int spaceShipHeight = 100;

    // Y offset for GUI display
    //public static int yOffSet = 30;

    // Reference to the SpaceFrame representing the shooting game
    public static SpaceFrame myShootingGame;

    // Main method to start the application
    public static void main(String[] args) {
        // Create a new instance of SpaceFrame with specified dimensions
        myShootingGame = new SpaceFrame(cosmosWidth, cosmosHeight);
    }
}
