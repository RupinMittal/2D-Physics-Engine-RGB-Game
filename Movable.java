/**
 * Movable (abstract) - represents properties of movable objects (players and enemies)
 * @author Rupin Mittal
 * @version May 24, 2019
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Movable
{
    //variables
    protected double xVel;        //the horizontal velocity
    protected double yVel;        //the vertical velocity
    protected ImageView movableImageView;   //the image of the still movable object
    protected Image defaultImage;   //the image of the still movable object

    //methods
    /**
     * Abstract method to update animation of moving object
     * Will be implemented uniquely in subclasses
     */
    public abstract void updateAnimation();     //method to update animation of moving objects, implemented in subclasses

    /**
     * Method to set the horizontal position of object
     * @param xP double horizontal position in pixels
     */
    public void setXPos(double xP)
    {
        movableImageView.setX(xP);   //set the horizontal position
    }

    /**
     * Method to set the vertical position of object
     * @param yP double vertical position in pixels
     */
    public void setYPos(double yP)
    {
        movableImageView.setY(yP);   //set the vertical position
    }

    /**
     * Method to set the horizontal velocity of object
     * @param xV double horizontal velocity
     */
    public void setXVel(double xV)
    {
        xVel = xV;   //set the horizontal velocity
    }

    /**
     * Method to set the vertical velocity of object
     * @param yV double vertical velocity
     */
    public void setYVel(double yV)
    {
        yVel = yV;   //set the vertical velocity
    }

    /**
     * Method to get the horizontal position of object
     * @return xPos double horizontal position in pixels
     */
    public double getXPos()
    {
        return movableImageView.getX();   //get the horizontal position
    }

    /**
     * Method to get the vertical position of object
     * @return yPos double vertical position in pixels
     */
    public double getYPos()
    {
        return movableImageView.getY();   //get the horizontal position
    }

    /**
     * Method to get the horizontal velocity of object
     * @return xVel double horizontal velocity
     */
    public double getXVel()
    {
        return xVel;   //get the horizontal velocity
    }

    /**
     * Method to get the vertical velocity of object
     * @return yVel double vertical velocity
     */
    public double getYVel()
    {
        return yVel;   //get the vertical velocity
    }

    /**
     * Method to get the height of the picStill
     * @return double height of picStill in pixels
     */
    public double getHeight()
    {
        return defaultImage.getHeight();    //return the height
    }

    /**
     * Method to get the width of the picStill
     * @return double width of picStill in pixels
     */
    public double getWidth()
    {
        return defaultImage.getWidth();    //return the width
    }

    /**
     * Method to get the ImageView being used
     * @return ImageView the imagview of the movable
     */
    public ImageView getImageView()
    {
        return movableImageView;
    }
}