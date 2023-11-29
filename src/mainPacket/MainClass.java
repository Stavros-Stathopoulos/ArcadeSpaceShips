package mainPacket;

import java.util.LinkedList;
import java.util.Scanner;

import spaceShips.*;

public class MainClass {

    // Define the dimensions of the cosmos and spaceships
    public static int cosmosWidth = 800;
    public static int cosmosHeight = 600;
    public static int spaceShipWidth = 100;
    public static int spaceShipHeight = 100;

    public static void main(String[] args) {
        // Create a linked list to store different types of spaceships

        LinkedList <SpaceShip> spaceShipList = new LinkedList<>();
        SpaceShip z = new SpaceShipZERO();
        SpaceShip a = new SpaceShipALPHA();
        SpaceShip b = new SpaceShipBETA();
        SpaceShip g = new SpaceShipGAMA();
        SpaceShip d = new SpaceShipDELTA();
        SpaceShip e = new SpaceShipENEMY();

        // Add spaceships to the list
        spaceShipList.add(z);
        spaceShipList.add(a);
        spaceShipList.add(b);
        spaceShipList.add(g);
        spaceShipList.add(d);
        spaceShipList.add(e);

        // Get user input for spaceship movements
        System.out.println("Enter command to test spaceships movements:");
        Scanner sc = new Scanner (System.in);

        // Continuously read user input and move spaceships accordingly
        while(sc.hasNext()) {
            String s1 = sc.next();
            int i = 0;

            // Iterate through the list of spaceships and move them based on user input
            while(i < spaceShipList.size()) {
                if (s1.equals("u"))spaceShipList.get(i).moveUP();
                if (s1.equals("d"))spaceShipList.get(i).moveDown();
                if (s1.equals("l"))spaceShipList.get(i).moveLeft();
                if (s1.equals("r"))spaceShipList.get(i).moveRight();
                spaceShipList.get(i).printCoords();
                i++;

            }
        }
        sc.close();


    }

}
