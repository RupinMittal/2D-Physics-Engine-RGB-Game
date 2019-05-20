import javafx.scene.canvas.*;
import javafx.scene.image.Image;

/**
 * The Display class helps display info onto a screen/canvas
 *
 * @author Jonathan
 * @version May 18 2019
 */
public class Display
{
    // Location of character
    private double myX;
    private double myY;
    
    // Speed of character
    private double myXVelocity;
    private double myYVelocity;
    
    // Size of character
    private double myHeight;
    private double myWidth;
    
    /**
     * Gets the x position
     * @return x position
     */
    public double getX()
    {
        return myX;
    }
    
    /**
     * Gets the y position
     * @return y position
     */
    public double getY()
    {
        return myY;
    }
    
    /**
     * Gets the x velocity
     * @return x velocity
     */
    public double getXvel()
    {
        return myXVelocity;
    }
    
    /**
     * Gets the y velocity
     * @return y velocity
     */
    public double getYvel()
    {
        return myYVelocity;
    }
    
    /**
     * Gets the image width
     * @return image width
     */
    public double getWidth()
    {
        return myWidth;
    }
    
    /**
     * Gets the image height
     * @return image height
     */
    public double getHeight()
    {
        return myHeight;
    }
    
    /**
     * Changes the position
     * @param x x value to change
     * @param y y value to change
     */
    public void setPosition(double x, double y)
    {
        myX = x;
        myY = y;
    }
    
    /**
     * Changes the velocity
     * @param xvel x velocity to change
     * @param yVel y velocity to change
     */
    public void setVelocity(double xVelocity, double yVelocity)
    {
        myXVelocity = xVelocity;
        myYVelocity = yVelocity;
    }
}
