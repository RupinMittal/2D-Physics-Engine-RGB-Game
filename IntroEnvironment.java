/**
 * IntroEnvironment (child of Environment) - represents properties of the environment in the introduction
 * @author Rupin Mittal
 * @version May 23, 2019
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IntroEnvironment extends Environment
{
    private ImageView foreground;       //the imageView of the foreground (part of parallax effect)
    private ImageView background;       //the imageView of the foreground (part of parallax effect)
    //the normal map variable is declared from Environment class

    //constructor
    /**
     * Constructor for IntroEnvironment class
     * @param mapImage String that is png file name that comes from .json file for the map
     * @param foregroundImage String that is png file name that comes from .json file for the foreground
     * @param backgroundImage String that is png file name that comes from .json file for the background
     */
    public IntroEnvironment(String mapImage, String foregroundImage, String backgroundImage)
    {
        super(mapImage);                                                //call to create the collisionsArray
        foreground = new ImageView(new Image(foregroundImage, 0, 0, true, true));     //create the foreground imageview
        background = new ImageView(new Image(backgroundImage, 0, 0, true, true));     //create the foreground imageview
    }

    //methods
    /**
     * Method to get the foreground ImageView
     * @return ImageView foreground
     */
    public ImageView getForegroundImageView()
    {
        return foreground; //return the foreground imageView
    }

    /**
     * Method to get the background ImageView
     * @return ImageView background
     */
    public ImageView getBackgroungroundImageView()
    {
        return background; //return the background imageView
    }
}