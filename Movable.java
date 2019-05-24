/**
 * Movable (abstract) - represents properties of movable objects (players and enemies)
 * @author Rupin Mittal
 * @version May 24, 2019
 */

public abstract class Movable
{
    //variables
    private double xPos;    //the horizontal position in pixels
    private double yPos;    //the vertical position in pixels
    private double xVel;    //the horizontal velocity
    private double yVel;    //the vertical velocity

    /**
     * Abstract method to move object
     * Will be implemented uniquely in subclasses
     */
    public abstract void move();    //method to move the object, implemented in subclasses

    /**
     * Abstract method to update animation of moving object
     * Will be implemented uniquely in subclasses
     */
    public abstract void updateAnimation();     //method to update animation of moving objects, implemented in subclasses

    /**
     * Method to set the horizontal position of object
     * @param x double horizontal position in pixels
     */
    public void setXpos
}
