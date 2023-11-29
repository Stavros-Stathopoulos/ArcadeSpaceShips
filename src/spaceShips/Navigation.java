package spaceShips;

// Navigation interface with methods for spaceship movement
public interface Navigation {
    int moveUP();     // Returns the updated y-coordinate after moving up
    int moveDown();   // Returns the updated y-coordinate after moving down
    int moveLeft();   // Returns the updated x-coordinate after moving left
    int moveRight();  // Returns the updated x-coordinate after moving right
}
